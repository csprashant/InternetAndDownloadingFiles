package com.example.connectingtointernetanddownloadingfiles;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;

import androidx.annotation.RequiresApi;

public class InternetStatus {
    public static boolean having_Wifi = false;
    public static boolean having_MobilData = false;
    @RequiresApi(api = Build.VERSION_CODES.M)
    public static boolean connectionStatus(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = connectivityManager.getActiveNetworkInfo();
        if(info!=null&&info.isConnected()&&info.isAvailable())
            return true;
        else
            return false;
    }
}
