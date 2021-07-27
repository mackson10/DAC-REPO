/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author Mac
 */
import JPA.EntityManagerSingleton;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Autor;

public class AutorJpaDAO {

       private static AutorJpaDAO instance;
       protected EntityManager entityManager;

       public static AutorJpaDAO getInstance(){
         if (instance == null){
            instance = new AutorJpaDAO();
         }

         return instance;
       }

       private AutorJpaDAO() {
         entityManager = getEntityManager();
       }

       private EntityManager getEntityManager() {
           
           entityManager = EntityManagerSingleton.getInstance();

           return entityManager;
       }


       public Autor getById(final int id) {
         return entityManager.find(Autor.class, id);
       }

       @SuppressWarnings("unchecked")
       public List<Autor> findAll() {
         return entityManager.createQuery("FROM " +
         Autor.class.getName()).getResultList();
       }

       public void persist(Autor autor) {
         try {
            entityManager.getTransaction().begin();
            entityManager.persist(autor);
            entityManager.getTransaction().commit();
         } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
         }
       }

       public void merge(Autor autor) {
         try {
            entityManager.getTransaction().begin();
            entityManager.merge(autor);
            entityManager.getTransaction().commit();
         } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
         }
       }

       public void remove(Autor autor) {
         try {
            entityManager.getTransaction().begin();
            autor = entityManager.find(Autor.class, autor.getId());
            entityManager.remove(autor);
            entityManager.getTransaction().commit();
         } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
         }
       }

       public void removeById(final int id) {
         try {
            Autor autor = getById(id);
            remove(autor);
         } catch (Exception ex) {
            ex.printStackTrace();
         }
       }

}
