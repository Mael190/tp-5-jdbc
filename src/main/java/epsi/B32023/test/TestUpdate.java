package epsi.B32023.test;

import epsi.B32023.bo.Fournisseur;
import epsi.B32023.dal.FournisseurJDBCDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestUpdate {
    private FournisseurJDBCDAO fournisseurJDBCDAO;
    public TestUpdate() {
        this.fournisseurJDBCDAO = new FournisseurJDBCDAO();
    }
    public void Update(Fournisseur oldFournisseur, Fournisseur newFournisseur) throws SQLException {
        this.fournisseurJDBCDAO.update(oldFournisseur, newFournisseur);
    }
}
