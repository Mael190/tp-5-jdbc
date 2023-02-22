package epsi.B32023;

import epsi.B32023.bo.Fournisseur;
import epsi.B32023.dal.ArticleJDBCDAO;
import epsi.B32023.dal.FournisseurJDBCDAO;
import epsi.B32023.test.*;

import java.sql.*;
import java.util.List;
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

    public static void tp1() {
        try (Connection cnx = DriverManager.getConnection(DB_URL, DB_LOGIN, DB_PWD);
             Statement st = cnx.createStatement();) {

            TestInsertion test1 = new TestInsertion();
            test1.Insert(new Fournisseur("La maison de la peinture"));

            TestUpdate test2= new TestUpdate();
            test2.Update(new Fournisseur(1, "La maison de la peinture"), new Fournisseur("La cabane de la peinture"));

            TestFindAll test3 = new TestFindAll();
            List<Fournisseur> listFournisseurs = test3.FindAll();
            System.out.println(listFournisseurs.size());

            TestDelete test4= new TestDelete();
            test4.Delete(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void tp6() {
        try (Connection cnx = DriverManager.getConnection(DB_URL, DB_LOGIN, DB_PWD);
             Statement st = cnx.createStatement();) {

            TestJdbcArticles test = new TestJdbcArticles(new FournisseurJDBCDAO(), new ArticleJDBCDAO());
            test.insert();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public static void main(String[] args) {
        tp1();
        tp6();


    }
}