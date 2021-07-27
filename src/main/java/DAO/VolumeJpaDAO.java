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
import modelo.Volume;

public class VolumeJpaDAO {

       private static VolumeJpaDAO instance;
       protected EntityManager entityManager;

       public static VolumeJpaDAO getInstance(){
         if (instance == null){
            instance = new VolumeJpaDAO();
         }

         return instance;
       }

        private VolumeJpaDAO() {
            entityManager = getEntityManager();
        }

       private EntityManager getEntityManager() {
           
           entityManager = EntityManagerSingleton.getInstance();

           return entityManager;
       }

       public Volume getById(final int id) {
         return entityManager.find(Volume.class, id);
       }

       @SuppressWarnings("unchecked")
       public List<Volume> findAll() {
         return entityManager.createQuery("FROM " +
         Volume.class.getName()).getResultList();
       }

       public void persist(Volume volume) {
         try {
            entityManager.getTransaction().begin();
            entityManager.persist(volume);
            entityManager.getTransaction().commit();
         } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
         }
       }

       public void merge(Volume volume) {
         try {
            entityManager.getTransaction().begin();
            entityManager.merge(volume);
            entityManager.getTransaction().commit();
         } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
         }
       }

       public void remove(Volume volume) {
         try {
            entityManager.getTransaction().begin();
            volume = entityManager.find(Volume.class, volume.getId());
            entityManager.remove(volume);
            entityManager.getTransaction().commit();
         } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
         }
       }

       public void removeById(final int id) {
         try {
            Volume volume = getById(id);
            remove(volume);
         } catch (Exception ex) {
            ex.printStackTrace();
         }
       }

}
