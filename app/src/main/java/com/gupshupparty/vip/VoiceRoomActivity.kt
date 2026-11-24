package com.gupshupparty.vip

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class VoiceRoomActivity : AppCompatActivity() {

    private var isMicOn = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_voice_room)

        val ownerTag = intent?.getStringExtra("EXTRA_OWNER_TAG") ?: ""
        val tvRoomSubtitle = findViewById<TextView>(R.id.tvRoomSubtitle)
        val btnToggleMic = findViewById<Button>(R.id.btnToggleMic)
        val btnBackLobby = findViewById<Button>(R.id.btnBackLobby)

        if (ownerTag.isNotEmpty()) {
            tvRoomSubtitle.text = "Clear Voice Ready • 9 Seats $ownerTag"
        }

        btnToggleMic.setOnClickListener {
            isMicOn = !isMicOn
            if (isMicOn) {
                btnToggleMic.text = "Mic: ON (Clear Voice)"
                Toast.makeText(this, "Mic Unmuted", Toast.LENGTH_SHORT).show()
            } else {
                btnToggleMic.text = "Mic: MUTED"
                Toast.makeText(this, "Mic Muted", Toast.LENGTH_SHORT).show()
            }
        }

        btnBackLobby.setOnClickListener {
            finish()
        }
    }
}
