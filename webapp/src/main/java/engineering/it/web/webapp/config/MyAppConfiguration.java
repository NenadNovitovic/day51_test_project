package engineering.it.web.webapp.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = {
		"engineering.it.web.webapp"
})
public class MyAppConfiguration {

	@Bean
	public DataSource dataSource() {
		System.out.println("DataSource create");
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/webapp_day51");
		dataSource.setUsername("root");
		dataSource.setPassword("pass");
		return dataSource;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {

		System.out.println("JdbcTemplate create");
		return new JdbcTemplate(dataSource);
	}
}
