package com.example.ll6x.mynotification;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void btn01_Click(View view) {

        // 取得NotificationManager物件
        NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        // 建立大圖示需要的Bitmap物件
        Bitmap largeIcon = BitmapFactory.decodeResource(
                getResources(), R.drawable.a64);

        // 建立NotificationCompat.Builder物件
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);

        // 發出通知
        //nm.notify(001, builder.build());

        // 設定小圖示、大圖示、狀態列文字、時間、內容標題、內容訊息和內容額外資訊
        builder.setSmallIcon(android.R.drawable.btn_star)    //設定小圖示
                .setLargeIcon(largeIcon)                           //設定大圖示
                .setWhen(System.currentTimeMillis())                  //設定時間
                .setTicker("Hello !!")                               //設定狀態列文字
                .setContentTitle("Laemy通知一")                      //設定內容標題
                .setContentText("這是Laemy的系統提醒通知！!")      //設定內容訊息
                .setContentInfo("注意!");                         //設定內容額外資訊

        // 建立震動效果，陣列中元素依序為停止、震動的時間，單位是毫秒
        long[] vibrate_effect =
                {1000, 500, 1000, 400, 1000, 300, 1000, 200, 1000, 100};
        // 設定震動效果
        builder.setVibrate(vibrate_effect);

        // 建立音效效果，放在res/raw下的音效檔
        Uri sound_effect = Uri.parse(
                "android.resource://raw/zeta");
        // 設定音效效果
        builder.setSound(sound_effect);

        // 設定閃燈效果，參數依序為顏色、打開與關閉時間，單位是毫秒
        builder.setLights(Color.GREEN, 1000, 1000);

        // 建立通知物件
        Notification notification = builder.build();

        // 使用001為編號發出通知
        nm.notify("Laemy APP",001, notification);
    }

    public void btn02_Click(View view) {

        // 取得NotificationManager物件
        NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        // 建立大圖示需要的Bitmap物件
        Bitmap largeIcon = BitmapFactory.decodeResource(
                getResources(), R.drawable.a64_2);

        // 建立NotificationCompat.Builder物件
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);

        // 設定小圖示、大圖示、狀態列文字、時間、內容標題、內容訊息和內容額外資訊
        builder.setSmallIcon(android.R.drawable.btn_star)    //設定小圖示
                .setLargeIcon(largeIcon)                           //設定大圖示
                .setWhen(System.currentTimeMillis())                  //設定時間
                .setTicker("Hello II")                               //設定狀態列文字
                .setContentTitle("Laemy通知二")                      //設定內容標題
                .setContentText("這是Laemy的系統提醒通知！!")      //設定內容訊息
                .setContentInfo("注意!");                         //設定內容額外資訊

        // 建立通知物件
        Notification notification = builder.build();

        nm.notify("Laemy APP",002, notification);

    }

    public void btn03_Click(View view) {

        // 取得NotificationManager物件
        NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        // 建立大圖示需要的Bitmap物件
        Bitmap largeIcon = BitmapFactory.decodeResource(
                getResources(), R.drawable.a64_3);

        // 建立NotificationCompat.Builder物件
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);

        // 設定小圖示、大圖示、狀態列文字、時間、內容標題、內容訊息和內容額外資訊
        builder.setSmallIcon(android.R.drawable.btn_star)    //設定小圖示
                .setLargeIcon(largeIcon)                           //設定大圖示
                .setWhen(System.currentTimeMillis())                  //設定時間
                .setTicker("Hello III")                               //設定狀態列文字
                .setContentTitle("Laemy通知三")                      //設定內容標題
                .setContentText("這是Laemy的系統提醒通知！!")      //設定內容訊息
                .setContentInfo("注意!");                         //設定內容額外資訊

        // 建立通知物件
        Notification notification = builder.build();

        nm.notify("Laemy APP",003, notification);

    }

    public void btnClear_Click(View view) {

        // 取得NotificationManager物件
        NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        // 清除BASIC_ID編號的通知
        nm.cancel("Laemy APP",002);

    }

    public void btnbigP_Click(View view) {
        // 取得NotificationManager物件
        NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        // 建立大圖示需要的Bitmap物件
        Bitmap largeIcon = BitmapFactory.decodeResource(
                getResources(), R.drawable.a64_4);

        // 建立Notification.Builder物件，因為要設定大型圖片樣式
        // 所以不能使用NotificationCompat.Builder
        Notification.Builder builder = new Notification.Builder(this);
        builder.setSmallIcon(android.R.drawable.star_on)
                .setLargeIcon(largeIcon)                           //設定大圖示
                .setWhen(System.currentTimeMillis())
                .setTicker("大圖通知")                               //設定狀態列文字
                .setContentTitle(this.getString(R.string.app_name));


        // 建立大型圖片樣式物件
        Notification.BigPictureStyle bigPictureStyle =new Notification.BigPictureStyle();
        // 設定圖片與簡介
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.a11);
        bigPictureStyle.bigPicture(bitmap)
                .setSummaryText("Laemy title");
        // 設定樣式為大型圖片
        builder.setStyle(bigPictureStyle);
        // 發出通知
        nm.notify(this.getString(R.string.app_name),901, builder.build());

    }

    public void btnbigP2_Click(View view) {
        // 取得NotificationManager物件
        NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        // 建立大圖示需要的Bitmap物件
        Bitmap largeIcon = BitmapFactory.decodeResource(
                getResources(), R.drawable.a64_5);

        // 建立Notification.Builder物件，因為要設定大型圖片樣式
        // 所以不能使用NotificationCompat.Builder
        Notification.Builder builder = new Notification.Builder(this);
        builder.setSmallIcon(android.R.drawable.ic_menu_today)
                .setLargeIcon(largeIcon)                           //設定大圖示
                .setWhen(System.currentTimeMillis())
                .setTicker("大圖通知2")                               //設定狀態列文字
                .setContentTitle(this.getString(R.string.app_name));


        // 建立大型圖片樣式物件
        Notification.BigPictureStyle bigPictureStyle =new Notification.BigPictureStyle();
        // 設定圖片與簡介
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.a12);
        bigPictureStyle.bigPicture(bitmap)
                .setSummaryText("Laemy title");
        // 設定樣式為大型圖片
        builder.setStyle(bigPictureStyle);
        // 發出通知
        nm.notify(this.getString(R.string.app_name),902, builder.build());

    }

    public void btnClearAll_Click(View view) {

        // 取得NotificationManager物件
        NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        nm.cancelAll();

    }

}
