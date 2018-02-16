package bapspatil.examples.ankara

import android.util.Log.v
import android.view.Gravity
import android.view.View
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

/**
 * Created by bapspatil
 */
class MainView : AnkoComponent<MainActivity> {

    override fun createView(ui: AnkoContext<MainActivity>): View = with(ui) {

        // Vertical LinearLayout with Anko Layouts
        verticalLayout {
            lparams(width = matchParent, height = matchParent)

            // TextView with Anko Layouts
            textView {
                id = R.id.helloTextView // ID for TextView so it can referenced later
                text = context.getString(R.string.hello) // Text for TextView
                textSize = 16f  // Text size for TextView
                textColor = 0xffffff.opaque
                padding = dip(16)
                gravity = Gravity.START
            }.lparams(width = wrapContent, height = wrapContent) {
                gravity = Gravity.CENTER
            }

            // Button with Anko Layouts
            button("Toast") {
                onClick {
                    // Toast with Anko Commons
                    toast("You just clicked me!")
                }
            }.lparams(width = wrapContent, height = wrapContent) {
                gravity = Gravity.CENTER
                margin = dip(8)
            }

            button("Alert Dialog") {
                onClick {
                    // AlertDialog with Anko Commons
                    alert("Did you just click me?", "Hey, you.") {
                        yesButton { toast("You did click me!") }
                        cancelButton { toast("Sure you didn't?") }
                    }.show()
                }
            }.lparams(width = wrapContent, height = wrapContent) {
                gravity = Gravity.CENTER
                margin = dip(8)
            }

            val thingsYouLove = listOf("Kotlin", "Anko", "Karamba", "Ankara", "BlrKotlin")
            button("Selector") {
                onClick {
                    // Selector with Anko Commons
                    selector("What do you love?", thingsYouLove, { dialogInterface, i ->
                        toast("I knew you loved ${thingsYouLove[i]}!")

                        // Logging with Anko Commons
                        v(this@MainView.javaClass.simpleName, "CLICKED: ${thingsYouLove[i]}")
                    })
                }
            }.lparams(width = wrapContent, height = wrapContent) {
                gravity = Gravity.CENTER
                margin = dip(8)
            }
        }
    }

}