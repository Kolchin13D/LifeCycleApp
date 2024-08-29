package com.example.lifecycleapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        Toast.makeText(
            this, "onCreate is called",
            Toast.LENGTH_SHORT
        ).show()

        val btn: Button = findViewById(R.id.btn)
        btn.setOnClickListener() {
            var intent: Intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("name", "Dmitry")
            startActivity(intent)
        }

        val btn2: Button = findViewById(R.id.btn2)
        btn2.setOnClickListener() {
            intent = Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse("https://www.google.com"))
            startActivity(intent)
        }

    }

    override fun onStart() {
        super.onStart()

        Toast.makeText(
            this, "onStart is called",
            Toast.LENGTH_SHORT
        ).show()
    }

    override fun onResume() {
        super.onResume()

        Toast.makeText(
            this, "onResume is called",
            Toast.LENGTH_SHORT
        ).show()
    }

    override fun onRestart() {
        super.onRestart()

        Toast.makeText(
            this, "onRestart is called",
            Toast.LENGTH_SHORT
        ).show()
    }

    override fun onPause() {
        super.onPause()

        Toast.makeText(
            this, "onPause is called",
            Toast.LENGTH_SHORT
        ).show()
    }

    override fun onStop() {
        super.onStop()

        Toast.makeText(
            this, "onStop is called",
            Toast.LENGTH_SHORT
        ).show()
    }

    override fun onDestroy() {
        super.onDestroy()

        Toast.makeText(
            this, "onDestroy is called",
            Toast.LENGTH_SHORT
        ).show()
    }
}