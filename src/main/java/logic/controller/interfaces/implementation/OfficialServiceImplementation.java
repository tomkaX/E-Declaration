package logic.controller.interfaces.implementation;

import logic.controller.interfaces.repositories.IOfficialRepository;
import logic.model.dao.Official;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Spayker on 2/25/2016.
 */
@Service
@Transactional(readOnly = true)
public class OfficialServiceImplementation {

    @Autowired
    private IOfficialRepository repository;

    public Official find(Long id) {
        return repository.findOne(id);
    }

    @Transactional
    public void update(Official official) {
        repository.saveAndFlush(official);
    }

    public Official findByFirstName(String firstName) {
        return repository.findByFirstName(firstName);
    }
}
