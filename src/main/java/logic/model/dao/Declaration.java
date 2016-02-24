package logic.model.dao;

import javax.persistence.*;
import java.util.Calendar;

/**
 * Created by Spayker on 2/21/2016.
 */

@Entity
@Table(name = "declaration")
public class Declaration extends CommonEntity{

    @Column(name = "version")
    private String version;

    @Column(name = "recievedDate")
    private Calendar recievedDate;

    @Column(name = "creatorLogin")
    private String creatorLogin;

    @OneToOne(cascade = CascadeType.ALL)
    private DeclarationInfo declarationInfo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Declaration that = (Declaration) o;

        if (!version.equals(that.version)) return false;
        if (!recievedDate.equals(that.recievedDate)) return false;
        if (!creatorLogin.equals(that.creatorLogin)) return false;
        return declarationInfo.equals(that.declarationInfo);

    }

    @Override
    public int hashCode() {
        int result = version.hashCode();
        result = 31 * result + recievedDate.hashCode();
        result = 31 * result + creatorLogin.hashCode();
        result = 31 * result + declarationInfo.hashCode();
        return result;
    }
}
