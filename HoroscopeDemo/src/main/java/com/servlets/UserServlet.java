package com.servlets;

import com.Persistence.UserDAO;
import com.Utils.Register;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.models.Horoscope;
import com.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class UserServlet extends HttpServlet {

    UserDAO userDAO = new UserDAO();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }


        @Override
        protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String URI = req.getRequestURI().replace("/HoroscopeDemo/", "");
            System.out.println(URI);

            switch (URI) {
                case "user":

                    System.out.println("user");

                    processUserLogin(req, resp);

                    break;

                case "register":
                    registerUser(req, resp);
                    System.out.println("register");
                    break;


                default:
                    System.out.println("We are in the default");


                    break;
            }


        }

    private void registerUser(HttpServletRequest req, HttpServletResponse resp) {
    }


    private void processUserLogin (HttpServletRequest req, HttpServletResponse resp) throws
        IOException, ServletException {
            BufferedReader br = req.getReader();
            String line = br.readLine();

            StringBuilder sb = new StringBuilder();


            while (line != null) {
                sb.append(line);
                line = br.readLine();
            }
            System.out.println(sb);

            String body = sb.toString();

            String[] sepByComma = body.split(",");

            ArrayList<String> values = new ArrayList<>();

            for (String value : sepByComma) {
                //System.out.println(value);

                //here we want to trim all of the excess symbols as well as the
                //keys and keys the values
                // note we can add multiple replaceAll
                value = value.replaceAll("\\{", "").replaceAll("}", "").replaceAll("\"", "");
                System.out.println(value);
                String target = value.substring(value.indexOf(":") + 1);

                System.out.println(target);
                values.add(target);

            }
            String email = values.get(0);
            String password = values.get(1);
// here we are doing the logic to actually login
            User user = userDAO.loginUser(email, password);
            if (user != null) {
                resp.setStatus(200);
                //get an HTTP Session
                HttpSession session = req.getSession();
                session.setAttribute("user", user);

                PrintWriter out = resp.getWriter();
                resp.setContentType("application/json");
                resp.addHeader("Access-Control-Allow-Origin", "*");

                ObjectMapper om = new ObjectMapper();

                // convert the object with the mapper

                out.println(om.writeValueAsString(user));
                System.out.println("The user with :" + email + " has logged in");

            } else {
                resp.setStatus(204);

            }


        }

//    private void getAllHoroscopesForCurrentUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
//        resp.setStatus(200);
//        resp.setContentType("application/json");
//
//        //get the user id that we set in the header
//        Integer id = Integer.parseInt(req.getHeader("user-id"));
//
//        System.out.println(id + "this is the user id from our header");
//
//        //get the tickets from the backend
//        ArrayList<Horoscope> allTickets = horoscopeDAO.getAllHoroscopeForCurrentUser(id);
//
//        //create object mapper - this while change our array to JSON
//        ObjectMapper mapper = new ObjectMapper();
//        String json = mapper.writeValueAsString(allTickets);
//        System.out.println(json);
//        PrintWriter out = resp.getWriter();
//        out.println(json);
//    }

        private void Register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
        {

            BufferedReader br = req.getReader();
            StringBuilder sb = new StringBuilder();

            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                line = br.readLine();
            }
            System.out.println(sb);

            String body = sb.toString();
            String[] sepByComma = body.split(",");
            ArrayList<String> values = new ArrayList<>();
            for (String value : sepByComma) {
                System.out.println(value);

                value = value.replaceAll("\\{", "").replaceAll("}", "").replaceAll("\"", "");
                String target = value.substring(value.indexOf(":") + 1);
                System.out.println(target);
                values.add(target);

            }

            String username = values.get(0);
            String first_name = values.get(1);
            String last_name = values.get(2);
            String user_password = values.get(3);
            String email = values.get(4);
            String zodiac = values.get(5);

            User user = new User(username, user_password, first_name, last_name, email, zodiac);

            Integer pk = userDAO.create(user);

            if (user != null) {
                resp.setStatus(200);
                //get an HTTP Session
                HttpSession session = req.getSession();
                session.setAttribute("user", user);

                PrintWriter out = resp.getWriter();
                resp.setContentType("application/json");
                resp.addHeader("Access-Control-Allow-Origin", "*");

                ObjectMapper om = new ObjectMapper();

                // convert the object with the mapper

                out.println(om.writeValueAsString(user));
                System.out.println("The user with :" + email + " has logged in");

            } else {
                resp.setStatus(204);

            }





        }
    }




