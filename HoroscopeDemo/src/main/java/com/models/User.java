package com.models;

public class User {
    private Integer user_id;

    private String first_name;

    private String last_name;

    private String email;

    private String Password;

    private String Zodiac;

    private String horoscope;

    private String Mood;

    public User(int user_id, String first_name, String password, String email){

    }

    public User(String first_name, String last_name, String email, String password, String zodiac, String horoscope, String mood) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        Password = password;
        Zodiac = zodiac;
        this.horoscope = horoscope;
        Mood = mood;
    }



    public User(String password) {
        Password = password;
    }

    public User(Integer user_id, String first_name, String last_name, String email, String horoscope, String mood) {
        this.user_id = user_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.horoscope = horoscope;
        Mood = mood;
    }

    public User(String first_name, String last_name, String email, String horoscope, String mood) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.horoscope = horoscope;
        Mood = mood;
    }

    public String getZodiac() {
        return Zodiac;
    }

    public void setZodiac(String zodiac) {
        Zodiac = zodiac;
    }

    public User(String username, String user_password, String firstname, String lastname, String email, String zodiac) {
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHoroscope() {
        return horoscope;
    }

    public void setHoroscope(String horoscope) {
        this.horoscope = horoscope;
    }

    public String getMood() {
        return Mood;
    }

    public void setMood(String mood) {
        Mood = mood;
    }
}
