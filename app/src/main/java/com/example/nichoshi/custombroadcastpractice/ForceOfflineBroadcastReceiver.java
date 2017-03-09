package com.example.nichoshi.custombroadcastpractice;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.preference.DialogPreference;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

/**
 * Created by NichoShi on 2017/3/8.
 */

public class ForceOfflineBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(final Context context, Intent intent) {
        AlertDialog.Builder alertBuild = new AlertDialog.Builder(context);
        alertBuild.setTitle("下线提示");
        alertBuild.setCancelable(false);
        alertBuild.setMessage("您已被强制下线，请重新登录");
        alertBuild.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ActivityCotroller.finishAll();
                Intent intent = new Intent(context,MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);



            }
        });
        AlertDialog alertDialog = alertBuild.create();
        // 需要设置AlertDialog的类型，保证在广播接收器中可以正常弹出
        alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
        alertDialog.show();


    }
}
