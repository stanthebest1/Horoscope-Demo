package com.Utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Register {

    public static Register register;
    public static Integer user_Id;
    public static String first_name;
    public static String last_name;
    public static String email;

    public static String horoscope;

    public static String mood;


    public Register(){

    }

    public Register(Integer user_Id, String first_name, String last_name, String email, String horoscope, String mood){


        Register.user_Id = user_Id;
        Register.first_name = first_name;
        Register.last_name = last_name;
        Register.email = email;
        Register.horoscope = horoscope;
        Register.mood = mood;


    }

    public Register(HttpServletRequest req, HttpServletResponse resp) {
    }
}
