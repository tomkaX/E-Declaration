package logic.controller.interfaces.repositories;

import logic.model.dao.Official;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Spayker on 3/1/2016.
 */
public interface IOfficialRepository extends JpaRepository<Official, Long> {

    Official findByFirstName(String firstName);

}
