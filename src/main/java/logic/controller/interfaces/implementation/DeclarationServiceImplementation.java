package logic.controller.interfaces.implementation;

import logic.controller.interfaces.repositories.IDeclarationRepository;
import logic.model.dao.Declaration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Spayker on 2/25/2016.
 */
@Service
@Transactional(readOnly = true)
public class DeclarationServiceImplementation {

    @Autowired
    private IDeclarationRepository repository;

    public Declaration find(Long id) {
        return repository.findOne(id);
    }

    @Transactional
    public void update(Declaration declaration) {
        repository.saveAndFlush(declaration);
    }

    public Declaration findByFirstName(long id) {
        return repository.findById(id);
    }
}
