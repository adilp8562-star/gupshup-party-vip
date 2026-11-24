package com.gupshupparty.vip

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val officialOwnerGmail = "adilp8562@gmail.com"
    private val dailyCheckInStartCoins = 200_000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val signedInEmail = intent?.getStringExtra("EXTRA_SIGNED_IN_EMAIL")
        val isOfficialOwner = signedInEmail?.trim()?.equals(officialOwnerGmail, ignoreCase = true) == true

        val btnJoinRoom = findViewById<Button>(R.id.btnJoinRoom)
        btnJoinRoom.setOnClickListener {
            val ownerTag = if (isOfficialOwner) " [Owner: $dailyCheckInStartCoins Coins]" else ""
            Toast.makeText(
                this,
                "Joining VIP Voice Room...$ownerTag",
                Toast.LENGTH_SHORT
            ).show()

            val intent = Intent(this, VoiceRoomActivity::class.java)
            intent.putExtra("EXTRA_OWNER_TAG", ownerTag)
            startActivity(intent)
        }
    }
}
