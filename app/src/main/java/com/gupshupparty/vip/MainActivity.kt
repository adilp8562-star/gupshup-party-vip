package com.gupshupparty.vip

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnJoinRoom = findViewById<Button>(R.id.btnJoinRoom)
        btnJoinRoom.setOnClickListener {
            Toast.makeText(this, "Joining VIP Voice Room...", Toast.LENGTH_SHORT).show()
        }
    }
}
