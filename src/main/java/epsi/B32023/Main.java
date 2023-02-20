package epsi.B32023;

import java.sql.*;
import java.util.ResourceBundle;

public class Main {
    private static final String DB_URL;
    private static final String DB_LOGIN;
    private static final String DB_PWD;

    static {
        System.out.println("Chargement de la classe");
        ResourceBundle bundle = ResourceBundle.getBundle("db");
        DB_URL = bundle.getString("db.url");
        DB_LOGIN = bundle.getString("db.login");
        DB_PWD= bundle.getString("db.password");
    }
    public static void main(String[] args) {
        try (Connection cnx = DriverManager.getConnection(DB_URL, DB_LOGIN, DB_PWD);
             Statement st = cnx.createStatement();) {



            try (ResultSet rs = st.executeQuery("SELECT * FROM compta.FOURNISSEUR")) {
                while (rs .next()) {
                    System.out.printf("id = %d - nom ou alors %d - nom = %s %n",
                            rs.getInt(1),
                            rs.getInt("ID"),
                            rs.getString("NOM"));
                }
            }
            TestInsertion test1 = new TestInsertion(cnx, st);
            test1.Insert("La Maison de la Peinture");


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Hello world! 👉");
    }
}