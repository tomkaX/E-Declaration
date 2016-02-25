package logic.controller.interfaces;

import logic.model.dao.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Spayker on 2/24/2016.
 */
public interface IUserService<T extends User> extends ICommonEntityService<User> {

    /**
     * @param login
     * @return List<User>
     * @throws IllegalArgumentException
     */
    public User getByLogin(String login) throws
            IllegalArgumentException;

    /**
     * @param user
     * @return List<User>
     * @throws IllegalArgumentException
     */
    public boolean checkExist(User user);

}