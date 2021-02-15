package pl.nullpointerexception.hibernate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.nullpointerexception.hibernate.entity.Product;
import pl.nullpointerexception.hibernate.entity.Review;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class App06OneToManyBidirectional {
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");
    private static Logger logger = LogManager.getLogger(App06OneToManyBidirectional.class);
    public static void main(String[] args) {
       EntityManager entityManager = entityManagerFactory.createEntityManager();
       entityManager.getTransaction().begin();
        List<Review> productList = entityManager.createQuery("select r from Review r").getResultList();
        //jak zaczne wpisywac"iter" to automatycznaiteracja po liście
        for (Review review : productList) {
            logger.info(review);
            logger.info(review.getProduct());
        }

    }
}
