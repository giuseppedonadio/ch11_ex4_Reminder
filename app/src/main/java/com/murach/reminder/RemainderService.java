package com.murach.reminder;

import android.app.Service;
import android.util.Log;
import android.content.Intent;
import android.os.IBinder;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by giuseppedonadio on 6/4/17.
 */

public class RemainderService extends Service {

    private Timer timer;

    @Override
    public void onCreate() {

        Log.d("Tester Service", "Service Created");
        startTimer();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("Tester Service", "Service Started");
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d("Tester Service", "Service Bound");
        return null;
    }

    @Override
    public void onDestroy() {
        Log.d("Tester service", "Service Destroyed");
        stopTimer();
    }

    private void startTimer() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Log.d("Tester service", "Look into the distance. It’s good for your eyes");
            }
        };

        timer = new Timer(true);
        int delay = 1000 * 3;           // 3 seconds
        int interval = 1000 * 10;   // 10 seconds
        timer.schedule(task, delay, interval);
    }

    private void stopTimer() {
        if (timer != null) {
            timer.cancel();
            Log.d("Tester service", "Time Stopped");
        }
    }


}
