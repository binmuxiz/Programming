package springbook.user.dao;

import springbook.user.domain.User;

import java.sql.*;

// 이 초난감 DAO 코드를 뜯어고쳐야 하는 이유가 뭘까? 개선했을 때의 장점, 미래에 주는 유익은 무엇인가?
public abstract class UserDao {

    // JDBC API가 만들어내는 예외는 직접 잡아서 처리하거나 메소드 밖으로 던진다. 일단 예외는 모두 메소드 밖으로 던지는게 간편하다?
    public void add(User user) throws ClassNotFoundException, SQLException {

        // DB 연결을 위한 connection을 가져온다
        Connection connection = getConnection();

        // sql을 담은 statement를 만든다
        PreparedStatement prepareStatement = connection.prepareStatement("insert into users(id, name, password) values (?,?,?)");
        prepareStatement.setString(1, user.getId());
        prepareStatement.setString(2, user.getName());
        prepareStatement.setString(3, user.getPassword());

        // statement를 실행한다
        prepareStatement.executeUpdate();

        prepareStatement.close();
        connection.close();
    }

    public User get(String id) throws ClassNotFoundException, SQLException {
        Connection connection = getConnection();

        PreparedStatement prepareStatement = connection.prepareStatement("select * from users where id = ?");
        prepareStatement.setString(1, id);

        // 조회의 경우 SQL 쿼리의 실행 결과를 ResultSet에 받아서 User(오브젝트)에 저장한다
        ResultSet resultSet = prepareStatement.executeQuery();
        resultSet.next();

        User user = new User();
        user.setId(resultSet.getString("id"));
        user.setName(resultSet.getString("name"));
        user.setPassword(resultSet.getString("password"));

        // 작업 중에 생성된 리소스를 작업을 마친 후 닫아준다
        resultSet.close();
        prepareStatement.close();
        connection.close();

        return user;
    }

    // 관심사 1 - DB 커넥션 연결
    // refactoring - 중복 코드의 메소드 추출(extract method) -> <변경> 용이
    // 상속을 통한 <확장> 방법 - 구현 코드는 제거되고 추상 메소드로 바뀌었다. 메소드의 구현은 서브클래스가 담당

    public abstract Connection getConnection() throws ClassNotFoundException, SQLException;

    /*
     스프링에서 애옹~되는
     템플릿 메소드 패턴 - 슈퍼클래스에 기본 로직을 정의하고 그 기능의 일부를 추상 메소드나 override 가능한 메소드 등으로 만든뒤
     서브클래스에서 구현하도록 하는 방법
     팩토리 메소드 패턴 - 서브클래스에서 구체적인 오브젝트 생성 방법을 결정하게 하는 것
     */

    /*
     UserDao는 Connection의 어떤 기능을 사용한다에 관심을,
     NUserDao, DUserDao는 어떤 식으로 Connection 기능을 제공하는지, 어떤 방법으로 Connection 오브젝트를 만들어 내는지에 관심을 둔다.
     */

    public class NUserDao extends UserDao {
        @Override
        public Connection getConnection() throws ClassNotFoundException, SQLException {
            // N사 DB Connection 생성코드
            return null;
        }
    }

    public class DUserDao extends UserDao {
        @Override
        public Connection getConnection() throws ClassNotFoundException, SQLException {
            // D사 DB Connection 생성코드
            return null;
        }
    }
}
