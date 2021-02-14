package pl.nullpointerexception.hibernate;

import pl.nullpointerexception.hibernate.entity.Product;
import pl.nullpointerexception.hibernate.entity.ProductType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class App01Create {
private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");
    private static Logger logger = LogManager.getLogger(App01Create.class);

public static void main(String[] args) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        logger.info("Siemanko, stwórzmy product");
    Product product = new Product();
    product.setCreated(LocalDateTime.now());
    product.setUpdated(LocalDateTime.now());
    product.setDescription("miejski");
    product.setName("Rower");
    product.setPrice(new BigDecimal(690.99));
    product.setProductType(ProductType.REAL);
    entityManager.persist(product);
    logger.info("Stworzono produkt:/n " +product);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
