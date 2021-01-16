package com.xayappz.InternetStatus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.Observer
import com.xayappz.InternetStatus.Connectivity.ConnectivityLiveData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var connectivityLiveData:ConnectivityLiveData
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        connectivityLiveData= ConnectivityLiveData(application)
        connectivityLiveData.observe(this, Observer {isAvailable->

            if(isAvailable)
            {
                textView.text="  Internet Available"
                textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.yes_internet, 0, 0, 0);


            }else
            {
                textView.text="  No Internet Available"
                textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.no_internet, 0, 0, 0);

            }
        })
    }
}