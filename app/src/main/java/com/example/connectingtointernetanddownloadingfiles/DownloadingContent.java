package com.example.connectingtointernetanddownloadingfiles;

import android.app.DownloadManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Environment;
import android.widget.Toast;

import java.io.File;
import java.sql.DriverManager;

public class DownloadingContent {
    public  void downloadImage(Context context, String fileName, String url){
        try{
            DownloadManager.Request request=new DownloadManager.Request(Uri.parse(url));
            request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI|DownloadManager.Request.NETWORK_MOBILE);
            request.setAllowedOverRoaming(false);
            request.setTitle(fileName);
            request.setDescription("Downloading..."+fileName);
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES,fileName+".jpg");
            DownloadManager downloadManager= (DownloadManager) context.getSystemService(context.DOWNLOAD_SERVICE);
            downloadManager.enqueue(request);
            Toast.makeText(context.getApplicationContext(),"image saved",Toast.LENGTH_SHORT).show();
        }catch (Exception e) {
            Toast.makeText(context.getApplicationContext(),"Error",Toast.LENGTH_SHORT).show();
        }
    }
}
