package com.xm.weather.Model;

public class City {
	//������
    private String city_name;
    //����id
    private String city_id;
    //����ʡ��id
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
