import java.sql.SQLException;
import java.util.Date;

/**
 * Created by wfsovereign on 15-3-21.
 */
public class Client {
    public static void main(String[] args) throws SQLException {
        JdbcAction databaseAction = new JdbcAction();
        databaseAction.allView();

        DataFactory dataFactory = new DataFactory();
        dataFactory.getPersonInfo();
//        databaseAction.insert(dataFactory.getDayInfo(),dataFactory.personInfo);
    }
}
