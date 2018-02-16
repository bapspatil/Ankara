package bapspatil.examples.ankara

import android.graphics.Color
import android.view.Gravity
import android.view.View
import org.jetbrains.anko.*

/**
 * Created by bapspatil
 */
class MainView : AnkoComponent<MainActivity> {

    override fun createView(ui: AnkoContext<MainActivity>): View = with(ui) {
        verticalLayout {
            lparams(width = matchParent, height = matchParent)

            textView {
                id = R.id.helloTextView
                text = context.getString(R.string.hello)
                textSize = 16f
                textColor = Color.parseColor("#FFFFFF")
                padding = dip(16)
                gravity = Gravity.START
            }.lparams(width = wrapContent, height = wrapContent) {
                gravity = Gravity.CENTER
            }
        }
    }

}