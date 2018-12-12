package com.example.malapatichetan.configuration;

import android.content.Context;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.LineNumberReader;
import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
        public void Start (View view){


            btn = (Button) findViewById(R.id.button);
            tv = (TextView) findViewById(R.id.tv);


            TelephonyManager tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);

            String IMEINumber = tm.getDeviceId();
            String subscriberID = tm.getDeviceId();
            String SIMSerialNumber = tm.getSimSerialNumber();
            String networkCountryISO = tm.getNetworkCountryIso();
            String SIMCountryISO = tm.getSimCountryIso();
            String softwareVersion = tm.getDeviceSoftwareVersion();
            String voiceMailNumber = tm.getVoiceMailNumber();
            String SIMOperatorName = tm.getSimOperatorName();
            String SIMOperator = tm.getSimOperator();
            String NetWorkOperatorName = tm.getNetworkOperatorName();
          //  String Listen = tm.listen(myCustomPhoneStateListener,PhoneStateListener.LISTEN_DATA_CONNECTION_STATE);


            int phoneType = tm.getPhoneType();

            switch (phoneType) {
                case (TelephonyManager.PHONE_TYPE_CDMA):
                    // your code
                    break;
                case (TelephonyManager.PHONE_TYPE_GSM):
                    // your code
                    break;
                case (TelephonyManager.PHONE_TYPE_NONE):
                    // your code
                    break;
                case (TelephonyManager.NETWORK_TYPE_LTE):
                    // your code
                    break;


            }

            boolean isRoaming = tm.isNetworkRoaming();
            //       if(isRoaming)
            //           phoneDetails+="\nIs In Roaming : "+"YES";
            //       else
            //           phoneDetails+="\nIs In Roaming : "+"NO";


            int SIMState = tm.getSimState();
            switch (SIMState) {
                case TelephonyManager.SIM_STATE_ABSENT:
                    // your code
                    break;
                case TelephonyManager.SIM_STATE_NETWORK_LOCKED:
                    // your code
                    break;
                case TelephonyManager.SIM_STATE_PIN_REQUIRED:
                    // your code
                    break;
                case TelephonyManager.SIM_STATE_PUK_REQUIRED:
                    // your code
                    break;
                case TelephonyManager.SIM_STATE_READY:
                    // your code
                    break;
                case TelephonyManager.SIM_STATE_UNKNOWN:
                    // your code
                    break;

            }

            String MyPhoneNumber = "0000000000";

            try {
                MyPhoneNumber = tm.getLine1Number();
            } catch (NullPointerException ex) {
            }

            if (MyPhoneNumber.equals("")) {
                MyPhoneNumber = tm.getSubscriberId();
            }


            boolean mobileDataEnabled = false; // Assume disabled
            ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            try {
                Class cmClass = Class.forName(cm.getClass().getName());
                Method method = cmClass.getDeclaredMethod("getMobileDataEnabled");
                method.setAccessible(true); // Make the method callable
                // get the setting for "mobile data"
                mobileDataEnabled = (Boolean)method.invoke(cm);
            } catch (Exception e) {
                // Some problem accessible private API
                // TODO do whatever error handling you want here
            }















            String info = "Phone Details:\n";


            info += "\n IMEI Number:" + IMEINumber;
            info += "\n SubscriberID:" + subscriberID;
            info += "\n Sim Serial Number:" + SIMSerialNumber;
            info += "\n Network Country ISO:" + networkCountryISO;
            info += "\n Sim Country ISO:" + SIMCountryISO;
            info += "\n Software Version:" + softwareVersion;
            info += "\n Voice Mail Number:" + voiceMailNumber;
            info += "\n Phone Network Type:" + phoneType;
            info += "\n In Roaming:" + isRoaming;
            info += "\n Sim State:" + SIMState;
            info += "\n My Phone Number:" + MyPhoneNumber;
            info += "\n Sim Operator Name:" + SIMOperatorName;
            info += "\n Sim Operator:" + SIMOperator;
            info += "\n Network Operator Name:" + NetWorkOperatorName;
         //   info += "\n Phone State Listener:" + Listen;
            info += "\n Mobile Data Enabled:" + mobileDataEnabled;

            tv.setText(info);


    }

}
