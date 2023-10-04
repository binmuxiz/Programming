package springbook.user.dao;

import springbook.user.dao.UserDao;
import springbook.user.domain.User;

import java.sql.SQLException;

/**
 * 1.3.3 관계설정 책임의 분리
 * UserDao를 사용하는 클라이언트
 */
public class UserDaoTest {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        // UserDao가 사용할 ConnectionMaker 구현 클래스를 결정하고 오브젝트를 생성하여 전달한다.
        // 결국 두 오브젝트(UserDao와 DConnectionMaker)의 의존관계 설정 (런타임 오브젝트 의존관계)
        UserDao userDao = new UserDao(new DConnectionMaker());

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
