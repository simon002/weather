package com.xm.weather.DB;
import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.xm.weather.Model.City;
import com.xm.weather.Model.County;
import com.xm.weather.Model.Province;
public class WeatherDB {
	// ���ݿ���
    private static final String DataBaseName = "XMWeather";

    private static final int VERSION = 1;

    private SQLiteDatabase db;

    private static WeatherDB weatherDB;
    //���캯��˽�л�
    private WeatherDB(Context context) {
        DataBaseHelper dataBaseHelper = new DataBaseHelper(context,
                DataBaseName, null, VERSION);
        db = dataBaseHelper.getWritableDatabase();
    }

    // ��ȡ���ݿ��Ψһʵ��
    public static WeatherDB getInstance(Context context) {
        if (weatherDB == null) {
            weatherDB = new WeatherDB(context);
            return weatherDB;
        }
        return weatherDB;
    }

    // ����ʡ������
    public void saveProvince(Province province) {
        if (province != null) {
            ContentValues values = new ContentValues();
            values.put("province_name", province.getProvinceName());
            values.put("province_id", province.getProvinceId());
            db.insert("Province", null, values);
        }
    }

    // �����м�����
    public void saveCity(City city) {
        if (city != null) {
            ContentValues values = new ContentValues();
            values.put("city_name", city.getCityName());
            values.put("city_id", city.getCityId());
            values.put("province_id", city.getProvinceId());
            db.insert("City", null, values);
        }
    }

    // �����缶����
    public void saveCounty(County county) {
        if (county != null) {
            ContentValues values = new ContentValues();
            values.put("county_name", county.getCountyName());
            values.put("county_id", county.getCountyId());
            values.put("city_id", county.getCityId());
            db.insert("County", null, values);
        }
    }

    // ���ر�������ʡ������
    public List<Province> loadProvinces() {
        List<Province> list = new ArrayList<Province>();
        Cursor cursor = db
                .query("Province", null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                Province province = new Province();
                province.setProvinceName(cursor.getString(cursor
                        .getColumnIndex("province_name")));
                province.setProvinceId(cursor.getString(cursor
                        .getColumnIndex("province_id")));
                list.add(province);
            } while (cursor.moveToNext());
        }
        return list;
    }

    // ���ر��������м�����
    public List<City> loadCities(String provinceId) {
        List<City> list = new ArrayList<City>();
        Cursor cursor = db.query("City", null, "province_id = ?",
                new String[] { provinceId }, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                City city = new City();
                city.setCityName(cursor.getString(cursor
                        .getColumnIndex("city_name")));
                city.setCityId(cursor.getString(cursor
                        .getColumnIndex("city_id")));
                city.setProvinceId(provinceId);
                list.add(city);
            } while (cursor.moveToNext());
        }
        return list;
    }

    // ���ر��������缶����
    public List<County> loadCounties(String cityId) {
        List<County> list = new ArrayList<County>();
        Cursor cursor = db.query("County", null, "city_id=?",
                new String[] { cityId }, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                County county = new County();
                county.setCountyName(cursor.getString(cursor
                        .getColumnIndex("county_name")));
                county.setCountyId(cursor.getString(cursor
                        .getColumnIndex("county_id")));
                county.setCityId(cityId);
                list.add(county);
            } while (cursor.moveToNext());
        }
        return list;
    }
}
