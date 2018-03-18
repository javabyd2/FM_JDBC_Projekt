package com.sda.projekt;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBconnector {

        private static Connection connection = null;

        private final static String ADDRESS = "jdbc:mysql://127.0.0.1";
        private final static String DATABASE = "rental_db";
        private final static String USER = "root";
        private final static String PASSWORD = "Kona911!";
        private final static String PORT = "3306";
        private final static String DRIVER = "com.mysql.cj.jdbc.Driver";
        private final static String PARAMS = "useSSL=false&serverTimezone=UTC";


        private static void loadDriver() {

            try {
                Class.forName(DRIVER);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private static void loadConnection() {

            try {
                connection = DriverManager.getConnection(getFormattedURL(), USER, PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        private static String getFormattedURL() {

            return ADDRESS + ":" + PORT + "/" + DATABASE + "?" + PARAMS;
        }

        public static Connection getConnection(){
            if (connection==null){
                loadDriver();
                loadConnection();
            }
            return connection;
        }

        public static void closeConnection (){

            if (connection==null){

                System.out.println("nie ma co zamykać");
            }else {
                try {
                    connection.close();
                    connection=null;
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }

