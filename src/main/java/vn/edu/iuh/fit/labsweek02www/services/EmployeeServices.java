package vn.edu.iuh.fit.labsweek02www.services;

import vn.edu.iuh.fit.labsweek02www.entities.Employee;
import vn.edu.iuh.fit.labsweek02www.enums.EmployeeStatus;
import vn.edu.iuh.fit.labsweek02www.repositories.EmployeeRepository;

import java.util.List;
import java.util.Optional;

public class EmployeeServices {
    private EmployeeRepository rep;
    public  EmployeeServices(){
        rep = new EmployeeRepository();
    }
    public void insertEmp(Employee employee){
        rep.insertEmp(employee);
    }
    public Optional<Employee> findById(long id){
        return  rep.findById(id);
    }

    public boolean deleteEmp(long id){
        Optional<Employee> op = findById(id);
        if(op.isPresent()){
            Employee employee = op.get();
            employee.setStatus(EmployeeStatus.TERMINATED);
            return true;
        }
        return false;
    }
    public boolean activeEmp(long id) {
        Optional<Employee> op = findById(id);
        if (op.isPresent()) {
            Employee employee = op.get();
            employee.setStatus(EmployeeStatus.ACTIVE);
            return true;
        }
        return false;
    }

    public List<Employee> getAll(){
        return rep.getAllEmp();
    }
}
