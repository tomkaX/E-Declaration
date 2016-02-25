package logic.model.dao;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by Spayker on 2/22/2016.
 */
@Entity
@Table(name = "declarationInfo")
public class DeclarationInfo extends CommonEntity {

    // an array of data from declaration will be keep here
    @Column
    @ElementCollection
    private Map<LinkedList<String>, String> fieldsStorage = new LinkedHashMap();

    public Map<LinkedList<String>, String> getFieldsStorage() {
        return fieldsStorage;
    }

    public void setFieldsStorage(Map<LinkedList<String>, String> fieldsStorage) {
        this.fieldsStorage = fieldsStorage;
    }
}
