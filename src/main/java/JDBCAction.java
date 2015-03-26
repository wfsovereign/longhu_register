import java.sql.*;

/**
 * Created by wfsovereign on 15-3-20.
 */


public class JDBCAction {
    static Connection conn;

    static Statement st;

    public static Connection getConnection() {
        conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/register", "root", "1993525");

        } catch (Exception e) {
            System.out.println("数据库连接失败" + e.getMessage());
        }
        return conn;
    }
    public void insert(String data,int[] personInfo) throws SQLException {
        conn = JDBCAction.getConnection();

        st = conn.createStatement();
        String insertInfo ="INSERT INTO record VALUE ("+data;
        for (int i = 0; i < 7; i++) {
            insertInfo += ","+personInfo[i];
        }
        insertInfo += ")";

        //"INSERT INTO record VALUE ("+data+",0,0,0,0,0,0,0)"
        st.executeUpdate(insertInfo);

    }

    public void allView() throws SQLException {
        conn = JDBCAction.getConnection();

        st = conn.createStatement();
        System.out.println("*********************************");

        System.out.println("******办公室简易人员到位情况表******");

        System.out.println("*********************************");
        ResultSet res = st.executeQuery("SELECT * FROM record");
        while(res.next()){
            System.out.println("时间:"+res.getDate("time")
                    +"\t"+"冯杨琦君:"+res.getInt("fyqj")
                    +"\t"+"王中碧:"+res.getInt("wzb")
                    +"\t\t"+"赵  鹏:"+res.getInt("zp")
                    +"\t\t"+"曾璞阳:"+res.getInt("zpy")
                    +"\t\t"+"罗 杨:"+res.getInt("ly")
                    +"\t\t"+"陈世超:"+res.getInt("csc")
                    +"\t\t"+"汪 鑫:"+res.getInt("wx"));
        }
        res.close();
    }

    public void update(){
        conn = JDBCAction.getConnection();

    }

//    public static void main(String[] args) throws SQLException {
//        conn = JDBCAction.getConnection();
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