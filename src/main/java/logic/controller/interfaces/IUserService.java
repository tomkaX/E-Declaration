package logic.controller.interfaces;

import logic.model.dao.User;

/**
 * Created by Spayker on 2/24/2016.
 */
public interface IUserService extends ICommonEntityService<User> {

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