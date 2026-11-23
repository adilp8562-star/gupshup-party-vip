package com.gupshup.party

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val inviteBonusCoins = 1000000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val prefs = getSharedPreferences("gupshup_vip_prefs", Context.MODE_PRIVATE)
        var goldCoins = prefs.getLong("gold_coins", 1000000L)
        var inviteClaimed = prefs.getBoolean("invite_claimed", false)

        val tvCoinsBalance = findViewById<TextView>(R.id.tvCoinsBalance)
        val tvLobbyStatus = findViewById<TextView>(R.id.tvLobbyStatus)
        val tvMyInviteCode = findViewById<TextView>(R.id.tvMyInviteCode)
        val btnCopyInvite = findViewById<Button>(R.id.btnCopyInvite)
        val etFriendCode = findViewById<EditText>(R.id.etFriendCode)
        val btnApplyInvite = findViewById<Button>(R.id.btnApplyInvite)
        val btnJoinRoom = findViewById<Button>(R.id.btnJoinRoom)

        val myInviteCode = tvMyInviteCode.text.toString().uppercase()
        tvCoinsBalance.text = "Gold Coins: $goldCoins"

        btnCopyInvite.setOnClickListener {
            val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText("Invite Code", myInviteCode)
            clipboard.setPrimaryClip(clip)

            val shareIntent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(
                    Intent.EXTRA_TEXT,
                    "Join me on GupShup Party VIP! Use my Invite Code $myInviteCode to get +10,00,000 Gold Coins!"
                )
            }
            startActivity(Intent.createChooser(shareIntent, "Share Invite Code"))
        }

        btnApplyInvite.setOnClickListener {
            val enteredCode = etFriendCode.text.toString().trim().uppercase()

            when {
                enteredCode.isEmpty() -> {
                    Toast.makeText(this, "Pehle dost ka invite code daalo", Toast.LENGTH_SHORT).show()
                }
                inviteClaimed -> {
                    Toast.makeText(this, "Invite bonus already claim ho chuka hai", Toast.LENGTH_SHORT).show()
                }
                enteredCode == myInviteCode -> {
                    Toast.makeText(this, "Apna khud ka invite code use nahi kar sakte", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    goldCoins += inviteBonusCoins
                    inviteClaimed = true

                    prefs.edit()
                        .putLong("gold_coins", goldCoins)
                        .putBoolean("invite_claimed", true)
                        .apply()

                    tvCoinsBalance.text = "Gold Coins: $goldCoins"
                    tvLobbyStatus.text = "Invite Bonus +10,00,000 Gold Coins Added!"
                    etFriendCode.text.clear()
                    Toast.makeText(
                        this,
                        "Badhai! +10,00,000 Gold Coins mil gaye!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

        btnJoinRoom.setOnClickListener {
            tvLobbyStatus.text = "Connected to VIP Voice Room"
            Toast.makeText(this, "Welcome to GupShup Party VIP Lounge!", Toast.LENGTH_SHORT).show()
        }
    }
}
