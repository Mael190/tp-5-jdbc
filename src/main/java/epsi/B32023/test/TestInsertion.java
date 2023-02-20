package epsi.B32023;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestInsertion {
    TestInsertion(Connection cnx, Statement st) {
        this.cnx = cnx;
        this.st = st;
    }
    public void Insert(String nom) throws SQLException {
        st.executeUpdate("INSERT INTO compta.FOURNISSEUR (NOM) VALUES ('La Maison de la Peinture')");
    }
}
