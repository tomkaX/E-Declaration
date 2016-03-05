package config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * Created by Spayker on 2/24/2016.
 */
@Configuration
@EnableJpaRepositories
@EnableTransactionManagement
public final class ApplicationConfig {

    private static final String SPRING_DAO_CONFIG_XML = "spring-config.xml";

    /**
     * Spring context
     */
    private static ApplicationContext springAppContext;

    @Bean
    public DataSource dataSource() {

        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        return builder.setType(EmbeddedDatabaseType.HSQL).build();
    }

    @Bean
    public EntityManagerFactory entityManagerFactory() {

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("logic.model.dao");
        factory.setDataSource(dataSource());
        factory.afterPropertiesSet();

        return factory.getObject();
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory());
        return txManager;
    }

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
