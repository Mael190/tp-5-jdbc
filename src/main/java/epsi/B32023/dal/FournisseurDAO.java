package epsi.B32023.dal;

import epsi.B32023.bo.Fournisseur;

import java.util.List;
import java.sql.SQLException;

public interface FournisseurDAO {
    int add(Fournisseur fournisseur) throws SQLException;
    List<Fournisseur> findAll() throws SQLException;

    void update(Fournisseur oldFournisseur, Fournisseur newFournisseur) throws SQLException;

    void deleteById(int fournisseurId) throws SQLException;
}
