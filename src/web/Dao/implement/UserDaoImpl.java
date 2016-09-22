package web.Dao.implement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import web.Dao.UserDao;
import web.Model.User;

@Repository
public class UserDaoImpl implements UserDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public User SelectUser(String username){
		String sqlStr = "select id,username,password from user where username=?";
		final User user = new User();
		jdbcTemplate.query(sqlStr, new Object[]{username}, new RowCallbackHandler() {
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
			}
		});
		return user;
		
	}
	@Override
	public List<User> SelectUser() {
		String sql = "select * from user";
		List<User> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
		return list;
	}
}
