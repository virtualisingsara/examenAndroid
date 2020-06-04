package es.sarascript.examenandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import kotlinx.android.synthetic.main.activity_comments.*
import java.text.SimpleDateFormat
import java.util.*

class CommentsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comments)

        val name = intent.getStringExtra("name");

        txtName.text = name

        val prefs = PreferenceManager.getDefaultSharedPreferences(this)

        // Recuperar las preferencias
        prefs.getString("comment", "")
        prefs.getString("date", "")

        btnDelete.setOnClickListener() {
            // Borrar las preferencias
            val editor = prefs.edit()
            editor.remove("comment")
            editor.apply()
        }

        btnSave.setOnClickListener() {
            val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
            val currentDate = sdf.format(Date())
            // Guardar las preferencias
            val editor = prefs.edit()
            editor.putString("comment", txtNewComment.toString())
            editor.putString("date", currentDate)
            editor.apply()
        }

    }
}
