package logic.controller.interfaces.implementation;

import logic.controller.interfaces.IUserService;
import logic.model.dao.CommonEntity;
import logic.model.dao.User;

import java.util.List;

/**
 * Created by Spayker on 2/25/2016.
 */
public class UserServiceImplementation extends CommonEntityServiceImplementation<User> implements
        IUserService {

    /**
     * Constructor with fields
     *
     * @param persistentClass Class that this dao will work with
     */
    public UserServiceImplementation(Class<User> persistentClass) {
        super(persistentClass);
    }

    public User getByLogin(String login) throws IllegalArgumentException {
        return null;
    }

    public boolean checkExist(User user) {
        return false;
    }

    @Override
    protected void beforeEntityAddUpdate(User entity) throws Exception {

    }

    @Override
    protected void beforeEntityDelete(User entity) throws Exception {

    }
}
