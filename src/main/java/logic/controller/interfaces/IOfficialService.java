package logic.controller.interfaces;

import logic.model.dao.CommonEntity;
import logic.model.dao.Official;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Spayker on 2/25/2016.
 */
public interface IOfficialService<T extends Official> extends ICommonEntityService<Official> {
}
