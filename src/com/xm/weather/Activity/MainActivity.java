package com.xm.weather.Activity;


import android.app.Activity;
import android.os.Bundle;
import com.xm.weather.Util.*;
public class MainActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);//调用了父类的onCreate()方法  
        setContentView(R.layout.main_layout);
        HttpQuery htt = new HttpQuery();
        htt.sendHttpRequest();
    } 

}
