package com.example.esempiobroadcastreceiver.br;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.example.esempiobroadcastreceiver.R;

public class MyBroadcastReceiver extends BroadcastReceiver {

    private final String TAG = "MyBroadcastReceiver";
    public MyBroadcastReceiver(){
        Log.i(TAG,"Costruttore MyBroadcastReceiver");
    }

    @Override
    public void onReceive(Context context, Intent _i) {
        Log.i(TAG,"OnReceive MyBroadcastReceiver");

        String _mex = _i.getStringExtra(context.getString(R.string.STRING_MEX));
        Toast.makeText(context,"Messaggio: " + _mex,Toast.LENGTH_SHORT).show();
        //Toast.makeText(context,"Messaggio: " + "Modalita aereo On/off",Toast.LENGTH_SHORT).show();
    }
}
