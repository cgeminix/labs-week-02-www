package vn.edu.iuh.fit.labsweek02www.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import vn.edu.iuh.fit.labsweek02www.entities.Product;
import vn.edu.iuh.fit.labsweek02www.enums.ProductStatus;

import java.util.List;
import java.util.Optional;

public class ProductRepository {
    private EntityManager em;

    public ProductRepository(){
        em = Persistence.createEntityManagerFactory("labs-week-02-www").createEntityManager();
    }

     public void insertPro(Product product){
        em.persist(product);
     }
     public void setStatus(Product product, ProductStatus status){
        product.setStatus(status);
     }

     public void updatePro(Product product){
        em.merge(product);
     }

     public List<Product> getAllPro(){
        return em.createQuery("select p from Product p where p.status=1", Product.class).getResultList();
     }

     public Optional<Product> findById(long id){
         TypedQuery<Product> query = em.createQuery("select p from Product p where p.product_id = :id", Product.class);
         query.setParameter("id",id);
         Product pro = query.getSingleResult();
         return pro == null ? Optional.empty() : Optional.of(pro);
     }
}
