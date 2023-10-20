package vn.edu.iuh.fit.labsweek02www.backend.services;

import vn.edu.iuh.fit.labsweek02www.backend.entities.Customer;
import vn.edu.iuh.fit.labsweek02www.backend.repositories.CustomerRepository;

import java.awt.*;
import java.util.List;

public class CustomerService {
    private CustomerRepository rep;
    public CustomerService(){
        rep = new CustomerRepository();
    }
    public void insertCust(Customer cust){
        rep.insertCustomer(cust);
    }

    public List<Customer> getAll(){
        return rep.getAllCust();
    }
}
