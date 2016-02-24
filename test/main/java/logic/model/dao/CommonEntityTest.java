package main.java.logic.model.dao;

import config.ApplicationConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import java.util.Collection;
import static org.junit.Assert.*;
/**
 * Created by Spayker on 2/24/2016.
 */
abstract class CommonEntityTest <T extends logic.model.dao.CommonEntity> {

    /**
     * Spring application context to use in tests
     */
    protected static ApplicationContext appContext;

    /**
     * Obtaining Spring context for testing
     */
    @BeforeClass
    public static void obtainApplicationContext() {
        appContext = ApplicationConfig
                .getSpringApplicationContext("spring-config.xml");
        assertNotNull("Application context was not created", appContext);
    }

    /**
     * Get the first entity for testing
     *
     * @return
     */
    @SuppressWarnings("JavaDoc")
    protected abstract T getFirstEntity();

    /**
     * Get the first entity for testing
     *
     * @return
     */
    @SuppressWarnings("JavaDoc")
    protected abstract T getSecondEntity();

    /**
     * Entity that is saved before tests and deleted afterwards
     */
    protected T entity1;
    /**
     * Entity that is saved before tests and deleted afterwards
     */
    protected T entity2;

    /**
     * Saving entities to database, before each test
     *
     * @throws Exception
     */

    @SuppressWarnings("JavaDoc")
    @Before
    public void saveEntitiesToDatabase() throws Exception {

    }

    /**
     * Deleting entities from database if their reference is not null
     *
     * @throws Exception
     */

    @SuppressWarnings("JavaDoc")
    @After
    public void deleteEntitiesFromDatabase() throws Exception {

    }

    /**
     * Test method for
     * .
     *
     * @throws Exception
     */

    @SuppressWarnings("JavaDoc")
    @Test
    public void testGetAllEntitiesCount() throws Exception {

    }

    /**
     * Test method for
     *
     * @throws Exception
     * @throws IllegalArgumentException
     */
    @SuppressWarnings("JavaDoc")
    @Test
    public void testDelEntityLong() throws Exception {

    }

    @SuppressWarnings("JavaDoc")
    @Test
    public void testGetAllEntites() {

    }

    @Test
    public void testGetEntityById() {

    }
}
