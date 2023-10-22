package vn.edu.iuh.fit.labsweek02www.backend.repositories;

import jakarta.persistence.*;
import vn.edu.iuh.fit.labsweek02www.backend.entities.Employee;
import vn.edu.iuh.fit.labsweek02www.backend.enums.EmployeeStatus;

import java.util.List;
import java.util.Optional;

public class EmployeeRepository {
    private EntityManager em;
    private EntityTransaction trans;
    public EmployeeRepository(){
        em = Persistence.createEntityManagerFactory("labs-week-02-www").createEntityManager();
        trans = em.getTransaction();
    }
    public void insertEmp(Employee employee){
        try {
            trans.begin();
            em.persist(employee);
            trans.commit();
        }catch (Exception e){
            trans.rollback();
        }
    }

    public void setStatus(Employee employee, EmployeeStatus status) {
        employee.setStatus(status);
    }

    public void updateEmp(Employee employee){
        em.merge(employee);
    }

    public List<Employee> getAllEmp(){
        return em.createQuery("select e from Employee e ", Employee.class)
                .getResultList();
    }

    public Optional<Employee> findById(long id){
        TypedQuery<Employee> query = em.createQuery("select e from Employee e where e.id=:id", Employee.class);
        query.setParameter("id", id);
        Employee emp = query.getSingleResult();
        return emp == null ? Optional.empty() : Optional.of(emp);
    }
}
