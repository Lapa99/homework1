package com.example.springboot.repository;

import com.example.springboot.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ProductDao {
    private static SessionFactory factory;
    private final static List<Product> products = new CopyOnWriteArrayList<>();

    public static void init() {
        factory = new Configuration()
                .addAnnotatedClass(Product.class)
                .configure("config/hibernate.cfg.xml")
                .buildSessionFactory();
    }
    public static void add() {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Product rose = new Product(0L, "Роза",95);
            session.save(rose);
            Product lily = new Product(1L, "Лилия",450);
            session.save(lily);
            Product tulip = new Product(2L, "Тюльпан",70);
            session.save(tulip);
            session.getTransaction().commit();
        }
    }

    public static Product findById(Long id) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Product current = session.find(Product.class, id);
            session.getTransaction().commit();
            return current;
        }
    }

    public static List<Product> findAll() {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            List<Product> allProducts = session.createQuery("from Product")
                    .getResultList();
            session.getTransaction().commit();
            return allProducts;
        }
    }

    public static void deleteById(Long id) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Product current = session.get(Product.class, id);
            session.delete(current);
            session.getTransaction().commit();
        }
    }

    public static Product saveOrUpdate(Product product) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            session.saveOrUpdate(product);
            session.getTransaction().commit();
            return product;
        }
    }

    public static void shutdown() {
        factory.close();
    }
}