package logic.controller.interfaces.implementation;

import logic.controller.interfaces.IGenericService;
import logic.model.dao.CommonEntity;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Spayker on 2/24/2016.
 */
public abstract class GenericServiceImplementation<T extends CommonEntity> implements IGenericService<T> {

    private static final String QUERY_SELECT_BY_ID_LIST = "SELECT x FROM %s x WHERE x.id IN (?1)";
    private static final String QUERY_SELECT_ALL = "SELECT x FROM %s x";
    private static final String QUERY_COUNT_ALL = "SELECT COUNT(x) FROM %s x";
    /** Spring's jpa template that is used to access db */
    protected JpaRepository jpaRepository;
    /** Persistent class that this dao works with */
    protected Class<T> persistentClass;
    /** Log object used for logging */
    protected Log log = LogFactory.getLog(getClass());

    /**
     * Constructor with fields
     *
     * @param persistentClass
     *            Class that this dao will work with
     */
    public GenericServiceImplementation(Class<T> persistentClass) {
        super();
        this.persistentClass = persistentClass;
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
     * <p>
     * This template method executes query with performing all needed
     * operations, like creating EntityManager, creating transaction,
     * committing, or rolling it back.
     * </p>
     * <p>
     * Methods sets parameters for the query as they appear in the parameters
     * list, by number starting from 1. So, the first parameter in your named
     * query should be referenced as <code>?1</code>, second as <code>?2</code>
     * and so on.
     * </p>
     * <p>
     * If <code>singleResult = true</code> and no result is found, then
     * <code>null</code> is returned.
     * </p>
     * <p>
     * Be aware, that when multiple results are returned, they are being
     * dynamically casted to <code>REZ</code> class. It should be able to cast
     * to {@link java.util.List}. When returning single result, <code>REZ</code>
     * should be a single persistent entity class.
     * </p>
     *
     * @param <REZ>
     *            Class of the result
     * @param queryOrQueryName
     *            Query string or NamedQuery name
     * @param namedQuery
     *            Specifies, whether query is named query
     * @param singleResult
     *            Specifies, whether single result should be returned
     * @param parameters
     *            Parameters. You can specify multiple parameters separated by
     *            comma
     * @return Result of the query
     * @throws PersistenceException
     *             If error occurs
     */
    @SuppressWarnings("unchecked")
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    protected <REZ> REZ executeQuery(String queryOrQueryName,
                                     boolean namedQuery, boolean singleResult, Object... parameters) {

        if (StringUtils.isBlank(queryOrQueryName)) {
            throw new IllegalArgumentException(
                    "Query for executing cannot be null");
        }

        if (log.isDebugEnabled()) {
            log.debug(String.format(
                    "Executing query '%s' to return single result '%s' with params %s",
                    queryOrQueryName, singleResult, ArrayUtils.toString(parameters)));
        }

        REZ result;
        List<?> list;

        return null;
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    protected int executeUpdateQuery(final String queryOrQueryName,
                                     final boolean namedQuery, final Object... parameters)
            throws IllegalArgumentException, Exception {

        if (StringUtils.isBlank(queryOrQueryName)) {
            throw new IllegalArgumentException(
                    "Query for executing cannot be null");
        }

        if (log.isDebugEnabled()) {
            log.debug(String.format(
                    "Executing update query '%s' to return single result '%s' with params %s",
                    queryOrQueryName, ArrayUtils.toString(parameters)));
        }


        return 0;
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
    public long getAllEntitiesCount() {
        try {
            return Long.getLong(executeQuery(String.format(QUERY_COUNT_ALL, persistentClass.getSimpleName()), false, true).toString());
        } catch (Exception e) {
            log.error("Failed to get all entities count", e);
            return 0;
        }
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public T save(T entity) throws IllegalArgumentException, Exception {
        if (entity == null) {
            throw new IllegalArgumentException(
                    "Entity for saving cannot be null!");
        }

        T savedEntity = null;


        return savedEntity;
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void delEntity(Long id) throws IllegalArgumentException, Exception {

    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void delEntity(T entity) throws IllegalArgumentException, Exception {

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


    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<T> getAllEntites() {
        try {
            // Getting all entities
            List<T> list = executeQuery(String.format(QUERY_SELECT_ALL, persistentClass.getSimpleName()), false, false);
            if (list != null) {
                return list;
            } else {
                return new ArrayList<T>();
            }

        } catch (Exception e) {
            log.error("Failed to get list of all entities", e);
            return new ArrayList<T>();
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public T getEntityById(Long id) throws IllegalArgumentException {

        return null;
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<T> getAllSorted(String propertySortBy, boolean asc) throws IllegalArgumentException {

        return null;
    }

    /**
     * Appending sort information to query and returning new query
     *
     * @param query
     *            Query to append with sort information
     * @param propertySortBy
     *            Property to sort by
     * @param asc
     *            Specifies sort direction
     * @return new query with added sort
     */
    protected String addSortPropertyToQuery(String query, String propertySortBy,
                                            boolean asc) {

        return query;
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<T> getEntitiesByIds(List<Long> ids) throws IllegalArgumentException {


        return null;
    }

}
