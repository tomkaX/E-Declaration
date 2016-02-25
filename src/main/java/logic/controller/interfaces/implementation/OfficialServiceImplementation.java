package logic.controller.interfaces.implementation;

import logic.controller.interfaces.IOfficialService;
import logic.model.dao.CommonEntity;
import logic.model.dao.Official;

/**
 * Created by Spayker on 2/25/2016.
 */
public class OfficialServiceImplementation extends CommonEntityServiceImplementation<Official> implements
        IOfficialService {


    /**
     * Constructor with fields
     *
     * @param persistentClass Class that this dao will work with
     */
    public OfficialServiceImplementation(Class<Official> persistentClass) {
        super(persistentClass);
    }

    @Override
    protected void beforeEntityAddUpdate(Official entity) throws Exception {

    }

    @Override
    protected void beforeEntityDelete(Official entity) throws Exception {

    }

}
