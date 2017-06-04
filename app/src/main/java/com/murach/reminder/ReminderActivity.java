package com.murach.reminder;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class ReminderActivity extends Activity implements OnClickListener {

    private Button startServiceButton;
    private Button stopServiceButton;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reminder);
		
        startServiceButton = (Button) findViewById(R.id.startServiceButton);
        stopServiceButton = (Button) findViewById(R.id.stopServiceButton);
        
        startServiceButton.setOnClickListener(this);
        stopServiceButton.setOnClickListener(this);

        Log.d("Remainder", "App started");

	}

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
        	case R.id.startServiceButton:
        		// put code to start service and display toast here
                Toast.makeText(this, "Service started", Toast.LENGTH_SHORT).show();
                // start service
                Intent service = new Intent(this, RemainderService.class);
                startService(service);
        		break;
        	case R.id.stopServiceButton:
        		// put code to stop service and display toast here
                Toast.makeText(this, "Service stopped", Toast.LENGTH_SHORT).show();
                // stop service
                Intent stopService = new Intent(this, RemainderService.class);
                stopService(stopService);
        		break;
        }
    }
}