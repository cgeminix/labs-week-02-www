package vn.edu.iuh.fit.labsweek02www.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_id")
    private long id;
    @Column(name = "cust_name", length = 150, nullable = false)
    private String custName;
    @Column(name = "email",unique = true ,length = 150)
    private String email;
    @Column(name = "phone",length = 15, nullable = false)
    private String phone;
    @Column(name = "address",length = 250,nullable = false)
    private String address;

    @OneToMany(mappedBy = "customer")
    private List<Order> lsOrder;

    public Customer(long id, String custName, String email, String phone, String address, List<Order> lsOrder) {
        this.id = id;
        this.custName = custName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.lsOrder = lsOrder;
    }

    public Customer() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
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

    public List<Order> getLsOrder() {
        return lsOrder;
    }

    public void setLsOrder(List<Order> lsOrder) {
        this.lsOrder = lsOrder;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", custName='" + custName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", lsOrder=" + lsOrder +
                '}';
    }
}
