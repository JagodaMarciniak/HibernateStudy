package pl.nullpointerexception.hibernate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.nullpointerexception.hibernate.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App07OneToOne {
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");
    private static Logger logger = LogManager.getLogger(App07OneToOne.class);
    public static void main(String[] args) {
       EntityManager entityManager = entityManagerFactory.createEntityManager();
       entityManager.getTransaction().begin();
        Product productWithOpinion = entityManager.find(Product.class, 1L);
        entityManager.remove(productWithOpinion);
     entityManager.getTransaction().commit();
     entityManager.close();
        }

    }
