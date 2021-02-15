package pl.nullpointerexception.hibernate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.nullpointerexception.hibernate.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class App05OneToMany {
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");
    private static Logger logger = LogManager.getLogger(App05OneToMany.class);
    public static void main(String[] args) {
       EntityManager entityManager = entityManagerFactory.createEntityManager();
       entityManager.getTransaction().begin();
        List<Product> productList = entityManager.createQuery("select p from Product p").getResultList();
        //jak zaczne wpisywac"iter" to automatycznaiteracja po liście
        for (Product product : productList) {
            logger.info(product.getName());
            logger.info(product.getReviewList());
        }

    }
}
