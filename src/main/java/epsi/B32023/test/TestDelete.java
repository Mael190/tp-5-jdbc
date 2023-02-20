package epsi.B32023.test;

import epsi.B32023.bo.Fournisseur;
import epsi.B32023.dal.FournisseurJDBCDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteInsertion {
    private FournisseurJDBCDAO fournisseurJDBCDAO;
    public TestInsertion() {
        this.fournisseurJDBCDAO = new FournisseurJDBCDAO();
    }
    public void Insert(Fournisseur fournisseur) throws SQLException {
        this.fournisseurJDBCDAO.add(fournisseur);
    }
}
