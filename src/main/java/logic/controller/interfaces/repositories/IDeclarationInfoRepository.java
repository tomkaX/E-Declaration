package logic.controller.interfaces.repositories;

import logic.model.dao.DeclarationInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Spayker on 3/1/2016.
 */
public interface IDeclarationInfoRepository extends JpaRepository<DeclarationInfo, Long> {

    DeclarationInfo findById(long id);



}
