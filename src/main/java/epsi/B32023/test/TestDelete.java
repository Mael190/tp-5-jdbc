package epsi.B32023.test;

import epsi.B32023.bo.Fournisseur;
import epsi.B32023.dal.FournisseurJDBCDAO;

import java.sql.SQLException;

public class TestDelete {
    private FournisseurJDBCDAO fournisseurJDBCDAO;
    public TestDelete() {
        this.fournisseurJDBCDAO = new FournisseurJDBCDAO();
    }
    public void Delete(int fournisseurId) throws SQLException {
        this.fournisseurJDBCDAO.deleteById(fournisseurId);
    }
}
