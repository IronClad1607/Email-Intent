package com.ironclad.emailintent

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSend.setOnClickListener {
            if (!etSubject.text.isNullOrEmpty() && !etEmail.text.isNullOrEmpty() && !etMessage.text.isNullOrEmpty()) {
                val subject = etSubject.text.toString()
                val email = etEmail.text.toString()
                val message = etMessage.text.toString()

                val intent = Intent(Intent.ACTION_SEND)
                intent.type = "message/rfc822"
                intent.putExtra(Intent.EXTRA_EMAIL, arrayOf<String>(email))
                intent.putExtra(Intent.EXTRA_SUBJECT, subject)
                intent.putExtra(Intent.EXTRA_TEXT, message)

                try {
                    startActivity(Intent.createChooser(intent, "Send mail..."))
                } catch (e: ActivityNotFoundException) {
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}