package com.cmathew.samanthasonly

import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import butterknife.BindView
import butterknife.ButterKnife.bind
import com.github.jinatonic.confetti.CommonConfetti
import com.github.jinatonic.confetti.ConfettiManager

class CelebrateActivity : AppCompatActivity() {
	private val CONFETTI_DURATION_MS: Long = 3000

	@BindView(R.id.confettiContainer)
	lateinit var confettiContainer: FrameLayout

	private lateinit var confettiManager: ConfettiManager

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_celebrate)
		bind(this)

		confettiContainer.viewTreeObserver.addOnGlobalLayoutListener {
			if (!::confettiManager.isInitialized) {
				initializeConfetti()
			}
		}
	}

	private fun initializeConfetti() {
		val flameColor = ContextCompat.getColor(this, R.color.flame)
		confettiManager = CommonConfetti.rainingConfetti(confettiContainer, intArrayOf(flameColor))
				.stream(CONFETTI_DURATION_MS)
	}

	override fun onStop() {
		super.onStop()

		if (::confettiManager.isInitialized) {
			confettiManager.terminate()
		}
	}
}
