// 리스너 만들기
// - 리스너(listener)란? 특정 상황에 놓이면 실행되는 객체
// - javax.servlet.XxxListener
// 

package bitcamp.java110.ex01;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

// 클라이언트로부터 요청이 들어오면 실행되는 리스너
//@WebListener
public class Listener02 implements ServletRequestListener{
    
    public Listener02() {
        System.out.println("Listener02() 생성생성생성자 호출됨");
    }
    
    
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        // 클라이언트 요청이 들어왔을 때 호출된다.
        // 예를 들면, 클라이언트의 IP주소를 기록할 수 있다.
        System.out.println("Listener02.requestInitialized() 호출데찌롱");
        HttpServletRequest httpRequest= (HttpServletRequest)sre.getServletRequest();
        System.out.printf("IP:%s\n",httpRequest.getRemoteAddr());
        System.out.printf("PATH:%s\n",httpRequest.getServletPath());
    }
    
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        // 클라이언트에게 요청을 응답했을때 호출된다.
        System.out.println("Listener02.requestDestroyed()로 종료시켰지롱");
    }
}
