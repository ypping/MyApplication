package myapplication.yuan.com.myapplication;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;

/**
 * Created by yuan-pc on 5/17 0017.
 */
public class MyBroadcastReciver extends BroadcastReceiver {
    private final String action_boot = "android.intent.action.BOOT_COMPLETED";
    private Context con;

    @Override
    public void onReceive(final Context context, Intent intent) {
        Log.i(">>>>>>>", intent.getAction().equals(action_boot) + "");
        if (intent.getAction().equals(action_boot)) {
            this.con = context;
            Log.i(">>>>>>>", ">>>>>>>>>>>>>>>>>" +
                    ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>.>>>>>>>>>>>>>>>>>>>>>>>>>>>.");
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent1 = new Intent(con, MainActivity.class);
                    intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    con.startActivity(intent1);
                }
            }, 500);

        }
    }

    public MyBroadcastReciver() {
    }


}
