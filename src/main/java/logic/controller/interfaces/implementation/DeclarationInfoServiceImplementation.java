package logic.controller.interfaces.implementation;

import logic.controller.interfaces.repositories.IDeclarationInfoRepository;
import logic.model.dao.DeclarationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by Spayker on 2/25/2016.
 */
@Service
@Transactional(readOnly = true)
public class DeclarationInfoServiceImplementation {

    @Autowired
    private IDeclarationInfoRepository repository;

    public DeclarationInfo find(Long id) {
        return repository.findOne(id);
    }

    @Transactional
    public void update(DeclarationInfo declarationInfo) {
        repository.saveAndFlush(declarationInfo);
    }

    public DeclarationInfo findById(long id) {
        return repository.findById(id);
    }
}
