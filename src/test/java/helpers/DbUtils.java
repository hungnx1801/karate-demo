package helpers;

import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class DbUtils {
    private final JdbcTemplate jdbc;

    public DbUtils(Map<String, Object> config) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        // Driver mặc định cho PostgreSQL
        dataSource.setDriverClassName("org.postgresql.Driver");

        // Trích xuất các giá trị từ object dbConfig bạn đã định nghĩa
        dataSource.setUrl((String) config.get("url"));
        dataSource.setUsername((String) config.get("username"));
        dataSource.setPassword((String) config.get("password"));

        this.jdbc = new JdbcTemplate(dataSource);
    }

    // Hàm thực thi câu lệnh SELECT (trả về 1 bản ghi)
    public Map<String, Object> readValue(String query) {
        return jdbc.queryForMap(query);
    }

    // Hàm thực thi câu lệnh SELECT (trả về danh sách bản ghi)
    public List<Map<String, Object>> readRows(String query) {
        return jdbc.queryForList(query);
    }

    // Hàm thực thi lệnh INSERT/UPDATE/DELETE (Clean up dữ liệu)
    public void execute(String sql) {
        jdbc.execute(sql);
    }
}