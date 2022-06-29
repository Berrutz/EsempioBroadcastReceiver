package com.example.esempiobroadcastreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.esempiobroadcastreceiver.br.MyBroadcastReceiver;

/* Invia un messaggio in broadcast e tutti lo ascoltano poi chi vuole se ne accorge ( es. collegato a un wifi ) */
public class MainActivity extends AppCompatActivity {

    private EditText etText = null;
    private Button bttOk = null;
    private BroadcastReceiver Mybr = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etText = findViewById(R.id.etTesto);
        bttOk = findViewById(R.id.bttOK);
        //polimorfismo per creare BroadcastReceiver
        Mybr = new MyBroadcastReceiver();
        // Registrazione tra BR e Intent , IntentFilter gestisce intenti
        IntentFilter _if = new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED); // intent filter su modalita aereo ecc..
        //IntentFilter _if = new IntentFilter(getString(R.string.ACTION_BR)); // intent filter mio con stringa
        registerReceiver(Mybr,_if);
        //registerReceiver(Mybr,_if1);

        bttOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String _s = etText.getText().toString();
                Intent _i = new Intent(getString(R.string.ACTION_BR));  // intento che attiva BR associato alla stringa
                _i.putExtra(getString(R.string.STRING_MEX),_s); // chiave e stringa
                sendBroadcast(_i);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(Mybr);
    }
}