package epsi.B32023.test;

import epsi.B32023.bo.Article;
import epsi.B32023.bo.Fournisseur;
import epsi.B32023.dal.ArticleJDBCDAO;
import epsi.B32023.dal.FournisseurJDBCDAO;

import java.sql.SQLException;
import java.util.Objects;

import static java.lang.Math.round;

public class TestJdbcArticles {
    private final FournisseurJDBCDAO fournisseurJDBCDAO;
    private final ArticleJDBCDAO articleJDBCDAO;

    public TestJdbcArticles(FournisseurJDBCDAO fournisseurJDBCDAO, ArticleJDBCDAO articleJDBCDAO) {
        this.fournisseurJDBCDAO = fournisseurJDBCDAO;
        this.articleJDBCDAO = articleJDBCDAO;
    }

    public void insert() throws SQLException {
        Fournisseur fournisseur = new Fournisseur("La Maison de la Peinture");
        int idFournisseur = this.fournisseurJDBCDAO.add(fournisseur);
        fournisseur.setId(idFournisseur);

        Article article1 = new Article("Peinture blanche 1L", 12.50, fournisseur);
        Article article2 = new Article("Peinture rouge mate 1L", 15.50, fournisseur);
        Article article3 = new Article("Peinture noire laquée 1L", 17.80, fournisseur);
        Article article4 = new Article("Peinture bleue mate 1L", 15.50, fournisseur);

        this.articleJDBCDAO.insert(article1);
        this.articleJDBCDAO.insert(article2);
        this.articleJDBCDAO.insert(article3);
        this.articleJDBCDAO.insert(article4);

        for (Article temp : this.articleJDBCDAO.findAll()) {
            this.articleJDBCDAO.update(temp , new Article(temp.getnom(), (double) round(temp.getprix()*0.75 * 100) /100, temp.getFournisseur()));
        }

        for (Article temp : this.articleJDBCDAO.findAll()) {
            System.out.printf("%s; %f; %s%n", temp.getnom(), temp.getprix(), temp.getFournisseur().getNom());
        }

        System.out.println("Le prix moyen est de " + round(this.articleJDBCDAO.getMoyenne() * 100) / 100);

        for (Article article : this.articleJDBCDAO.findAll()) {
            if(article.getnom().contains("Peinture")){
                articleJDBCDAO.delete(article.getId());
            }
        }
        for (Fournisseur fournisseurTemp : this.fournisseurJDBCDAO.findAll()) {
            if(Objects.equals(fournisseurTemp.getNom(), "La Maison de la Peinture")){
                fournisseurJDBCDAO.deleteById(fournisseurTemp.getId());
            }
        }

    }
}


