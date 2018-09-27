package com.cmathew.samanthasonly

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.cmathew.samanthasonly.db.DatingDatabase
import com.cmathew.samanthasonly.db.Notification
import javax.inject.Inject

class NotificationsFragment : Fragment() {
	private lateinit var notificationList: RecyclerView
	private lateinit var notificationAdapter: NotificationAdapter

	@Inject
	lateinit var database: DatingDatabase

	override fun onAttach(context: Context) {
		(context.applicationContext as DatingApplication).applicationComponent!!.inject(this)
		notificationAdapter = NotificationAdapter(activity)
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

		val notifications = database.notificationDao().getAll()
		notificationAdapter.notifications = notifications
		notificationAdapter.notifyDataSetChanged()
	}

	companion object {
		@JvmStatic
		fun newInstance() = NotificationsFragment()
	}

	inner class NotificationAdapter constructor(private val context: Context) : RecyclerView.Adapter<NotificationAdapter.ViewHolder>() {
		var notifications: List<Notification> = emptyList()

		override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
			val layoutInflater = LayoutInflater.from(context)
			val view = layoutInflater.inflate(R.layout.row_notification, parent, false)
			return ViewHolder(view)
		}

		override fun onBindViewHolder(holder: ViewHolder, position: Int) {
			val note = notifications[position]
			holder.messageView.text = note.message
		}

		override fun getItemCount(): Int {
			return notifications.size
		}

		inner class ViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
			internal var messageView: TextView

			init {
				messageView = itemView.findViewById(R.id.message)
			}
		}
	}
}
