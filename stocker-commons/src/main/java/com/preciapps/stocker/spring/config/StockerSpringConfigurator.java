/**
 * 
 */
package com.preciapps.stocker.spring.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.preciapps.stocker.model.Battery;

/**
 * @author joseantoniogarciadelsaz
 *
 */

@Configuration
@EnableTransactionManagement
@ComponentScans(value = { @ComponentScan("es.uam.eps.tweetextractor.dao"),
		@ComponentScan("es.uam.eps.tweetextractor.dao.service"),
		@ComponentScan("es.uam.eps.tweetextractor.analytics.dao"),
		@ComponentScan("es.uam.eps.tweetextractor.analytics.dao.service") })
public class StockerSpringConfigurator {

	@Bean
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://db.preciapps.com/st_op00?currentSchema=st_op00&ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory");
		dataSource.setUsername("st_op00_update");
		dataSource.setPassword("st_op00_update");
		return dataSource;
	}

	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		factoryBean.setDataSource(getDataSource());
		Properties props = new Properties();
		props.put("hibernate.show_sql", "false");
		props.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		props.put("connection.provider_class", "org.hibernate.connection.C3P0ConnectionProvider");
		props.put("transaction.auto_close_session", "true");
		props.put("hibernate.c3p0.timeout", "20000");
		props.put("hibernate.hbm2ddl.auto", "update");
		factoryBean.setHibernateProperties(props);
		factoryBean.setAnnotatedClasses(Battery.class);
		return factoryBean;
	}

	@Bean
	public HibernateTransactionManager getTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(getSessionFactory().getObject());
		return transactionManager;
	}
}