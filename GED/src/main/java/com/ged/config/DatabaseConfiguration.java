package com.ged.config;

import java.util.Map;
import java.util.Properties;

import javax.inject.Inject;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import liquibase.integration.spring.SpringLiquibase;

@Configuration
@EnableConfigurationProperties(JpaProperties.class)
@EnableJpaRepositories(entityManagerFactoryRef = "masterEntityManager", transactionManagerRef = "masterTransactionManager", basePackages = {
		"com.ged.dao.master" })
@EnableTransactionManagement
public class DatabaseConfiguration {
	private final static Logger LOGGER = LoggerFactory.getLogger(DatabaseConfiguration.class);

	@Value("${liquibase.contexts}")
	private String liquibaseContext;

	@Value("${spring.datasource.url}")
	private String url;

	@Value("${spring.datasource.dataSourceClassName}")
	private String dataSourceClassName;

	@Value("${spring.datasource.username}")
	private String user;

	@Value("${spring.datasource.password}")
	private String password;

	@Inject
	private JpaProperties jpaProperties;

	@Inject
	private DataSource dataSource;

	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		DatabaseConfiguration.LOGGER.debug("Configuring datasource {} {} {}", this.dataSourceClassName, this.url,
				this.user);
		final HikariConfig config = new HikariConfig();
		config.setDataSourceClassName(this.dataSourceClassName);
		config.addDataSourceProperty("url", this.url);
		config.addDataSourceProperty("user", this.user);
		config.addDataSourceProperty("password", this.password);
		return new HikariDataSource(config);
	}

	@Bean
	public SpringLiquibase liquibase(final DataSource dataSource) {
		final SpringLiquibase sl = new SpringLiquibase();
		sl.setDataSource(dataSource);
		sl.setContexts(this.liquibaseContext);
		sl.setChangeLog("classpath:dbchangelog.xml");
		sl.setShouldRun(true);
		return sl;
	}

	@Bean(name = "masterEntityManager")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		final JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(this.dataSource());
		em.setPackagesToScan(new String[] { "com.ged.domain.master" });
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(this.additionalJpaProperties());

		em.setPersistenceUnitName("master");

		return em;
	}

	private Properties additionalJpaProperties() {
		final Properties properties = new Properties();
		for (final Map.Entry<String, String> entry : this.jpaProperties.getHibernateProperties(this.dataSource)
				.entrySet()) {
			properties.setProperty(entry.getKey(), entry.getValue());
		}
		return properties;
	}

	@Bean(name = "masterTransactionManager")
	public JpaTransactionManager transactionManager(final EntityManagerFactory masterEntityManager) {
		final JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(masterEntityManager);
		return transactionManager;
	}
}
