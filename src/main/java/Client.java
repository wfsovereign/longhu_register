import java.sql.SQLException;

/**
 * Created by wfsovereign on 15-3-21.
 */
public class Client {
    public static void main(String[] args) throws SQLException {
        JDBCAction databaseAction = new JDBCAction();
        databaseAction.allView();


        DataFactory dataFactory = new DataFactory();
        dataFactory.receivePersonInfo();
        databaseAction.insert(dataFactory.getDayInfo(),dataFactory.getPersonInfo());
        databaseAction.allView();

    }
}
