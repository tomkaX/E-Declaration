package logic.model.dao;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Spayker on 2/21/2016.
 */

@Entity
@Table(name = "user")
public class User extends CommonEntity{

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "role")
    private Roles role;

    protected User() {}

    protected User(String newLogin, String newPassword, String newFirstName, String newLastName, Roles newRole) {
        login = newLogin;
        password = newPassword;
        firstName = newFirstName;
        lastName = newLastName;
        role = newRole;
    }


    public static User createUser() {
        return new User();
    }

    public static User createUser(String newLogin, String newPassword, String newFirstName, String newLastName, Roles newRole) {
        return new User(newLogin, newPassword, newFirstName, newLastName, newRole);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        User user = (User) o;

        if (!getLogin().equals(user.getLogin())) return false;
        if (!getPassword().equals(user.getPassword())) return false;
        if (!getFirstName().equals(user.getFirstName())) return false;
        if (!getLastName().equals(user.getLastName())) return false;
        return getRole() == user.getRole();

    }

    @Override
    public int hashCode() {
        int result = getLogin().hashCode();
        result = 31 * result + getPassword().hashCode();
        result = 31 * result + getFirstName().hashCode();
        result = 31 * result + getLastName().hashCode();
        result = 31 * result + getRole().hashCode();
        return result;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }
}
