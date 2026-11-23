package com.gupshup.party

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvLobbyStatus = findViewById<TextView>(R.id.tvLobbyStatus)
        val btnJoinRoom = findViewById<Button>(R.id.btnJoinRoom)

        btnJoinRoom.setOnClickListener {
            tvLobbyStatus.text = "Connected to VIP Voice Room"
            Toast.makeText(this, "Welcome to GupShup Party VIP Lounge!", Toast.LENGTH_SHORT).show()
        }
    }
}
