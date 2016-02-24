package logic.model.dao;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Spayker on 2/24/2016.
 */
@Entity
@Table(name = "official")
public class Official extends User{

    @OneToMany(cascade = CascadeType.ALL)
    private List<Declaration> declarations = new ArrayList<Declaration>();

    private Official() {
        super();
    }

    private Official(String newLogin, String newPassword, String newFirstName, String newLastName, Roles newRole) {
        super(newLogin, newPassword, newFirstName, newLastName, newRole);
    }

    public List<Declaration> getDeclarations() {
        return declarations;
    }

    public void setDeclarations(List<Declaration> declarations) {
        this.declarations = declarations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Official official = (Official) o;

        return !(getDeclarations() != null ? !getDeclarations().equals(official.getDeclarations()) : official.getDeclarations() != null);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getDeclarations() != null ? getDeclarations().hashCode() : 0);
        return result;
    }

}
