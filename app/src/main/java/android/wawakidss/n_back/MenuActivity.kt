package android.wawakidss.n_back

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView

class MenuActivity : AppCompatActivity(), SeekBar.OnSeekBarChangeListener {

    private lateinit var n: TextView
    private lateinit var seekBar: SeekBar
    private lateinit var btn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu_activity)

        n = findViewById<TextView>(R.id.text_n)
        seekBar = findViewById<SeekBar>(R.id.seekBar)
        btn = findViewById<Button>(R.id.start_button)

        n.setText("n = 1")

        seekBar.setOnSeekBarChangeListener(this)

        btn.setOnClickListener {
            var intent = Intent(this, ButtonsActivity::class.java)
            intent.putExtra("n", seekBar.progress)
            startActivity(intent)
        }
    }

    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
            n.setText("n = " + seekBar?.progress.toString() )
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {

    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {

    }
}