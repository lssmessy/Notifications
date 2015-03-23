package com.example.priteshpatel.notifications;

import android.app.AlertDialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity {

     NotificationCompat.Builder notification;
    private static final int uniqID=345345;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notification=new NotificationCompat.Builder(this);
        notification.setAutoCancel(true);
    }
    public void getNotification(View view){
        notification.setSmallIcon(R.drawable.ic_launcher);
        notification.setTicker("This is the ticker text");
        notification.setWhen(System.currentTimeMillis());
        notification.setContentTitle("WhatsNext");
        notification.setContentText("Hey there..come to whatsnext to growth your career");
       notification.setSound(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.sound));


        Intent intent=new Intent(this,MainActivity.class);
        //Get device access to ececute following intent
        PendingIntent pendingIntent=PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(pendingIntent);

        //Build notification and issues it

        NotificationManager notificationManager=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(uniqID,notification.build());
        AlertDialog.Builder alertDialog=new AlertDialog.Builder(MainActivity.this);
        alertDialog.setTitle("Whatsnext");
        alertDialog.setMessage("This is the \"Most\" common dialog!");
        //alertDialog.setCancelable(false);
        alertDialog.setPositiveButton("Done",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        alertDialog.setIcon(R.drawable.ic_launcher);
        alertDialog.show();










    }


}
