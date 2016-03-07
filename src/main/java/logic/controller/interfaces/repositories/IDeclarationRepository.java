package logic.controller.interfaces.repositories;

import logic.model.dao.Declaration;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Spayker on 3/1/2016.
 */
public interface IDeclarationRepository extends JpaRepository<Declaration, Long> {

    Declaration findById(long id);

}
