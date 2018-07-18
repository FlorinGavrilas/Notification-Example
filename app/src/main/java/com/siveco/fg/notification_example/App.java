package com.siveco.fg.notification_example;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class App extends Application {

    public static final String CHANNEL_1_ID = "Channel 1";
    public static final String CHANNEL_1_NAME = "Channel 1";
    public static final int CHANNEL_1_IMPORTANCE = NotificationManager.IMPORTANCE_HIGH;

    public static final String CHANNEL_2_ID = "Channel 2";
    public static final String CHANNEL_2_NAME = "Channel 2";
    public static final int CHANNEL_2_IMPORTANCE = NotificationManager.IMPORTANCE_LOW;

    @Override
    public void onCreate() {
        super.onCreate();

        createNotificationChannels();
    }

    private void createNotificationChannels() {

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel1 = new NotificationChannel(
                    CHANNEL_1_ID,
                    CHANNEL_1_NAME,
                    CHANNEL_1_IMPORTANCE
            );
            channel1.setDescription("This is channel 1");

            NotificationChannel channel2 = new NotificationChannel(
                    CHANNEL_2_ID,
                    CHANNEL_2_NAME,
                    CHANNEL_2_IMPORTANCE
            );
            channel2.setDescription("This is channel 2");

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel1);
            manager.createNotificationChannel(channel2);
        }
    }
}
