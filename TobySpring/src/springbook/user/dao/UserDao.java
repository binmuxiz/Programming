package springbook.user.dao;

import springbook.user.domain.User;

import java.sql.*;

// 이 초난감 DAO 코드를 뜯어고쳐야 하는 이유가 뭘까? 개선했을 때의 장점, 미래에 주는 유익은 무엇인가?
public class UserDao {

    private SimpleConnectionMaker simpleConnectionMaker;

    /**
     * 1.3.2 인터페이스의 도입
     * 어떤 클래스의 오브젝트를 사용할지 결정하는 생성자의 코드는 제거되지 않고 남아있다.
     */
    public UserDao() {

        this.simpleConnectionMaker = new DConnectionMaker();
    }

    // JDBC API가 만들어내는 예외는 직접 잡아서 처리하거나 메소드 밖으로 던진다. 일단 예외는 모두 메소드 밖으로 던지는게 간편하다?
    public void add(User user) throws ClassNotFoundException, SQLException {

        // DB 연결을 위한 connection을 가져온다
        Connection connection = simpleConnectionMaker.makeConnection();

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
        Connection connection = simpleConnectionMaker.makeConnection();

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
}
