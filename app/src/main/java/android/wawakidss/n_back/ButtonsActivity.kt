package android.wawakidss.n_back

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.util.concurrent.TimeUnit
import java.util.ArrayDeque

class ButtonsActivity : AppCompatActivity(), View.OnClickListener {

    val n = 1
    var score = 0
    val TAG: String = "ButtonsActivity"
    var temp = ArrayDeque<Int>(n)
    lateinit var text: TextView
    lateinit var btn: Array<Button>
    lateinit var menuButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.buttons_activity)

        text = findViewById<TextView>(R.id.score)
        btn = arrayOf(
            findViewById<Button>(R.id.btn11),
            findViewById<Button>(R.id.btn12),
            findViewById<Button>(R.id.btn13),
            findViewById<Button>(R.id.btn21),
            findViewById<Button>(R.id.btn22),
            findViewById<Button>(R.id.btn23),
            findViewById<Button>(R.id.btn31),
            findViewById<Button>(R.id.btn32),
            findViewById<Button>(R.id.btn33))

        text.setText(Integer.toString(score))

        menuButton = findViewById(R.id.menu_button)

        menuButton.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }

        for (i in 0..8) {
            btn[i].setOnClickListener(this)
        }

        for (i in 0..n-1) {
            temp.push(btn[(0..8).shuffled().first()].getId())
        }
    }

    override fun onClick(view: View) {
        Log.d(TAG, "user pressed " + Integer.toString(view.getId()))
        if (view.getId() == temp.pollLast()) {
            score += 1
            view.setBackgroundColor(Color.GREEN)
        }
        else {
            score = 0
            view.setBackgroundColor(Color.RED)
        }
        text.setText(Integer.toString(score))
        TimeUnit.MILLISECONDS.sleep(500)
        view.setBackgroundColor(Color.GRAY)
        temp.push(btn[(0..8).shuffled().first()].getId())
    }
}