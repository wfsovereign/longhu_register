import java.sql.*;

/**
 * Created by wfsovereign on 15-3-20.
 */


public class JdbcAction {
    static Connection conn;

    static Statement st;

    public static Connection getConnection() {
        conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("----------");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/register", "root", "1993525");

        } catch (Exception e) {
            System.out.println("-----------");
            System.out.println("数据库连接失败" + e.getMessage());
        }
        return conn;
    }
    public void insert() throws SQLException {
        conn = JdbcAction.getConnection();
        if( conn != null ){
            System.out.println( "MySQL 数据库连接成功！" );
        }else{
            System.out.println( "MySQL 数据库连接失败！" );
        }
        st = conn.createStatement();
    }

    public void allView() throws SQLException {
        conn = JdbcAction.getConnection();
        if( conn != null ){
            System.out.println( "MySQL 数据库连接成功！" );
        }else{
            System.out.println( "MySQL 数据库连接失败！" );
        }
        st = conn.createStatement();
        ResultSet res = st.executeQuery("SELECT * FROM record");
        while(res.next()){
            System.out.println("time:"+res.getDate("time")+"\t"+"fyqj:"+res.getInt("fyqj")
                    +"\t"+"wzb:"+res.getInt("wzb")
                    +"\t"+"zp:"+res.getInt("zp")
                    +"\t"+"zpy:"+res.getInt("zpy")
                    +"\t"+"ly:"+res.getInt("ly")
                    +"\t"+"csc:"+res.getInt("csc")
                    +"\t"+"wx:"+res.getInt("wx"));
        }
        res.close();

    }

//    public static void main(String[] args) throws SQLException {
//        conn = JdbcAction.getConnection();
//        if( conn != null ){
//            System.out.println( "MySQL 数据库连接成功！" );
//        }else{
//            System.out.println( "MySQL 数据库连接失败！" );
//        }
//        st = conn.createStatement();
//        ResultSet res = st.executeQuery("SELECT * FROM record");
//        while(res.next()){
//            System.out.println("time:"+res.getDate("time")+"\t"+"fyqj:"+res.getInt("fyqj")
//                    +"\t"+"wzb:"+res.getInt("wzb")
//            +"\t"+"zp:"+res.getInt("zp")
//            +"\t"+"zpy:"+res.getInt("zpy")
//            +"\t"+"ly:"+res.getInt("ly")
//            +"\t"+"csc:"+res.getInt("csc")
//            +"\t"+"wx:"+res.getInt("wx"));
//        }
//        res.close();
//    }



}