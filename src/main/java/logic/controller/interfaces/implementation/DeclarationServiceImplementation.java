package logic.controller.interfaces.implementation;

import logic.controller.interfaces.IDeclarationService;
import logic.model.dao.CommonEntity;
import logic.model.dao.Declaration;

/**
 * Created by Spayker on 2/25/2016.
 */
public class DeclarationServiceImplementation extends CommonEntityServiceImplementation<Declaration> implements
        IDeclarationService {
    /**
     * Constructor with fields
     *
     * @param persistentClass Class that this dao will work with
     */
    public DeclarationServiceImplementation(Class<Declaration> persistentClass) {
        super(persistentClass);
    }

    @Override
    protected void beforeEntityAddUpdate(Declaration entity) throws Exception {

    }

    @Override
    protected void beforeEntityDelete(Declaration entity) throws Exception {

    }
}
