package vn.edu.iuh.fit.labsweek02www.backend.entities;

import jakarta.persistence.*;
import vn.edu.iuh.fit.labsweek02www.backend.enums.EmployeeStatus;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private long id;
    @Column(name = "full_name", length = 150, nullable = false)
    private String fullname;
    @Column(name = "dob", nullable = false)
    private LocalDate dob;
    @Column(name = "email", unique = true, length = 150)
    private  String email;
    @Column(name = "phone", length = 150, nullable = false)
    private  String phone;
    @Column(name = "address", length = 250, nullable = false)
    private  String address;
    @Column(name = "status", nullable = false)
    private EmployeeStatus status;

    @OneToMany
    private List<Order> lsOrder;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public EmployeeStatus getStatus() {
        return status;
    }

    public void setStatus(EmployeeStatus status) {
        this.status = status;
    }

    public List<Order> getLsOrder() {
        return lsOrder;
    }

    public void setLsOrder(List<Order> lsOrder) {
        this.lsOrder = lsOrder;
    }

    public Employee() {
    }

    public Employee(String fullname, LocalDate dob, String email, String phone, String address, EmployeeStatus status) {
        this.fullname = fullname;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fullname='" + fullname + '\'' +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", status=" + status +
                ", lsOrder=" + lsOrder +
                '}';
    }
}
