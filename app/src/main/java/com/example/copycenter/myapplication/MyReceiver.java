package com.example.copycenter.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

public class MyReceiver extends BroadcastReceiver {
    WindowManager wm;
    LinearLayout ly;

    @Override
    public void onReceive(Context context, Intent intent) {
        String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
            if (state.equals(TelephonyManager.EXTRA_STATE_RINGING)) {
                wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
                final WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                        WindowManager.LayoutParams.MATCH_PARENT,
                        WindowManager.LayoutParams.MATCH_PARENT,
                        WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON,
                        WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                        PixelFormat.TRANSLUCENT);
                params.height = WindowManager.LayoutParams.MATCH_PARENT;
                params.width = WindowManager.LayoutParams.MATCH_PARENT;
                params.format = PixelFormat.TRANSLUCENT;

                params.gravity = Gravity.TOP;


                ly = new LinearLayout(context);
                ly.setBackgroundColor(Color.RED);
                ly.setOrientation(LinearLayout.VERTICAL);
                wm.addView(ly, params);
                ly.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        wm.removeViewImmediate(ly);
                    }
                });
            }
            wm.getDefaultDisplay();
        }
    }


