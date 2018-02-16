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
                textSize = 32f  // Text size for TextView
                textColor = 0xffffff.opaque // Text color for TextView
                padding = dip(16) // Padding for TextView
                gravity = Gravity.START // Gravity for TextView (gravity)
            }.lparams(width = wrapContent, height = wrapContent) {
                gravity = Gravity.CENTER // Layout Gravity for TextView (layout_gravity)
                margin = dip(4) // Margin for TextView
            }

            // Button with Anko Layouts
            button("Toast") {
                onClick { // On Click listener for Button
                    // Toast with Anko Commons
                    toast("You just clicked me!")
                }
            }.lparams(width = wrapContent, height = wrapContent) {
                gravity = Gravity.CENTER
                margin = dip(8)
            }

            // AlertDialog with Anko Commons
            button("Alert Dialog") {
                onClick {
                    alert("Did you just click me?", "Hey, you.") {
                        yesButton { toast("You did click me!") }
                        cancelButton { toast("Sure you didn't?") }
                    }.show()
                }
            }.lparams(width = wrapContent, height = wrapContent) {
                gravity = Gravity.CENTER
                margin = dip(8)
            }

            // Selector with Anko Commons
            val thingsYouLove = listOf("Kotlin", "Anko", "Karamba", "Ankara", "BlrKotlin")
            button("Selector") {
                onClick {
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

            // Browser Intent with Anko Commons
            button("Visit My Website") {
                onClick {
                    browse("https://bapspatil.com")
                }
            }.lparams(width = wrapContent, height = wrapContent) {
                gravity = Gravity.CENTER
                margin = dip(8)
            }

            // Share Intent with Anko Commons
            button("Share This App") {
                onClick {
                    share("Hey, check out this example app for Anko & Karamba, developed by Bapusaheb Patil at:\nhttps://github.com/bapspatil/Ankara", "Share Ankara's GitHub link")
                }
            }.lparams(width = wrapContent, height = wrapContent) {
                gravity = Gravity.CENTER
                margin = dip(8)
            }
        }
    }

}