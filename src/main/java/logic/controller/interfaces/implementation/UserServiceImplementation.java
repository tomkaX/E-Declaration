package logic.controller.interfaces.implementation;

import logic.controller.interfaces.repositories.IUserRepository;
import logic.model.dao.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Spayker on 2/25/2016.
 */
@Service
@Transactional(readOnly = true)
public class UserServiceImplementation {

    @Autowired
    private IUserRepository repository;

    public User find(Long id) {
        return repository.findOne(id);
    }

    @Transactional
    public void update(User user) {
        repository.saveAndFlush(user);
    }

    public User findByFirstName(String firstName) {
        return repository.findByFirstName(firstName);
    }
}
