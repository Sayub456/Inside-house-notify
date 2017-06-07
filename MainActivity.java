package com.mininpl.bluetooth_chat;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    public Button bt1;
    Switch switchButton;
    TextView textview;
    BluetoothAdapter bluetoothadapter;
    int i = 1;
    Intent bluetoothIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();


        switchButton = (Switch)findViewById(R.id.switch1);
        textview = (TextView)findViewById(R.id.textView1);

        bluetoothadapter = BluetoothAdapter.getDefaultAdapter();

        switchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                                                    @Override
                                                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){// TODO Auto-generated method stub



                                                        if(!isChecked)
                                                        {

                                                            BluetoothDisable();


                                                        }
                                                        else {


                                                            BluetoothEnable();


                                                        }
/*
                Intent paireddeIntent = new Intent(MainActivity.this, pair_unpair.class);
                MainActivity.this.startActivity(paireddeIntent);*/
                                                    }
                                                }

        );

    }

    public void BluetoothEnable(){

        bluetoothIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);

        startActivityForResult(bluetoothIntent, i);

        textview.setText("Bluetooth ON");

    }

    public void BluetoothDisable(){

        bluetoothadapter.disable();

        textview.setText("Bluetooth OFF");

    }


    public void init() {
        bt1=(Button)findViewById(R.id.button);
        bt1.setOnClickListener(new View.OnClickListener(){
                                   @Override
                                   public void onClick(View v)
                                   {
                                       Intent paireddeIntent = new Intent(MainActivity.this,BluetoothChat.class);
                                       MainActivity.this.startActivity(paireddeIntent);

                                   }
                               }
        );
    }

}
