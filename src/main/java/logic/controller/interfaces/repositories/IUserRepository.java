package logic.controller.interfaces.repositories;

import logic.model.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by Spayker on 3/1/2016.
 */
@Transactional(readOnly = true)
public interface IUserRepository extends JpaRepository<User, Long> {
    User findByFirstName(String firstName);
}
