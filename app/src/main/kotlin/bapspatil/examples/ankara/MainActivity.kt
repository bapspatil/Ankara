package bapspatil.examples.ankara

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import org.jetbrains.anko.find
import org.jetbrains.anko.setContentView
import org.jetbrains.anko.toast

/**
 * Created by bapspatil
 */
class MainActivity : AppCompatActivity() {

    var textView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainView().setContentView(this)

        // Following code is to demo how to find a TextView defined in the Anko DSL Layout file
        textView = find(R.id.helloTextView)
        val textViewMessage = textView!!.text
        toast(textViewMessage)
    }

}
