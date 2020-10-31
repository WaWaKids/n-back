package android.wawakidss.n_back

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MenuActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu_activity)

        val btn = findViewById<Button>(R.id.start_button)

        btn.setOnClickListener {
            val intent = Intent(this, ButtonsActivity::class.java)

            startActivity(intent)
        }
    }
}