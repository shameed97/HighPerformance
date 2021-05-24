package sha.personal.highperformance.receiver;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.Settings;
import android.util.Log;

import androidx.appcompat.widget.AppCompatButton;
import androidx.lifecycle.ViewModel;

import java.util.Objects;

import sha.personal.highperformance.R;


public class MyReceiver extends BroadcastReceiver {
    private Dialog dialog;
    private boolean isShown = false;

    public MyReceiver() {
    }

    @SuppressLint("UnsafeProtectedBroadcastReceiver")
    @Override
    public void onReceive(Context context, Intent intent) {

        try {
            if (isNetworkAvailable(context)) {
                if (isShown) {
                    dialog.dismiss();
                    isShown = false;
                }
            } else {
                if (isShown) {
                    dialog.dismiss();
                    showDialog(context);
                } else {
                    showDialog(context);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void showDialog(Context context) {
        Log.e("TAG", "showDialog: " );

        dialog = new Dialog(context);
        dialog.setContentView(R.layout.layout_connection_popup);
        dialog.setCancelable(false);
        isShown = true;
        AppCompatButton btn_enable = dialog.findViewById(R.id.nConnection);

        btn_enable.setOnClickListener(v -> {
            isShown = false;
            dialog.dismiss();

            Intent i = new Intent(Settings.ACTION_WIRELESS_SETTINGS);
            context.startActivity(i);
        });
        try {
            Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private boolean isNetworkAvailable(Context context) {
        try {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo netInfo = cm.getActiveNetworkInfo();

            //should check null because in airplane mode it will be null
            return (netInfo != null && netInfo.isConnected());
        } catch (NullPointerException e) {
            e.printStackTrace();
            return false;
        }
    }
}
