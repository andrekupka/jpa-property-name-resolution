package de.andrekupka.demo.propertyresolution;

import javax.persistence.*;

@Entity
@Table(name="customer")
public class Customer {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "c_login_id", nullable = false)
    private String cLoginId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getcLoginId() {
        return cLoginId;
    }

    public void setcLoginId(String cLoginId) {
        this.cLoginId = cLoginId;
    }
}
