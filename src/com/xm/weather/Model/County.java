package com.xm.weather.Model;

public class County {
	//����
    private String county_name;
    //��id
    private String county_id;
    //��������id
    private String city_id;

    public String getCountyName() {
        return county_name;
    }

    public void setCountyName(String county_name) {
        this.county_name = county_name;
    }

    public String getCountyId() {
        return county_id;
    }

    public void setCountyId(String county_id) {
        this.county_id = county_id;
    }

    public String getCityId() {
        return city_id;
    }

    public void setCityId(String city_id) {
        this.city_id = city_id;
    }
}
