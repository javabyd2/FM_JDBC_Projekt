package com.sda.projekt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {


        System.out.println("Wybierz opcje: \n" + "1.Dodaj\n" + "2.Wyświetl\n" + "3.Edytuj\n");

        Scanner sc = new Scanner(System.in);
        int menuChoice = sc.nextInt();

        Connection connection = DBconnector.getConnection();

        Statement statement;
        statement = connection.createStatement();
        switch (menuChoice) {
            case 1:          //add

                String insert = "insert into customer (first_name,last_name,address, postal_code,email) values (?,?,?,?,?)";
                PreparedStatement preparedStatement = connection.prepareStatement(insert);

                System.out.println("Podaj imie");
                preparedStatement.setString(1, sc.next());
                System.out.println("Podaj nazwisko");
                preparedStatement.setString(2, sc.next());
                System.out.println("Podaj adres");
                preparedStatement.setString(3, sc.next());
                System.out.println("Podaj kod pocztowy");
                preparedStatement.setString(4, sc.next());
                System.out.println("Podaj email");
                preparedStatement.setString(5, sc.next());

                preparedStatement.executeUpdate();


                break;

            case 2:

                String select = "SELECT * FROM CUSTOMER";
                ResultSet resultSet = statement.executeQuery(select);

                while (resultSet.next()) {

                    System.out.println(resultSet.getString("cust_id") + "| " + resultSet.getString("first_name") + "| " + resultSet.getString("last_name") + "| " + resultSet.getString("address") + "| " + resultSet.getString("postal_code") + "| " + resultSet.getString("email"));

                }
                break;

            case 3:

                System.out.println("Co chcesz wyedytowac:\n  1.Imie\n  2.Nazwisko\n  3.Adres\n  4.Kod pocztowy\n  5.Email");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:

                        System.out.println("Podaj imie do zmiany:");
                        String oldName = sc.next();
                        System.out.println("Podaj na jakie imie zmienić:");
                        String newName = sc.next();

                        String update = "update customer set first_name = '"+newName+"' where first_name ='"+oldName+"';";

                        statement.executeUpdate(update);


                        break;

                    case 2:

                        System.out.println("Podaj nazwisko do zmiany:");
                        String oldLastName = sc.next();
                        System.out.println("Podaj na jakie nazwisko zmienić:");
                        String newLastName = sc.next();

                        String updateLN = "update customer set last_name = '"+newLastName+"' where last_name ='"+oldLastName+"';";

                        statement.executeUpdate(updateLN);

                        break;

                    case 3:

                        System.out.println("Podaj adres do zmiany:");
                        String oldAdress = sc.next();
                        System.out.println("Podaj na jaki adres zmienić:");
                        String newAdress = sc.next();

                        String updateAd = "update customer set address = '"+newAdress+"' where address ='"+oldAdress+"';";

                        statement.executeUpdate(updateAd);

                        break;

                    case 4:
                        System.out.println("Podaj kod pocztowy do zmiany:");
                        String oldZIP = sc.next();
                        System.out.println("Podaj na jaki kod zmienić:");
                        String newZIP = sc.next();

                        String updateZIP = "update customer set postal_code = '"+newZIP+"' where postal_code ='"+oldZIP+"';";

                        statement.executeUpdate(updateZIP);

                        break;

                    case 5:

                        System.out.println("Podaj email do zmiany:");
                        String oldEmail = sc.next();
                        System.out.println("Podaj na jaki emmail zmienić:");
                        String newEmail = sc.next();

                        String updateEmail = "update customer set email = '"+newEmail+"' where email ='"+oldEmail+"';";

                        statement.executeUpdate(updateEmail);

                        break;

                    default:
                        System.out.println("Wybierz 1-5");
                }


                ;
                break;

            default:
                System.out.println("Wybierz 1, 2 lub 3.");

        }
    }
}


