package com.xm.weather.Util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;

import android.content.Context;

import com.xm.weather.DB.DataBaseHelper;
import com.xm.weather.DB.WeatherDB;

public class HttpQuery {
	private static HttpQuery httpQuery;


    // 获取数据库的唯一实例
    public static HttpQuery getInstance() {
        if (httpQuery == null) {
        	httpQuery = new HttpQuery();
            return httpQuery;
        }
        return httpQuery;
    }
    
    
	
    
    public static void sendHttpRequest() {
        new Thread(new Runnable() {
            public void run() {
                
                try {
                	/*String host = "http://jisutqybmf.market.alicloudapi.com";
            	    String path = "/weather/query";
            	    String method = "GET";
            	    String appcode = "37dff993f04e4770bc1941214d9e9bff";
            	    Map<String, String> headers = new HashMap<String, String>();
            	    //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
            	    headers.put("Authorization", "APPCODE " + appcode);
            	    Map<String, String> querys = new HashMap<String, String>();
            	    querys.put("city", "安顺");
            	    querys.put("citycode", "citycode");
            	    querys.put("cityid", "cityid");
            	    querys.put("ip", "ip");
            	    querys.put("location", "location");
        	    	HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
        	    	String jjj = response.toString();
        	    	System.out.println(response.toString());*/
                	
                	
                	String host = "http://ali-weather.showapi.com";
                    final String path = "/area-to-weather";
                    final String method = "GET";
                    String appcode = "c402356e77824e7d8a23eebf6cf6d0b5";
                    final Map<String, String> headers = new HashMap();
                    final Map<String, String> querys = new HashMap();

                    headers.put("Authorization", "APPCODE " + appcode);
                    querys.put("area", "济南");
                    querys.put("need3HourForcast", "0");
                    querys.put("needAlarm", "0");
                    querys.put("needHourData", "1");
                    querys.put("needIndex", "1");
                    querys.put("needMoreDay", "1");

                    String content = "";

                    HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
                    BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "utf-8"));
                    for (String s = reader.readLine(); s != null; s = reader.readLine()) {
                            content += s;
                        }
        	    	
        	    	
                } catch (Exception e) {
                	e.printStackTrace();
                } 
            }
        }).start();
    }
}
