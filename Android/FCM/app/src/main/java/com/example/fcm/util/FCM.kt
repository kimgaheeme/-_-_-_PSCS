package com.example.fcm.util

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.PendingIntent.FLAG_CANCEL_CURRENT
import android.app.PendingIntent.FLAG_MUTABLE
import android.app.TaskStackBuilder
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.os.Build
import android.util.Log
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.net.toUri
import com.example.fcm.MainActivity
import com.example.fcm.R
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class FCM : FirebaseMessagingService() {

    override fun onMessageReceived(message: RemoteMessage) {
        if (message.data.isNotEmpty()) {
            Log.d("ㅁㄴㅇㄹ", "Message data payload: ${message.data}")
        }

        //안에 notification(notification, data할 때 data)있냐?
        message.notification?.let {
            Log.d("ㅁㄴㅇㄹ", "Message Notification Body: ${it.body}")
        }

        //data만 받았을 때 이를 이용해서 notification보내야 하면
        sendNotification(message.data)
    }

    override fun onNewToken(token: String) {
        Log.d("ㅁㄴㅇㄹ","Token : ${token}")
    }

    private fun sendNotification(messageBody: Map<String, String>) {


        val taskDetailIntent = Intent(
            Intent.ACTION_VIEW,
            ("https://fcm/"+"1236478").toUri(),
            this,
            MainActivity::class.java
        )

        val requestCode = System.currentTimeMillis().toInt()
        val pendingIntent: PendingIntent = if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            TaskStackBuilder.create(this).run {
                addNextIntentWithParentStack(taskDetailIntent)
                getPendingIntent(requestCode, FLAG_MUTABLE)
            }
        } else {
            TaskStackBuilder.create(this).run {
                addNextIntentWithParentStack(taskDetailIntent)
                getPendingIntent(requestCode, FLAG_CANCEL_CURRENT)
            }
        }


        val channelId = getString(R.string.default_notification_channel_id)
        val defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)

        val notificationBuilder = NotificationCompat.Builder(this, channelId)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle(messageBody["title"])
            .setContentText(messageBody["body"])
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setAutoCancel(true)
            .setSound(defaultSoundUri)
            .setContentIntent(pendingIntent)

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager


        //안드로이드 오레오 알림채널이 필요하기 때문에 넣음.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(channelId,
                channelId,
                NotificationManager.IMPORTANCE_HIGH)
            notificationManager.createNotificationChannel(channel)
        }

        notificationManager.notify(requestCode, notificationBuilder.build())


    }
}