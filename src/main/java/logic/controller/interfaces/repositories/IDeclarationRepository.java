package logic.controller.interfaces.repositories;

import logic.model.dao.Declaration;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * Created by Spayker on 3/1/2016.
 */
public interface IDeclarationRepository extends Repository<Declaration, Long> {


    List<Declaration> findByUserLastName(String lastname);


}
