
package model;

import java.io.Serializable;
import java.util.Set;

/**
 *
 * @author busyDev
 */
public class Mechanic implements Serializable {

    private Integer id;
    private String username;
    private String password;
    private String specialization;
    private EUserRole role;
    private Users users;
    private Set<Cars> cars;

    public Mechanic() {
    }

    public Mechanic(Integer id) {
        this.id = id;
    }

    public Mechanic(Integer id, String username, String password, String specialization, EUserRole role, Users users, Set<Cars> cars) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.specialization = specialization;
        this.role = role;
        this.users = users;
        this.cars = cars;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public EUserRole getRole() {
        return role;
    }

    public void setRole(EUserRole role) {
        this.role = role;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Set<Cars> getCars() {
        return cars;
    }

    public void setCars(Set<Cars> cars) {
        this.cars = cars;
    }

}
