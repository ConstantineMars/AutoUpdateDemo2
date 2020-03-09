package com.example.autoupdatedemo2

import android.os.Bundle
import android.os.Environment
import android.os.Environment.getExternalStoragePublicDirectory
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.ixuea.android.downloader.DownloadService
import com.ixuea.android.downloader.domain.DownloadInfo
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

//    private var fetch: Fetch? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d( "MainActivity", getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).toString() + "/a.apk")

        button.setOnClickListener {
            download("https://github.com/ConstantineMars/AutoUpdaterDemo/raw/master/apk/1.2.apk",
                 getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).toString() + "/a.apk")
        }
    }

    fun download(url: String, file: String) {
        val downloadManager = DownloadService.getDownloadManager(getApplicationContext());
        val downloadInfo = DownloadInfo.Builder().setUrl(url)
            .setPath(file)
            .build()
        downloadManager.download(downloadInfo);
    }
}
