package com.example.weather.configuration;

import com.example.weather.exceptions.InitDataSourceException;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Configuration
@ComponentScan("com.example.weather")
@EnableWebMvc
@EnableTransactionManagement
public class MyConfig {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    DataSource dataSource() {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String appConfigPath = rootPath + "app.properties";

        try (FileInputStream fileInputStream = new FileInputStream(appConfigPath)){
            Properties properties = new Properties();
            properties.load(fileInputStream);

            dataSource.setDriverClass("org.postgresql.Driver");
            dataSource.setJdbcUrl(properties.getProperty("URL"));
            dataSource.setUser(properties.getProperty("username"));
            dataSource.setPassword(properties.getProperty("password"));
        } catch (PropertyVetoException | IOException e) {
            throw new InitDataSourceException(e.getMessage());
        }
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory(){
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("com.example.weather.entity");

        Properties hibernateProperty = new Properties();
        hibernateProperty.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        hibernateProperty.setProperty("hibernate.show_sql", "true");

        sessionFactory.setHibernateProperties(hibernateProperty);
        return sessionFactory;
    }

    @Bean
    public HibernateTransactionManager transactionManager(){
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }
}
