package springbook.user.dao;

/**
 * 객체의 생성방법을 결정하고 만들어진 객체를 돌려주는 객체 : Factory
 */
public class DaoFactory {

    /**
     * 팩토리의 메소드는 UserDao 타입의 오브젝트를 어떻게 만들지를 결정한다.
     * @return
     */
    public UserDao userDao() {
        // UserDao가 사용할 ConnectionMaker 구현 클래스를 결정하고 오브젝트를 생성하여 전달한다.
        // 결국 두 오브젝트(UserDao와 DConnectionMaker)의 의존관계 설정 (런타임 오브젝트 의존관계)

        DConnectionMaker connectionMaker = new DConnectionMaker();
        UserDao userDao = new UserDao(connectionMaker);
        return userDao;
    }
}
