package logic.controller.interfaces.implementation;

import logic.controller.interfaces.ICommonEntityService;
import logic.model.dao.CommonEntity;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Spayker on 2/24/2016.
 */
public abstract class CommonEntityServiceImplementation<T extends CommonEntity> implements ICommonEntityService<T> {

    /** Spring's jpa repository that is used to work with db */
    protected JpaRepository jpaRepository;

    /**
     * Log object used for logging
     */
    private static final Logger LOGGER = Logger.getLogger(CommonEntityServiceImplementation.class);

    /** Persistent class that this dao works with */
    protected Class<T> persistentClass;

    /**
     * Constructor with fields
     *
     * @param persistentClass
     *            Class that this dao will work with
     */
    public CommonEntityServiceImplementation(Class<T> persistentClass) {
        super();
    }

    /**
     * @return the jpaRepository
     */
    public JpaRepository getJpaRepository() {
        return jpaRepository;
    }

    /**
     * @param jpaRepository the jpaTemplate to set
     */
    public void setJpaRepository(JpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    /**
     * Method that is called, before entity is being updated or added. Method
     * must be overwritten in subclasses to make some checks.
     *
     * @param entity
     *            Entity that will be added or updated
     * @throws Exception
     *             If error occurs
     */
    protected abstract void beforeEntityAddUpdate(T entity)
            throws Exception;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getAllEntitiesCount() {
        try {
            return jpaRepository.findAll().size();
        } catch (Exception e) {
            LOGGER.error("Failed to get all entities count", e);
            return 0;
        }
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Object save(T entity) throws IllegalArgumentException, Exception {
        if (entity == null) {
            throw new IllegalArgumentException(
                    "Entity for saving cannot be null!");
        }

        T savedEntity = null;

        try {

           if (LOGGER.isDebugEnabled()) {
               LOGGER.debug("Saving new entity: " + entity);
           }

           jpaRepository.save(entity);
           savedEntity = entity;


        } catch (Exception e) {
            if (entity.getId() == null) {
                LOGGER.error("GenericServiceImpl.ErrorFailedToAdd: " + entity);
            } else {
                LOGGER.error("GenericServiceImpl.ErrorFailedToUpdate: " + entity);
            }
        }

        return savedEntity;
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void delEntity(Long id) throws IllegalArgumentException, Exception {
        if(id != null)
            jpaRepository.delete(id);
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void delEntity(T entity) throws IllegalArgumentException, Exception {
        if(entity != null)
            jpaRepository.delete(entity);
    }

    /**
     * Method that is called just before entity is deleted
     * @param entity Entity to delete
     * @throws Exception If error occurs
     */
    protected abstract void beforeEntityDelete(T entity) throws Exception;


    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void delAllEntities(Collection<Long> ids) throws IllegalArgumentException,
            Exception {
        jpaRepository.deleteAll();
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<T> getAllEntites() {
        try {
            // Getting all entities
            List<T> list = jpaRepository.findAll();
            if (list != null) {
                return list;
            } else {
                return new ArrayList<T>();
            }

        } catch (Exception e) {
            LOGGER.error("Failed to get list of all entities" + e);
            return new ArrayList<T>();
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public T getEntityById(Long id) throws IllegalArgumentException {
        if (id == null) {
            LOGGER.error("GenericDaoJpa.ErrorEntityIdNull");
        }
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Getting entity by id " + id);
        }

        try {
            T savedEntity = null;
            // Getting entity by id
            List<T> entities = jpaRepository.findAll();
            for(T ent : entities){
                if(ent.getId() == id) {
                    savedEntity = ent;
                    break;
                }
            }

            // Checking if we got the entity that is not NULL
            if ((savedEntity == null) || (savedEntity.getId() == null)) {
                StringBuilder mess = new StringBuilder("Entity by id ");
                mess.append(id).append(" was not found");
                LOGGER.warn(mess.toString());
                return null;
            }

            return savedEntity;
        } catch (Exception e) {
            LOGGER.error("Failed to get entity by id " + id, e);
            return null;
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<T> getAllEntities() throws IllegalArgumentException {
        return jpaRepository.findAll();
    }

}
