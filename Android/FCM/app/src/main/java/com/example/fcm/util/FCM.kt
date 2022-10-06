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
import androidx.annotation.RequiresApi
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
import java.nio.channels.Channel

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
        createChannel()
    }

    private fun sendNotification(messageBody: Map<String, String>) {


        //딥링크 연결해줘용
        val taskDetailIntent = Intent(
            Intent.ACTION_VIEW,
            ("https://fcm/"+messageBody["id"]).toUri(),
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



        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        //여기서 채널이랑 연결한다 서버에서 messageBody["channel"]에 넣어주면 됨
        val notificationBuilder = NotificationCompat.Builder(this, messageBody["channel"]!!)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle(messageBody["channel"])
            .setContentText(messageBody["body"])
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setAutoCancel(true)
            .setContentIntent(pendingIntent)

        //알람 보내기
        notificationManager.notify(0, notificationBuilder.build())

    }
    fun createChannel() {

        //안드로이드 오레오 알림채널이 필요하기 때문에 넣음.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel1 = NotificationChannel(
                "channel1",
                "channel1",
                NotificationManager.IMPORTANCE_HIGH)
            val channel2 = NotificationChannel(
                "channel2",
                "channel2",
                NotificationManager.IMPORTANCE_HIGH)

            //여기서 알림 셋팅 하면 되나?? ㅇㅇ 초기 셋팅은 여기서 하면 되는듯
            //만약 셋팅을 변경했으면 앱 지우고 다시 깔아야함
            channel1.setShowBadge(false)
            channel1.enableVibration(true)

            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel1)
            notificationManager.createNotificationChannel(channel2)
        }

    }
}
