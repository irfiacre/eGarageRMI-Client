package model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author busyDev
 */
public class Cars implements Serializable {

    private Integer id;
    private String model;
    private String brand;
    private String makeYear;
    private String faultDescription;
    private CarFixStatus status;
    private Users users;
    private Set<Mechanic> Mechanic = new HashSet<>();
    private Set<Staff> Staff = new HashSet<>();

    public Cars() {
    }

    public Cars(Integer id) {
        this.id = id;
    }

    public Cars(Integer id, String model, String brand, String makeYear, String faultDescription, CarFixStatus status, Users users) {
        this.id = id;
        this.model = model;
        this.brand = brand;
        this.makeYear = makeYear;
        this.faultDescription = faultDescription;
        this.status = status;
        this.users = users;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMakeYear() {
        return makeYear;
    }

    public void setMakeYear(String makeYear) {
        this.makeYear = makeYear;
    }

    public String getFaultDescription() {
        return faultDescription;
    }

    public void setFaultDescription(String faultDescription) {
        this.faultDescription = faultDescription;
    }

    public CarFixStatus getStatus() {
        return status;
    }

    public void setStatus(CarFixStatus status) {
        this.status = status;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Set<Mechanic> getMechanic() {
        return Mechanic;
    }

    public void setMechanic(Set<Mechanic> Mechanic) {
        this.Mechanic = Mechanic;
    }

    public Set<Staff> getStaff() {
        return Staff;
    }

    public void setStaff(Set<Staff> Staff) {
        this.Staff = Staff;
    }

}
