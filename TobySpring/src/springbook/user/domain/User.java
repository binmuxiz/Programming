package springbook.user.domain;

import springbook.user.dao.UserDao;

import java.sql.SQLException;

// 자바빈 규약을 따르는 오브젝트 - 디폴트 생성자, 프로퍼티
public class User {
    String id;
    String name;
    String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        UserDao userDao = new UserDao();

        User user = new User();
        user.setId("newId");
        user.setPassword("0881");
        user.setName("이은빈");

        userDao.add(user);

        System.out.println("user.getId() " + user.getId());

        User user2 = userDao.get(user.getId());
        System.out.println("user2.getName() " + user2.getName());
        System.out.println("user2.getPassword() " + user2.getPassword());

        System.out.println(user2.getId() + " 조회 성공");
    }
}
