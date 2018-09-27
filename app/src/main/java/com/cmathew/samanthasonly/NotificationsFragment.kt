package com.cmathew.samanthasonly

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class NotificationsFragment : Fragment() {
	private lateinit var notificationList: RecyclerView

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
														savedInstanceState: Bundle?): View? {
		val view: View = inflater.inflate(R.layout.fragment_notifications, container, false)
		notificationList = view.findViewById(R.id.notificationList)
		return view
	}

	companion object {
		@JvmStatic
		fun newInstance() = NotificationsFragment()
	}
}
