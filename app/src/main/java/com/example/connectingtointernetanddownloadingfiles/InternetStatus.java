package com.example.connectingtointernetanddownloadingfiles;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;

public class InternetStatus {
    public static boolean having_Wifi = false;
    public static boolean having_MobilData = false;
    public static boolean connectionStatus(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] info = connectivityManager.getAllNetworkInfo();
        for (NetworkInfo networkInfo : info) {
            if (networkInfo.isAvailable() && networkInfo.isConnected()) {
                if (networkInfo.getTypeName().equalsIgnoreCase("WIFI"))
                    having_Wifi = true;
                if (networkInfo.getTypeName().equalsIgnoreCase("MOBILE"))
                    having_MobilData = true;
            }
        }
        return having_MobilData || having_Wifi;
    }
}
