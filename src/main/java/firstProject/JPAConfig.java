package firstProject;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class JPAConfig {


        @Bean
        public LocalContainerEntityManagerFactoryBean emf() {
            LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
            emf.setDataSource(dataSource());
            emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
            emf.setJpaProperties(jpaProperties());
            return emf;
        }

        @Bean
        public DataSource dataSource() {
            DriverManagerDataSource ds = new DriverManagerDataSource();
            ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
            ds.setUrl("jdbc:mysql://127.0.0.1:3306/user");
            ds.setUsername("root");
            ds.setPassword("root");
            return ds;
        }

        @Bean
        public PlatformTransactionManager txnManager(EntityManagerFactory emf) {
            JpaTransactionManager txnMgr = new JpaTransactionManager(emf);
            return txnMgr;
        }

        private Properties jpaProperties() {
            Properties props = new Properties();
            props.put("hibernate.dialect", "org.hibernate.dialect.MySQL57Dialect");
            props.put("hibernate.show_sql", "true");
            props.put("hibernate.hbm2ddl.auto", "validate");
            return props;
        }
    }

