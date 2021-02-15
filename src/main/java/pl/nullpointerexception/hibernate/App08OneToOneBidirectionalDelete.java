package pl.nullpointerexception.hibernate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.nullpointerexception.hibernate.entity.Category;
import pl.nullpointerexception.hibernate.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class App08OneToOneBidirectionalDelete {
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");
    private static Logger logger = LogManager.getLogger(App08OneToOneBidirectionalDelete.class);
    public static void main(String[] args) {
       EntityManager entityManager = entityManagerFactory.createEntityManager();
       entityManager.getTransaction().begin();
        List<Product> resultList = entityManager.createQuery("select p from Product p ").getResultList();
        for (Product product : resultList) {
            if(product.getCategory().getId() ==1){
                entityManager.remove(product);
            }
        }

        entityManager.getTransaction().commit();
     entityManager.close();
        }
    }
