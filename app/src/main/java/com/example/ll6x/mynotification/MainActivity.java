package com.example.ll6x.mynotification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
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
        nm.notify("Laemy APP", 001, notification);
    }

    public void btn02_Click(View view) {

        final boolean autoCancel = true; // 點擊通知後是否要自動移除掉通知
        final int notifyID = 002; // 通知的識別號碼
        final int requestCode = notifyID; // PendingIntent的Request Code
        final Intent intent = getIntent(); // 目前Activity的Intent

        // ONE_SHOT：PendingIntent只使用一次；
        // CANCEL_CURRENT：PendingIntent執行前會先結束掉之前的；
        // NO_CREATE：沿用先前的PendingIntent，不建立新的PendingIntent；
        // UPDATE_CURRENT：更新先前PendingIntent所帶的額外資料，並繼續沿用
        final int flags = PendingIntent.FLAG_CANCEL_CURRENT;
        final PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), requestCode, intent, flags); // 取得PendingIntent

        NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        Bitmap largeIcon = BitmapFactory.decodeResource(
                getResources(), R.drawable.a64_2);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);

        builder.setSmallIcon(android.R.drawable.btn_star)    //設定小圖示
                .setLargeIcon(largeIcon)                           //設定大圖示
                .setWhen(System.currentTimeMillis())                  //設定時間
                .setTicker("Hello II")                            //設定狀態列文字
                .setContentTitle("Laemy通知二")                   //設定內容標題
                .setContentText("這是Laemy的系統提醒通知！!")    //設定內容訊息
                .setContentInfo("注意!")                         //設定內容額外資訊
                .setContentIntent(pendingIntent)                //設定點擊後開啟的頁面
                .setAutoCancel(autoCancel);                     //設定點擊完自動移除訊息

        Notification notification = builder.build();
        nm.notify("Laemy APP", 002, notification);

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

        nm.notify("Laemy APP", 003, notification);

    }

    public void btnClear_Click(View view) {

        // 取得NotificationManager物件
        NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        // 清除BASIC_ID編號的通知
        nm.cancel("Laemy APP", 003);

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
        Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle();
        // 設定圖片與簡介
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.a11);
        bigPictureStyle.bigPicture(bitmap)
                .setSummaryText("給你一張笑臉圖");
        // 設定樣式為大型圖片
        builder.setStyle(bigPictureStyle);
        // 發出通知
        nm.notify(this.getString(R.string.app_name), 901, builder.build());

    }

    public void btnbigP2_Click(View view) {


        // 取得NotificationManager物件
        NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        // 建立大圖示需要的Bitmap物件
        Bitmap largeIcon = BitmapFactory.decodeResource(
                getResources(), R.drawable.a64_6);

        // 建立Notification.Builder物件，因為要設定大型內容樣式
        // 所以不能使用NotificationCompat.Builder
        Notification.Builder builder = new Notification.Builder(this);
        builder.setSmallIcon(android.R.drawable.ic_menu_today)
                .setLargeIcon(largeIcon)                           //設定大圖示
                .setWhen(System.currentTimeMillis())
                .setTicker("多文通知")                               //設定狀態列文字
                .setContentTitle(this.getString(R.string.app_name));

        final Notification.BigTextStyle bigTextStyle = new Notification.BigTextStyle(); // 建立BigTextStyle
        bigTextStyle.setBigContentTitle("石壕吏 (杜甫)"); // 當BigTextStyle顯示時，用BigTextStyle的setBigContentTitle覆蓋setContentTitle的設定
        bigTextStyle.bigText("暮投石壕村，有吏夜捉人。\n老翁越牆走，老婦出門看。\n吏呼一何怒！婦啼一何苦！\n聽婦前致詞：三男鄴城戍，\n" +
                "一男附書至，二男新戰死。\n存者且偷生，死者長已矣！\n室中更無人，惟有乳下孫，\n老嫗力雖衰，請從吏夜歸，\n" +
                "急應河陽役，猶得備晨炊。\n夜久語聲絕，如聞泣幽咽。\n天明登前途，獨與老翁别。"); // 設定BigTextStyle的文字內容

        // 設定樣式
        builder.setStyle(bigTextStyle);

        // 發出通知
        nm.notify(this.getString(R.string.app_name), 902, builder.build());

    }

    public void btnClearAll_Click(View view) {

        // 取得NotificationManager物件
        NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        nm.cancelAll();

    }

    public void btnbigP3_Click(View view) {

        // 取得NotificationManager物件
        NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        // 建立大圖示需要的Bitmap物件
        Bitmap largeIcon = BitmapFactory.decodeResource(
                getResources(), R.drawable.a64_5);

        // 建立Notification.Builder物件，因為要設定大型內容樣式
        // 所以不能使用NotificationCompat.Builder
        Notification.Builder builder = new Notification.Builder(this);
        builder.setSmallIcon(android.R.drawable.ic_dialog_email)
                .setLargeIcon(largeIcon)                           //設定大圖示
                .setWhen(System.currentTimeMillis())
                .setTicker("列表通知")                               //設定狀態列文字
                .setContentTitle(this.getString(R.string.app_name));

        final Notification.InboxStyle inboxStyle = new Notification.InboxStyle(); // 建立InboxStyle
        final String[] lines = new String[]{"今天沒放颱風假", "今天天氣是雨天", "明天還會是雨天"}; // InboxStyle要顯示的字串內容
        inboxStyle.setBigContentTitle("Laemy Info："); // 當InboxStyle顯示時，用InboxStyle的setBigContentTitle覆蓋setContentTitle的設定
        inboxStyle.setSummaryText("更多新訊息(3+)"); // InboxStyle的底部訊息
        for (int i = 0; i < lines.length; i++) {
            inboxStyle.addLine(String.format("%d: %s", i + 1, lines[i])); // 將字串加入InboxStyle
        }

        // 設定樣式
        builder.setStyle(inboxStyle);

        // 發出通知
        nm.notify(this.getString(R.string.app_name), 903, builder.build());


    }
}
