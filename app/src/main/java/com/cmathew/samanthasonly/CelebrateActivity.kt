package com.cmathew.samanthasonly

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.VectorDrawable
import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import butterknife.BindView
import butterknife.ButterKnife.bind
import com.github.jinatonic.confetti.ConfettiManager
import com.github.jinatonic.confetti.ConfettiSource
import com.github.jinatonic.confetti.ConfettoGenerator
import com.github.jinatonic.confetti.confetto.BitmapConfetto
import com.github.jinatonic.confetti.confetto.Confetto
import java.util.*


class CelebrateActivity : AppCompatActivity() {
	private val CONFETTI_DURATION_MS: Long = 2000
	private val CONFETTI_SIZE = 130

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
		val confettiShapes = arrayListOf(R.drawable.star).map {
			ContextCompat.getDrawable(this, it)
		}.map {
			getBitmap(it as VectorDrawable)
		}

		val numConfetti: Int = confettiShapes.count()
		val generator = object: ConfettoGenerator {
			override fun generateConfetto(random: Random): Confetto {
				val confettiIndex = random.nextInt(numConfetti)
				val bitmap = confettiShapes[confettiIndex]
				return BitmapConfetto(bitmap)
			}
		}

		val confettiSource = ConfettiSource(0, -CONFETTI_SIZE, confettiContainer.width, -CONFETTI_SIZE)

		confettiManager = ConfettiManager(this, generator, confettiSource, confettiContainer)
				.setEmissionDuration(CONFETTI_DURATION_MS)
				.setEmissionRate(60f)
				.setVelocityX(0f, 30f)
				.setVelocityY(250f, 100f)
				.setRotationalVelocity(90f, 50f)
				.animate()
	}

	override fun onStop() {
		super.onStop()

		if (::confettiManager.isInitialized) {
			confettiManager.terminate()
		}
	}

	private fun getBitmap(vectorDrawable: VectorDrawable): Bitmap {
		val aspect = vectorDrawable.intrinsicWidth / vectorDrawable.intrinsicHeight
		val bitmap = Bitmap.createBitmap(aspect * CONFETTI_SIZE,
				CONFETTI_SIZE / aspect, Bitmap.Config.ARGB_8888)
		val canvas = Canvas(bitmap)
		vectorDrawable.setBounds(0, 0, canvas.width, canvas.height)
		vectorDrawable.draw(canvas)
		return bitmap
	}
}
