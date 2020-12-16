package android.wawakidss.n_back

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*
import java.util.concurrent.TimeUnit

class ButtonsActivity : AppCompatActivity(), View.OnClickListener {

    val n = 1
    var score = 0
    val TAG: String = "ButtonsActivity"
    var temp = ArrayDeque<ImageButton>(n)
    lateinit var text: TextView
    lateinit var btn: Array<ImageButton>
    lateinit var menuButton: Button
    val KEY_INDEX = "index"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.buttons_activity)

        if (savedInstanceState != null)
            score = savedInstanceState.getInt(KEY_INDEX, 0);

        text = findViewById<TextView>(R.id.score)
        btn = arrayOf(
            findViewById<ImageButton>(R.id.btn11),
            findViewById<ImageButton>(R.id.btn12),
            findViewById<ImageButton>(R.id.btn13),
            findViewById<ImageButton>(R.id.btn21),
            findViewById<ImageButton>(R.id.btn22),
            findViewById<ImageButton>(R.id.btn23),
            findViewById<ImageButton>(R.id.btn31),
            findViewById<ImageButton>(R.id.btn32),
            findViewById<ImageButton>(R.id.btn33))

        text.setText(Integer.toString(score))

        menuButton = findViewById(R.id.menu_button)

        menuButton.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }

        for (i in 0..8) {
            btn[i].setOnClickListener(this)
        }

        for (i in 0..n) {
            temp.addLast(btn[(0..8).shuffled().first()])
        }
    }

    override fun onClick(view: View) {
        val v: ImageButton = view as ImageButton
        Log.d(TAG, "user pressed " + Integer.toString(v.getId()))
        Log.d(TAG, "the right button_grey was " + Integer.toString(temp.peekLast().getId()))

        if (v.getId() == temp.pollLast().getId()) {
            score += 1
        }

        else {
            score = 0
        }
        text.setText(Integer.toString(score))
        temp.peekFirst().setColorFilter(R.color.colorGrey)
        temp.addFirst(btn[(0..8).shuffled().first()])
        temp.peekFirst().setColorFilter(R.color.colorGrey)
    }

    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        super.onSaveInstanceState(savedInstanceState)
        Log.i(TAG, "onSavedInstanceState")
        savedInstanceState.putInt(KEY_INDEX, score)
    }
}