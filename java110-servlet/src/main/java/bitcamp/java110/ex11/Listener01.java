// 세션 생성, 소멸 모니터링하기
package bitcamp.java110.ex11;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class Listener01 implements HttpSessionListener {
    
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        // 세션이 생성되면 이 메서드가 호출된다.
        System.out.printf("ex11.Listener01.sessionCreated()세션 생성:%s\n"
                ,se.getSession().getId());
        
    }
    
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        // 세션이 소멸되면 이 메서드가 호출된다.
        System.out.printf("ex11.Listener01.sessionDestroyed()세션 소멸:%s\n"
                ,se.getSession().getId());
    }

}
