package com.Persistence;

import com.Utils.CustomCRUDInterface;
import com.models.Horoscope;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class HoroscopeDAO implements CustomCRUDInterface<Horoscope> {


    Connection connection;

    public HoroscopeDAO(Connection connection) {
        this.connection = connection;
    }

    public HoroscopeDAO() {

    }

    @Override
    public Integer create(Horoscope horoscope) {

        try {
            String sql = "INSERT INTO (Horoscope_id, description, user_id) VALUES (default,?,?,)";
            PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, horoscope.getDescription());
            pstmt.setInt(2, horoscope.getUser_id());

            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();

            rs.next();

            return rs.getInt(1);
        } catch (Exception e) {
            System.out.println("This is this horoscopeDAO: " + e.getMessage());
        }
        return null;
    }


    @Override
    public Horoscope read(Integer id) {
        return null;
    }

    @Override
    public Horoscope update(Horoscope horoscope) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    public ArrayList<Horoscope> getAllHoroscopeForCurrentUser(Integer id) {
        ArrayList<Horoscope> allHoroscopes = new ArrayList<>();

        try {
            String sql = "SELECT FROM HOROSCOPES WHERE user_id = ? ";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Horoscope newHoroscope = new Horoscope(rs.getString(1), rs.getString(2),
                        rs.getInt(3));
                allHoroscopes.add(newHoroscope);
            }

        } catch (Exception e) {
            System.out.println("This is the TicketDAO: " + e.getMessage());

        }

        return allHoroscopes;

    }

}





