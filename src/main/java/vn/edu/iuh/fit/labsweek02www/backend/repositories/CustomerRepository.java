package vn.edu.iuh.fit.labsweek02www.backend.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import vn.edu.iuh.fit.labsweek02www.backend.entities.Customer;

import java.util.List;

public class CustomerRepository {
    private EntityManager em;
    private EntityTransaction trans;
    public CustomerRepository() {
        em = Persistence.createEntityManagerFactory("labs-week-02-www").createEntityManager();
        trans = em.getTransaction();
    }

    public void insertCustomer(Customer cust){
        try {
            trans.begin();
            em.persist(cust);
            trans.commit();
        }catch (Exception ex){
            trans.rollback();
        }
    }
    public void deleteCustomer(long cust_id){
        try {
            trans.begin();
            em.remove(em.find(Customer.class,cust_id));
            trans.commit();
        }catch (Exception ex){
            trans.rollback();
        }
    }
    public List<Customer> getAllCust(){
        return em.createNamedQuery("Customer.findAll", Customer.class).getResultList();
    }
}
