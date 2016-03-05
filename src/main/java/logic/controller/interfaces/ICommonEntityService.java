package logic.controller.interfaces;

/**
 * Created by Spayker on 2/24/2016.
 */

import logic.model.dao.CommonEntity;

import java.util.Collection;
import java.util.List;

/**
 * This is a generic interface that exposes generic methods used mostly by all
 * services. This methods include CRUD operations with ability to get all
 * entity. If some service doesn't need to provide support for all such methods,
 * then it should not subclass this interface.
 *
 * @param <T> Domain class to work with
 */

@SuppressWarnings("UnusedDeclaration")
public interface ICommonEntityService<T extends CommonEntity> {

    /**
     * Deleting entity from database. Doing nothing if entity with passed id not
     * found.
     *
     * @param id Unique id of the entity to delete
     * @throws logic.controller.exceptions.EDeclarationException
     *                                  If service fails to delete entity
     * @throws IllegalArgumentException If id is <code>null</code>
     * @throws logic.controller.exceptions.EDeclarationException
     *
     */
    @SuppressWarnings("JavaDoc")
    public void delEntity(Long id) throws
            Exception;

    /**
     * Deleting persistent entity from database.
     *
     * @param entity Persistent entity to delete
     * @throws logic.controller.exceptions.EDeclarationException
     *                                  If service fails to delete entity
     * @throws IllegalArgumentException If entity is <code>null</code>
     * @throws logic.controller.exceptions.EDeclarationException
     *
     */
    @SuppressWarnings("JavaDoc")
    public void delEntity(T entity) throws
            Exception;

    /**
     * Deleting all entities by their ids
     *
     * @param ids Collection of ids. If it is null or empty, then doing nothing
     * @throws logic.controller.exceptions.EDeclarationException
     *                                  If error occurs
     * @throws IllegalArgumentException If ids is <code>null</code>
     * @throws logic.controller.exceptions.EDeclarationException
     *
     */
    @SuppressWarnings({"JavaDoc", "UnusedDeclaration"})
    public void delAllEntities(Collection<Long> ids)
            throws Exception;

    /**
     * Getting entity by its unique identifier
     *
     * @param id Id of entity to find
     * @return Entity of T type or <code>null</code> if not found or error
     * @throws IllegalArgumentException If id is <code>null</code>
     */
    public T getEntityById(Long id) throws IllegalArgumentException;

    /**
     * Getting all entities
     *
     * @return List of all entities of T type or empty list if error
     */
    public List<T> getAllEntites();

    /**
     * Save new object or updateUser old one in the DB.
     *
     * @param entity object to store
     * @return stored object
     *         //	 * @throws ServiceException
     *         //	 *             If domain or DB error occurs
     * @throws IllegalArgumentException If entity is <code>null</code>
     * @throws logic.controller.exceptions.EDeclarationException
     *
     * @throws logic.controller.exceptions.EDeclarationException
     *
     */
    @SuppressWarnings("JavaDoc")
    public Object save(T entity) throws
            Exception;

    /**
     * Count of all entities of current ItemType
     *
     * @return number of all entities or 0 if error
     */
    @SuppressWarnings("UnusedDeclaration")
    public int getAllEntitiesCount();

    /**
     * Retrieves from database entities for IDs specified by <code>ids</code>
     * parameter.
     *
     * @return List of entities or empty list. If list of IDs is null or empty
     *         method will return empty list of entities.
     * @throws IllegalArgumentException If ids is <code>null</code>
     */
    @SuppressWarnings("UnusedDeclaration")
    public List<T> getAllEntities()
            throws IllegalArgumentException;
}

