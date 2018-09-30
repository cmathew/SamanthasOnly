package com.cmathew.samanthasonly

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import butterknife.BindView
import butterknife.ButterKnife

class MatchToolbar @JvmOverloads constructor(
		context: Context,
		attrs: AttributeSet? = null,
		defStyleAttr: Int = 0
) : Toolbar(context, attrs, defStyleAttr) {

	@BindView(R.id.matchName)
	lateinit var matchName: TextView
	@BindView(R.id.matchAge)
	lateinit var matchAge: TextView
	@BindView(R.id.matchDistance)
	lateinit var matchDistance: TextView

	init {
		val padding = resources.getDimensionPixelSize(R.dimen.space_medium)
		setPadding(padding, padding, padding, padding)
		inflate(context, R.layout.toolbar_match, this)
		ButterKnife.bind(this)

//		val params = layoutParams as AppBarLayout.LayoutParams
//		params.scrollFlags = AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL or AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS
//		layoutParams = params

		matchName.text = "Chris M."
		matchAge.text = "Age 28"
		matchDistance.text = "0 miles away"
	}
}