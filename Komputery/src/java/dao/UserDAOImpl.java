package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class UserDAOImpl implements UserDAO{
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
 
    @Override
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        jdbcTemplate = new JdbcTemplate(this.dataSource);
    }
 
    @Override
    public int create(User user) {
	String sql = "insert into users(id,username,password,type) values(?,?,?,?)";
	try {
            int counter = jdbcTemplate.update(sql, new Object[]{user.getId()
                                                                , user.getUsername()
                                                                , user.getPassword()
                                                                , user.getType()
                                                                });
            return counter;
	} catch (Exception e) { 
            e.printStackTrace();
            return 0;
	}
    }
}
