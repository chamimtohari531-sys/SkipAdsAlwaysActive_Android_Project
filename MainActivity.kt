package com.example.skipadsalwaysactive

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.view.Gravity
import android.graphics.Typeface

class MainActivity : Activity() {
    private lateinit var status: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT >= 33 && checkSelfPermission(Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(arrayOf(Manifest.permission.POST_NOTIFICATIONS), 10)
        }

        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            setPadding(28, 36, 28, 36)
            setBackgroundColor(0xFF101820.toInt())
        }
        val title = TextView(this).apply {
            text = "Skip Ads\nAlways Active"
            textSize = 27f
            setTextColor(0xFFFFFFFF.toInt())
            typeface = Typeface.DEFAULT_BOLD
            gravity = Gravity.CENTER
        }
        status = TextView(this).apply {
            text = "Status: tidak aktif"
            textSize = 16f
            setTextColor(0xFFB9C7D2.toInt())
            gravity = Gravity.CENTER
            setPadding(0, 28, 0, 28)
        }
        val start = Button(this).apply {
            text = "MULAI LAYANAN"
            setOnClickListener {
                val i = Intent(this@MainActivity, KeepAliveService::class.java).setAction(KeepAliveService.ACTION_START)
                if (Build.VERSION.SDK_INT >= 26) startForegroundService(i) else startService(i)
                status.text = "Status: layanan dimulai"
            }
        }
        val stop = Button(this).apply {
            text = "HENTIKAN LAYANAN"
            setOnClickListener {
                stopService(Intent(this@MainActivity, KeepAliveService::class.java))
                status.text = "Status: tidak aktif"
            }
        }
        val note = TextView(this).apply {
            text = "Layanan menampilkan notifikasi saat aktif. Android tetap dapat menghentikannya karena kebijakan baterai atau sistem. Aplikasi ini tidak mengklik atau melewati iklan secara otomatis."
            textSize = 13f
            setTextColor(0xFFB9C7D2.toInt())
            setPadding(0, 28, 0, 0)
        }
        layout.addView(title)
        layout.addView(status)
        layout.addView(start)
        layout.addView(stop)
        layout.addView(note)
        setContentView(layout)
    }
}
