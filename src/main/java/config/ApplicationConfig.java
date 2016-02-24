package config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Spayker on 2/24/2016.
 */
public final class ApplicationConfig {

    private static final String SPRING_DAO_CONFIG_XML = "spring-config.xml"; //$NON-NLS-1$

    /**
     * Spring context
     */
    private static ApplicationContext springAppContext;

    /**
     * Loading Spring configs and creating context
     *
     * @return Spring application context
     */
    @SuppressWarnings("UnusedDeclaration")
    public static ApplicationContext getSpringApplicationContext() {
        if (springAppContext == null) {
            springAppContext = getSpringApplicationContext(SPRING_DAO_CONFIG_XML);
        }
        return springAppContext;
    }

    /**
     * Loading Spring configs and creating context
     *
     * @param contextPath
     * @return Spring application context
     */
    @SuppressWarnings("JavaDoc")
    public static ApplicationContext getSpringApplicationContext(String contextPath) {
        springAppContext = new ClassPathXmlApplicationContext(contextPath);
        return springAppContext;
    }
}
