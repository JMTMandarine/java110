// 리스너 만들기
// - 리스너(listener)란? 특정 상황에 놓이면 실행되는 객체
// - javax.servlet.XxxListener
// 

package bitcamp.java110.ex01;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

// 웹 애플리케이션이 시작되거나 종료되는 상황일 때 실행되는 리스너 만들기 
@WebListener
public class Listener01 implements ServletContextListener{
    
    public Listener01() {
        System.out.println("Listener01() 생성생성생성자 호출됨");
    }
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // 웹 애플리케이션이 시작될 때 이 메서드가 호출된다.
        // 서블릿들이 공통으로 사용하는 자원은 이 메서드에서 준비한다.
        // 공통으로 사용하는 자원은 이 메서드에서 준비한다.
        // 예를 들면, IoC 컨테이너, DAO, DB 커넥션 등
        System.out.println("Listener01.contextInitialized() 호출데찌롱");
    }
    
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // 웹 애플리케이션이 종료될 때 이 메서드가 호출된다.
        // contextInitialized()에서 준비했던 자원을 해제시킨다.
        System.out.println("Listener01.contextDestroyed()로 종료시켰지롱");
    }
}
