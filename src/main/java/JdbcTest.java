import java.sql.*;

/**
 * @author qijun
 * @date 2021/8/10 14:34
 */
public class JdbcTest {

    public static final String URL = "jdbc:mysql://172.16.7.111/wec_biz_counselor_collector";
    public static final String USER = "admin";
    public static final String PASSWORD = "wisedu@2016";
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");

        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        //3.操作数据库，实现增删改查
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM t_coun_collector_1018954616644580 limit 1");
        //如果有数据，rs.next()返回true
        while(rs.next()){
            System.out.println(rs.getString("wid")+" 年龄："+rs.getInt("from_school_task"));
        }
    }

}
