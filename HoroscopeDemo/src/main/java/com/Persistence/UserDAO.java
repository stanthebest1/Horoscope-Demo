package com.Persistence;

import com.Utils.CustomCRUDInterface;
import com.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDAO implements CustomCRUDInterface<User> {

    Connection connection;

    public UserDAO(Connection connection) {
        this.connection = connection;
    }

    public UserDAO() {

    }


    @Override
    public Integer create(User user) {

        try{
            String sql = "INSERT INTO users (user_id, first_name ,  last_name, email, password, horoscope, mood) VALUES (default,?,?,?)";
            PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1,user.getFirst_name());
            pstmt.setString(2, user.getLast_name());
            pstmt.setString(3, user.getEmail());
            pstmt.setString(3, user.getPassword());
            pstmt.setString(3, user.getHoroscope());
            pstmt.setString(3, user.getMood());



            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();

            rs.next();

            return rs.getInt("user_id");



        }catch (Exception e){
            System.out.println("Error in the user Dao: " + e.getMessage());
        }


        return null;
    }


    @Override
    public User read(Integer id) {

        try{
            String sql = "SELECT * FROM users WHERE user_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setInt(1,id);

            ResultSet rs = pstmt.executeQuery();

            User user = new User(rs.getInt("user_id"), rs.getString("first_name"), rs.getString("password"), rs.getString("email"));

            while (rs.next()){
                user.setUser_id(rs.getInt("user_Id"));
                user.setFirst_name(rs.getString("first_name"));
                user.setLast_name(rs.getString("last_name"));
                user.setEmail(rs.getString("email"));
            }

            return user;

        }catch(Exception e){
            System.out.println("This is the UserDAO" + e.getMessage());

        }




        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    public User loginUser(String email, String password){

        try{
            String sql = "SELECT * FROM users WHERE email = ? ";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1,email);

            ResultSet rs = pstmt.executeQuery();

            if(rs.next() && rs.getString("password").equals(password)){
                return  new User(rs.getInt("user_id"),
                        rs.getString("first_name"),
                        rs.getString("password"),
                        rs.getString("email"));

            }


        }catch(Exception e){
            System.out.println("This is the UserDAO: " + e.getMessage());
        }

        return null;
    }



}

