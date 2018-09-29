package com.cmathew.samanthasonly

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

private const val ARG_MATCH_ID = "match_id"

class MatchFragment : Fragment() {
	private var matchId: String? = null

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		arguments?.let {
			matchId = it.getString(ARG_MATCH_ID)
		}
	}

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
														savedInstanceState: Bundle?): View? {
		return inflater.inflate(R.layout.fragment_match, container, false)
	}

	companion object {
		@JvmStatic
		fun newInstance(matchId: String) =
				MatchFragment().apply {
					arguments = Bundle().apply {
						putString(ARG_MATCH_ID, matchId)
					}
				}
	}
}
