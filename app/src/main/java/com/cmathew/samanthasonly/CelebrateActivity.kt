package com.cmathew.samanthasonly

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import butterknife.BindView
import butterknife.ButterKnife.bind
import com.github.jinatonic.confetti.ConfettiManager
import com.github.jinatonic.confetti.ConfettiSource
import com.github.jinatonic.confetti.ConfettoGenerator
import com.github.jinatonic.confetti.Utils
import com.github.jinatonic.confetti.confetto.BitmapConfetto
import com.github.jinatonic.confetti.confetto.Confetto
import java.util.*
import android.graphics.drawable.VectorDrawable
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.opengl.ETC1.getHeight
import android.opengl.ETC1.getWidth
import android.os.Build
import android.annotation.TargetApi
import android.content.Context
import android.graphics.Canvas
import kotlin.math.max


class CelebrateActivity : AppCompatActivity() {
	private val CONFETTI_DURATION_MS: Long = 2000

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
//		val confettiShapes = Utils.generateConfettiBitmaps(intArrayOf(flameColor), 30)
		val confettiShapes = arrayListOf(R.drawable.star, R.drawable.flame).map {
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

		val confettiSource = ConfettiSource(0, -50, confettiContainer.width, -50)

		confettiManager = ConfettiManager(this, generator, confettiSource, confettiContainer)
				.setEmissionDuration(CONFETTI_DURATION_MS)
				.setEmissionRate(60f)
				.setVelocityX(0f, 10f)
				.setVelocityY(150f, 70f)
				.setRotationalVelocity(180f, 180f)
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
		val bitmap = Bitmap.createBitmap(aspect * 56,
				56 / aspect, Bitmap.Config.ARGB_8888)
		val canvas = Canvas(bitmap)
		vectorDrawable.setBounds(0, 0, canvas.width, canvas.height)
		vectorDrawable.draw(canvas)
		return bitmap
	}
}
