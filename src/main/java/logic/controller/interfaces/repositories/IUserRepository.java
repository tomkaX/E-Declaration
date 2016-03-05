package logic.controller.interfaces.repositories;

import logic.model.dao.User;
import org.springframework.data.repository.Repository;


/**
 * Created by Spayker on 3/1/2016.
 */
public interface IUserRepository extends Repository<User, Long> {

    //List<User> findByLastname(String lastname);
}
