package engineering.it.web.webapp.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import engineering.it.web.webapp.dao.MestoDao;
import engineering.it.web.webapp.domain.Mesto;

public class MestoDaoSpringJDBC implements MestoDao {
	
	private JdbcTemplate jdbcTemplate;

	public MestoDaoSpringJDBC() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/webapp_day51");
		dataSource.setUsername("root");
		dataSource.setPassword("pass");
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	class MestoMapper implements RowMapper<Mesto>{

		@Override
		public Mesto mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			Mesto mesto = new Mesto();
			mesto.setPttBroj(rs.getLong("pttBroj"));
			mesto.setNaziv(rs.getString("naziv"));
			return mesto;
		}
		
	}
	
	@Override
	public List<Mesto> getAll() {
		String query = "SELECT * FROM Mesto";
		
		return jdbcTemplate.query(query, new MestoMapper());
		/*return jdbcTemplate.query(query, (ResultSet rs, int rowNum)->{
			System.out.println("Lambda=====" + rowNum + "==========");
			Mesto mesto = new Mesto();
			mesto.setPttBroj(rs.getLong("pttBroj"));
			mesto.setNaziv(rs.getString("naziv"));
			return mesto;
		});*/
	}

	@Override
	public Mesto getById(Long ptt) {
		return jdbcTemplate.queryForObject("SELECT * FROM Mesto where pttBroj="+ptt, new MestoMapper());
	}

	@Override
	public boolean add(Mesto m) {
		
		jdbcTemplate.update("INSERT INTO mesto(pttBroj,naziv)  VALUES(?,?)",
						  m.getPttBroj(),
						  m.getNaziv());
			
		System.out.println("dodao " + m);
		return true;
	}

	@Override
	public boolean update(Mesto m) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Long ptt) {
		// TODO Auto-generated method stub
		return false;
	}

}
