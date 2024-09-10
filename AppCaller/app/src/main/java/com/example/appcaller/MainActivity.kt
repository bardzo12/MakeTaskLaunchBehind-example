package com.example.appcaller

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.widget.Button
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

        findViewById<Button>(R.id.goToNextApp).setOnClickListener {
            val launchIntent = packageManager.getLaunchIntentForPackage("com.example.app2")
            launchIntent?.setFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT)
            val options = ActivityOptions.makeTaskLaunchBehind()
            startActivity(launchIntent, options.toBundle())
        }
    }
}