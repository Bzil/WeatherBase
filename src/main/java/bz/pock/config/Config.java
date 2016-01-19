package bz.pock.config;

import com.jolbox.bonecp.BoneCPDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;


@Configuration
@EnableJpaRepositories(basePackages = "bz.pock.persistence")
@PropertySource("classpath:application.properties")
@EnableTransactionManagement
public class Config {
    @Autowired
    private Environment env;

    /**
     * Setups and creates the data source.
     *
     * @return the data source
     */
    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        final BoneCPDataSource dataSource = new BoneCPDataSource();
        dataSource.setDriverClass(env.getProperty("db.driver"));
        dataSource.setUsername(env.getRequiredProperty("db.username"));
        dataSource.setPassword(env.getRequiredProperty("db.password"));
        dataSource.setJdbcUrl(env.getRequiredProperty("db.url"));
        dataSource.setMinConnectionsPerPartition(Integer.parseInt(env.getRequiredProperty("db.connection-min")));
        dataSource.setMaxConnectionsPerPartition(Integer.parseInt(env.getRequiredProperty("db.connection-max")));

        return dataSource;
    }

    /**
     * Creates the entity manager factory used by spring data jpa.
     *
     * @param dataSource the datasource to use.
     * @param env        the environment.
     * @return the newly created entity manager factory.
     */
    @Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, Environment env) {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setPackagesToScan("bz.pock.model");

        Properties jpaProperties = new Properties();

        //Configures the used database dialect. This allows Hibernate to create SQL that is optimized for the used database.
        jpaProperties.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
        //Specifies the action that is invoked to the database when the Hibernate SessionFactory is created or closed.
        jpaProperties.put("hibernate.hbm2ddl.auto", env.getRequiredProperty("hibernate.hbm2ddl.auto"));
        //Configures the naming strategy that is used when Hibernate creates new database objects and schema elements
        jpaProperties.put("hibernate.ejb.naming_strategy", env.getRequiredProperty("hibernate.ejb.naming_strategy"));
        //If the value of this property is true, Hibernate writes all SQL statements to the console.
        jpaProperties.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
        //If the value of this property is true, Hibernate will format the SQL that is written to the console.
        jpaProperties.put("hibernate.format_sql", env.getRequiredProperty("hibernate.format_sql"));
        entityManagerFactoryBean.setJpaProperties(jpaProperties);
        return entityManagerFactoryBean;
    }

    /**
     * Configure transaction manager.
     *
     * @param entityManagerFactory entity mananger.
     * @return manager
     */
    @Bean
    JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }
}
