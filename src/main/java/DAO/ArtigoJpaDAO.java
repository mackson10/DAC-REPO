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
import modelo.Artigo;

public class ArtigoJpaDAO {

       private static ArtigoJpaDAO instance;
       protected EntityManager entityManager;

       public static ArtigoJpaDAO getInstance(){
         if (instance == null){
            instance = new ArtigoJpaDAO();
         }

         return instance;
       }

       private ArtigoJpaDAO() {
           entityManager = getEntityManager();
       }

       private EntityManager getEntityManager() {
           
           entityManager = EntityManagerSingleton.getInstance();

           return entityManager;
       }

       public Artigo getById(final int id) {
         return entityManager.find(Artigo.class, id);
       }

       @SuppressWarnings("unchecked")
       public List<Artigo> findAll() {
         return entityManager.createQuery("FROM " +
         Artigo.class.getName()).getResultList();
       }

       public void persist(Artigo artigo) {
         try {
            entityManager.getTransaction().begin();
            entityManager.persist(artigo);
            entityManager.getTransaction().commit();
         } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
         }
       }

       public void merge(Artigo artigo) {
         try {
            entityManager.getTransaction().begin();
            entityManager.merge(artigo);
            entityManager.getTransaction().commit();
         } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
         }
       }

       public void remove(Artigo artigo) {
         try {
            entityManager.getTransaction().begin();
            artigo = entityManager.find(Artigo.class, artigo.getId());
            entityManager.remove(artigo);
            entityManager.getTransaction().commit();
         } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
         }
       }

       public void removeById(final int id) {
         try {
            Artigo artigo = getById(id);
            remove(artigo);
         } catch (Exception ex) {
            ex.printStackTrace();
         }
       }

}
