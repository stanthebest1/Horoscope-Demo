package com.models;

public class Horoscope {

    String horoscope;

    String Zodiac;

    String description;

    Integer user_id;

    public Horoscope(String description, Integer user_id) {
        this.description = description;
        this.user_id = user_id;
    }

    public Horoscope(String zodiac) {
        Zodiac = zodiac;
    }


    public Horoscope(String horoscope, String description, Integer user_id) {
        this.horoscope= horoscope;
        this.description = description;
        this.user_id = user_id;
    }

    public Horoscope(String username, String user_password, String firstname, String lastname, String email, String zodiac) {
    }

    public String getZodiac() {
        return Zodiac;
    }

    public void setZodiac(String zodiac) {
        Zodiac = zodiac;
    }

    public String getHoroscope() {
        return horoscope;
    }

    public void setHoroscope_Id(String horoscope) {
        this.horoscope = horoscope;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
}
