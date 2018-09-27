package com.cmathew.samanthasonly

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

private const val ARG_PHOTO_URL = "photoUrl"

class MemoryFragment : Fragment() {
	private lateinit var photoUrl: String

	companion object {
		@JvmStatic
		fun newInstance(photoUrl: String) =
				MemoryFragment().apply {
					arguments = Bundle().apply {
						putString(ARG_PHOTO_URL, photoUrl)
					}
				}
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		arguments?.let {
			photoUrl = it.getString(ARG_PHOTO_URL)
		}
	}

	override fun onCreateView(
			inflater: LayoutInflater,
			container: ViewGroup?,
			savedInstanceState: Bundle?): View? {
		val rootView = inflater.inflate(R.layout.fragment_memory, container, false)
		val textView = rootView.findViewById(R.id.photoUrl) as TextView
		textView.text = arguments.getString(ARG_PHOTO_URL)
		return rootView
	}
}
