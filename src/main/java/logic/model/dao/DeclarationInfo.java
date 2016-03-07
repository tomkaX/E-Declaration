package logic.model.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by Spayker on 2/22/2016.
 */
@Entity
public class DeclarationInfo {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long Id;

    // an array of data from declaration will be keep here
    private Map<LinkedList<String>, String> fieldsStorage = new LinkedHashMap();

    public Map<LinkedList<String>, String> getFieldsStorage() {
        return fieldsStorage;
    }

    public void setFieldsStorage(Map<LinkedList<String>, String> fieldsStorage) {
        this.fieldsStorage = fieldsStorage;
    }
}
