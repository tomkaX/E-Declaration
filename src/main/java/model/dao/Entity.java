package main.java.model.dao;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Locale;

/**
 * Created by Spayker on 2/22/2016.
 */

@MappedSuperclass
public abstract class Entity implements Serializable {

    /**
     * Default serial version id
     */
    private static final long serialVersionUID = 1L;

    /**
     * Unique identifier.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlTransient
    private Long id = null;

    /**
     * Default locale to use
     */
    @Transient
    private Locale defLocale = new Locale("en", "EN");

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    @SuppressWarnings("UnusedDeclaration")
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the defLocale
     */
    @SuppressWarnings("UnusedDeclaration")
    private Locale getDefLocale() {
        return defLocale;
    }

    /**
     * @param defLocale the defLocale to set
     */
    @SuppressWarnings("UnusedDeclaration")
    public void setDefLocale(Locale defLocale) {
        this.defLocale = defLocale;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Entity other = (Entity) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        return true;
    }


    public void createEntity(){

    }

    public void updateEntity(Entity entity){

    }

    public Entity getEntityById(int id){
        return null;
    }

}
