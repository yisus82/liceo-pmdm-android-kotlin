package com.liceolapaz.des.jprf.notificaciones

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.drawable.BitmapDrawable
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    companion object {
        val NOTIF_ALERTA_ID = 1
        val CHANNEL_ID = "MiCanal"
    }

    private lateinit var btnNotificacion: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createNotificationChannel()

        btnNotificacion = findViewById<View>(R.id.BtnNotif) as Button
        btnNotificacion.setOnClickListener {
            val mBuilder = NotificationCompat.Builder(this@MainActivity, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_warning)
                .setLargeIcon(
                    (ContextCompat.getDrawable(baseContext, R.drawable.ic_launcher) as BitmapDrawable).bitmap
                )
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setAutoCancel(true)
                .setContentTitle("Mensaje de Alerta")
                .setContentText("Ejemplo de notificación.")
                .setContentInfo("4")
                .setTicker("Alerta!")
            val notificationIntent = Intent(this@MainActivity, MainActivity::class.java)
            val contentIntent = PendingIntent.getActivity(
                this@MainActivity, 0, notificationIntent, 0
            )
            mBuilder.setContentIntent(contentIntent)
            val mNotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            mNotificationManager.notify(NOTIF_ALERTA_ID, mBuilder.build())
        }
    }

    private fun createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name: CharSequence = getString(R.string.channel_name)
            val description = getString(R.string.channel_description)
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance)
            channel.description = description
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            val notificationManager = getSystemService(
                NotificationManager::class.java
            )
            notificationManager.createNotificationChannel(channel)
        }
    }
}