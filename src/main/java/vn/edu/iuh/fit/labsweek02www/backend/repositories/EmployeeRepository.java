package vn.edu.iuh.fit.labsweek02www.backend.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import vn.edu.iuh.fit.labsweek02www.backend.entities.Employee;
import vn.edu.iuh.fit.labsweek02www.backend.enums.EmployeeStatus;

import java.util.List;
import java.util.Optional;

public class EmployeeRepository {
    private EntityManager em;
    public EmployeeRepository(){
        em = Persistence.createEntityManagerFactory("labs-week-02-www").createEntityManager();
    }
    public void insertEmp(Employee employee){
        em.persist(employee);
    }

    public void setStatus(Employee employee, EmployeeStatus status) {
        employee.setStatus(status);
    }

    public void updateEmp(Employee employee){
        em.merge(employee);
    }

    public List<Employee> getAllEmp(){
        return em.createQuery("select e from Employee e where e.status=1", Employee.class).getResultList();
    }

    public Optional<Employee> findById(long id){
        TypedQuery<Employee> query = em.createQuery("select e from Employee e where e.id=:id", Employee.class);
        query.setParameter("id", id);
        Employee emp = query.getSingleResult();
        return emp == null ? Optional.empty() : Optional.of(emp);
    }
}
