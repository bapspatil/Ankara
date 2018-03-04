package bapspatil.examples.ankara

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import org.jetbrains.anko.*
import org.jetbrains.anko.coroutines.experimental.Ref
import org.jetbrains.anko.coroutines.experimental.asReference

/**
 * Created by bapspatil
 */
class MainActivity : AppCompatActivity(), AnkoLogger {

    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainView().setContentView(this)
        // Logging with Anko Commons
        verbose("MainActivity created!")

        // Anko Coroutines
        /*
        *   Here, Ref<MainActivity> holds a WeakReference to our MainActivity.
        *   If we hold strong references to our MainActivity, that may cause a memory leak.
        *   Using asReference() ensures that this doesn't happen.
        */
        val ref: Ref<MainActivity> = this.asReference()
        doAsync {

            /*
            *   Do long-running background task here.
            *   Here, @{bg} executes code on a background thread and the await() method can be called on its return value since it is of Deferred type.
            */
            // val someData = bg { getDataThatTakesALongTimeToFetch() }

            uiThread {

                /*
                *   Do UI-related task here.
                *   Here, when await() is called, the async thread is suspended until the value of @{someData} is fetched.
                */
                // ref().updateUI(someData.await())
            }
        }

        // Following code is to demo how to find a TextView defined in the Anko DSL Layout file
        textView = find(R.id.helloTextView)
        val textViewMessage = textView.text
        toast(textViewMessage)

    }

}
