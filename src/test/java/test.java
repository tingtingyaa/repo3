import org.junit.Test;

import java.sql.*;

/*java调用存储过程*/
public class test {

    @Test
    public void save() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql:///my","root","root");
        CallableStatement cs = null;
        ResultSet rs = null;
        try {
            /*
            //有参数无返回值
            cs = conn.prepareCall("{CALL p_address(?,?)}");
            cs.setString(1,"hennan");
            cs.setInt(2,1);
            int a = cs.executeUpdate();
            System.out.println(a);

            //无参数返回结果集
            cs = conn.prepareCall("{CALL p_card()}");
            rs = cs.executeQuery();
            while(rs.next()) {
                String cardno = rs.getString("cardno");
                System.out.println("cardno:" + cardno);
            }
            */
            //有返回值参数
            cs = conn.prepareCall("{CALL p_insert(?,?,?)}");
            cs.registerOutParameter(1, Types.INTEGER);
            cs.setString(2,"xixingit");
            cs.setString(3,"2222222");
            cs.executeUpdate();
            int id = cs.getInt(1);
            System.out.println("刚刚插入的Id：" + id);
        } catch (SQLException e) {
            e.printStackTrace();
            conn.rollback();
        } finally {
            //rs.close();
            cs.close();
            conn.close();
        }
    }
}
