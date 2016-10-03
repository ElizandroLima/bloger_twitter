package controller;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@SpringBootApplication
public class TwitterApplication {

	public static void main(String[] args) {
		SpringApplication.run(TwitterApplication.class, args);
	}

	@Bean
	@Primary
	@ConfigurationProperties(prefix = "datasource.twitter")
	public DataSource siteDataSourceBean() {
		return DataSourceBuilder.create().build();
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean siteEntityManagerFactoryBean(EntityManagerFactoryBuilder builder) {
		// Pacotes que serão escaneados para as Entities
		return builder.dataSource(siteDataSourceBean()).packages("controller").persistenceUnit("twitterPU").build();
	}
}
