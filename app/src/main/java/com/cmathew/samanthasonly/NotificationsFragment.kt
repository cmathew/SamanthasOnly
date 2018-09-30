package com.cmathew.samanthasonly

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cmathew.samanthasonly.db.DatingDatabase
import com.cmathew.samanthasonly.db.Notification
import com.cmathew.samanthasonly.db.NotificationContract.NotificationType.NEW_MATCH
import com.cmathew.samanthasonly.db.NotificationContract.NotificationType.NEW_MESSAGE
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class NotificationsFragment : Fragment() {
	private lateinit var notificationList: RecyclerView
	private lateinit var notificationAdapter: NotificationAdapter

	@Inject
	lateinit var database: DatingDatabase

	val noteSubs: CompositeDisposable = CompositeDisposable()

	override fun onAttach(context: Context) {
		(context.applicationContext as DatingApplication).applicationComponent!!.inject(this)
		notificationAdapter = NotificationAdapter(context, object : ItemClickListener<Notification> {
			override fun onItemClick(item: Notification) {
				val doNext = when (item.type) {
					NEW_MATCH -> {
						val matchIntent = Intent(activity, MatchActivity::class.java)
						val matchId = item.extras?.getInt("match_id")
						matchIntent.putExtra(EXTRA_MATCH_ID, matchId)
						startActivity(matchIntent)
					}
					NEW_MESSAGE -> {
						val messageIntent = Intent(activity, MessageActivity::class.java)
						val messageId = item.extras?.getInt("message_id")
						messageIntent.putExtra(EXTRA_MESSAGE_ID, messageId)
						startActivity(messageIntent)
					}
					else -> {
						Toast.makeText(context, "Click around!", Toast.LENGTH_SHORT).show()
					}
				}
			}
		})

		super.onAttach(context)
	}

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
							  savedInstanceState: Bundle?): View? {
		val view: View = inflater.inflate(R.layout.fragment_notifications, container, false)
		notificationList = view.findViewById(R.id.notificationList)
		notificationList.layoutManager = LinearLayoutManager(context)
		val dividerItemDecoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
		notificationList.addItemDecoration(dividerItemDecoration)
		notificationList.adapter = notificationAdapter

		return view
	}

	override fun onStart() {
		super.onStart()

		noteSubs.add(
				database.notificationDao().getAll()
						.observeOn(AndroidSchedulers.mainThread())
						.subscribeOn(Schedulers.io())
						.subscribe({ notifications ->
							notificationAdapter.setNotifications(notifications)
							notificationAdapter.notifyDataSetChanged()
						}, {
							Toast.makeText(context, R.string.error_notification, Toast.LENGTH_SHORT).show()
						}))
	}

	override fun onStop() {
		super.onStop()
		noteSubs.dispose()
	}

	companion object {
		@JvmStatic
		fun newInstance() = NotificationsFragment()
	}

	inner class NotificationAdapter constructor(
			private val context: Context,
			private val clickListener: ItemClickListener<Notification>) : RecyclerView.Adapter<NotificationAdapter.ViewHolder>() {
		private var notifications: List<Notification> = emptyList()

		override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
			val layoutInflater = LayoutInflater.from(context)
			val view = layoutInflater.inflate(R.layout.row_notification, parent, false)
			return ViewHolder(view)
		}

		override fun onBindViewHolder(holder: ViewHolder, position: Int) {
			val note = notifications[position]
			holder.messageView.text = note.message
			holder.itemView.setOnClickListener {
				clickListener.onItemClick(note)
			}
		}

		override fun getItemCount(): Int {
			return notifications.size
		}

		fun getNotification(position: Int): Notification {
			return notifications[position]
		}

		fun setNotifications(items: List<Notification>) {
			notifications = items
		}

		inner class ViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
			internal var messageView: TextView

			init {
				messageView = itemView.findViewById(R.id.message)
			}
		}
	}
}
