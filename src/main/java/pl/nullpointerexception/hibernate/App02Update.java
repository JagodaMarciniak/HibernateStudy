package pl.nullpointerexception.hibernate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.nullpointerexception.hibernate.entity.Product;
import pl.nullpointerexception.hibernate.entity.ProductType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class App02Update {
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");
    private static Logger logger = LogManager.getLogger(App01Create.class);

    public static void main(String[] args) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
//
//        Product product = entityManager.find(Product.class, 1L);
//        product.setName("owyRower");
        Product product = new Product();
        product.setId(1L);
        product.setName("NowyRower02");
        Product mergedProduct = entityManager.merge(product);
        logger.info(mergedProduct);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
