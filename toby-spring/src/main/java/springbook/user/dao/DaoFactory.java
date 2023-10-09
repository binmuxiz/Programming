package springbook.user.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//* 객체의 생성방법을 결정하고 만들어진 객체를 돌려주는 객체 : Factory

@Configuration  //* 애플리케이션 컨텍스트/빈팩토리가 사용할 설정정보라는 표시
public class DaoFactory {

    //* new DConnectionMaker() 코드의 중복 제거. 다른 ConnectionMaker로 변경하더라도 코드의 변경이 용이.
    @Bean
    public ConnectionMaker connectionMaker() {
        return new DConnectionMaker();
    }

    //* 팩토리의 메소드는 UserDao 타입의 오브젝트를 어떻게 만들지를 결정한다.
    @Bean //* 오브젝트 생성을 담당하는 IoC용 팩토리라는 표시
    public UserDao userDao() {
        //* UserDao가 사용할 ConnectionMaker 구현 클래스를 결정하고 오브젝트를 생성하여 전달한다.
        //* 결국 두 오브젝트(UserDao와 DConnectionMaker)의 의존관계 설정 (런타임 오브젝트 의존관계)
        return new UserDao(connectionMaker());
    }

    //* 다른 Dao 클래스를 생성하는 메소드도 만들어보자
    public AccountDao accountDao() {
        return new AccountDao(connectionMaker());
    }

    public MessageDao messageDao() {
        return new MessageDao(connectionMaker());
    }
}
