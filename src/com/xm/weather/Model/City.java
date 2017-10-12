package com.xm.weather.Model;

public class City {
	//城市名
    private String city_name;
    //城市id
    private String city_id;
    //所属省份id
    private String province_id;

    public String getCityName() {
        return city_name;
    }

    public void setCityName(String city_name) {
        this.city_name = city_name;
    }

    public String getCityId() {
        return city_id;
    }

    public void setCityId(String city_id) {
        this.city_id = city_id;
    }

    public String getProvinceId() {
        return province_id;
    }

    public void setProvinceId(String province_id) {
        this.province_id = province_id;
    }

}
