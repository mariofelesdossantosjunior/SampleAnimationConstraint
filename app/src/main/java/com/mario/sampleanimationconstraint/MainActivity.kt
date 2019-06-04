package com.mario.sampleanimationconstraint

import android.os.Bundle
import android.transition.TransitionManager
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintSet
import kotlinx.android.synthetic.main.main_activity.*
import kotlinx.android.synthetic.main.main_activity.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        addAnimationOperations()
    }

    private fun addAnimationOperations() {
        var up = true//Up Or Down

        val constraintUp = ConstraintSet()
        constraintUp.clone(this, R.layout.activity_image_alt)

        val constraintDown = ConstraintSet()
        constraintDown.clone(this, R.layout.main_activity)

        findViewById<ImageView>(R.id.img).setOnClickListener {
            TransitionManager.beginDelayedTransition(root)

            if (up) {
                it.img.setImageResource(R.mipmap.space_run)
                constraintUp.applyTo(root)
            } else {
                it.img.setImageResource(R.mipmap.space)
                constraintDown.applyTo(root)
            }

            up = !up
        }

    }

}
