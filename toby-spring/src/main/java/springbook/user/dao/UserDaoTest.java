package springbook.user.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springbook.user.dao.UserDao;
import springbook.user.domain.User;

import java.sql.SQLException;

/**
 * 1.3.3 관계설정 책임의 분리
 * UserDao를 사용하는 클라이언트
 */
public class UserDaoTest {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
        UserDao userDao = context.getBean("userDao", UserDao.class);

        /**
         * 기존에 UserDaoTest가 테스트하는 책임 외에
         * 어떤 ConnectionMaker를 사용할지 결정하는 책임도 맡고 있었다.
         * 분리하자!.!
         * UserDao와 ConnectionMaker 구현 클래스의 오브젝트를 만들고, 두 객체을 연결시키는 작업을
         * Factory가 수행하도록 하였다.
         */
//        UserDao userDao = new DaoFactory().userDao();

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
