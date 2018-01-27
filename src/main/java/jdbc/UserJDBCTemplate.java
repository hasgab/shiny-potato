package jdbc;


import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class UserJDBCTemplate {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;


    public void setDataSource(DataSource ds) {
        this.dataSource = ds;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    public void setImgURL(String url, Integer id) {
        String SQL = "update USER set imgURL = ? where id = ?";
        jdbcTemplateObject.update(SQL, url, id);
        System.out.println("update : ImageUrl = " + url);

    }
}
