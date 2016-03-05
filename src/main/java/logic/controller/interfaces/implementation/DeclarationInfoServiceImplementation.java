package logic.controller.interfaces.implementation;

import logic.controller.interfaces.IDeclarationInfoService;
import logic.model.dao.DeclarationInfo;


/**
 * Created by Spayker on 2/25/2016.
 */
public class DeclarationInfoServiceImplementation extends CommonEntityServiceImplementation<DeclarationInfo> implements
        IDeclarationInfoService{


    /**
     * Constructor with fields
     *
     * @param persistentClass Class that this dao will work with
     */
    public DeclarationInfoServiceImplementation(Class<DeclarationInfo> persistentClass) {
        super(persistentClass);
    }

    @Override
    protected void beforeEntityAddUpdate(DeclarationInfo entity) throws Exception {

    }

    @Override
    protected void beforeEntityDelete(DeclarationInfo entity) throws Exception {

    }
}
