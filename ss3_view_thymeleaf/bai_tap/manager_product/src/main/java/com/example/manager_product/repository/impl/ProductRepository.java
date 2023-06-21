package com.example.manager_product.repository.impl;

import com.example.manager_product.model.Product;
import com.example.manager_product.repository.ConnectionUtils;
import com.example.manager_product.repository.IProductRepository;;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;


@Repository
public class ProductRepository implements IProductRepository {
   private final static String SELECT_ALL_PRODUCTS_QUERY ="FROM Product";
    @Override
    public List<Product> getAll() {
    return ConnectionUtils.getEntityManager().createQuery(SELECT_ALL_PRODUCTS_QUERY).getResultList();
    }

    @Override
    public void save(Product product) {
        Session session = null;
        Transaction transactional = null;
        try {
            session = ConnectionUtils.getSessionFactory().openSession();
            transactional = session.beginTransaction();
            session.save(product);
            transactional.commit();
        }catch (Exception ex){
            ex.printStackTrace();
            if (transactional!=null){
                transactional.rollback();
            }
        }finally {
            if (session!=null){
                session.close();
            }
        }


    }
//
    @Override
    public Product findById(int id) {
        try {
            return (Product) ConnectionUtils.getEntityManager().createQuery("select p from Product as p where p.id =:id").setParameter("id", id).getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void update(int id, Product product) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = ConnectionUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Product product1 = findById(product.getId());
            product1.setName(product.getName());
            product1.setPrice(product.getPrice());
            product1.setDescribe(product.getDescribe());
            product1.setProducer(product.getProducer());
            session.saveOrUpdate(product1);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void delete(int id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = ConnectionUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.delete(findById(id));
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    @Override
    public List<Product> findByName(String name) {
        String SEARCH_PRODUCT = "select p from Product as p where p.name like '%" + name + "%'";
        return ConnectionUtils.getEntityManager().createQuery(SEARCH_PRODUCT).getResultList();
    }
}