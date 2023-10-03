package springbook.user;

import springbook.user.dao.DConnectionMaker;
import springbook.user.dao.UserDao;
import springbook.user.domain.User;

import java.sql.SQLException;

public class SpringBookApp {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        UserDao userDao = new UserDao();

        User user = new User();
        user.setId("id");
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
