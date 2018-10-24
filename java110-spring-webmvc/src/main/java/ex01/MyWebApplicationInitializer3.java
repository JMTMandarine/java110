package ex01;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class MyWebApplicationInitializer3 
    /*implements WebApplicationInitializer */{

    
    public void onStartup(ServletContext servletContext) throws ServletException {
        // 구동 원리:
        // 1) 서블릿 컨테이너(예: 톰캣 서버)를 실행한다.
        // 2) 각각의 웹 애플리케이셔의 /WEB-INF/lib 폴더에 있는 .jar 파일을 로딩한다.
        // 3) 각 jar 파일에 대해 다음을 수행한다.
        //    => /META-INF/services 폴더를 찾는다.
        //    => 다음 이름을 갖는 파일이 있는지 확인한다.
        //
        //       javax.servlet.ServletContainerInitializer
        //
        //    => 해당 이름을 갖는 파일이 있다면, 
        //       그 파일에 등록된 클래스를 찾아 실행한다.
        //       
        // 
        // 4) ServletContainerInitializer를 실행하는 과정
        //    => spring-web-xxx.jar 파일에 해당 구현체가 있다.
        //    => org.springframework.web.SpringServletContainerInitailizer
        //    => 서블릿 컨테이너는 웹 어플리케이션을 시작할 때
        //       이 클래스에 대해 다음 메서드를 호출한다.
        //
        //      onStartup(Set<Class<?>> c, ServletContext ctx)
        //
        //    => 이 메서드의 첫번째 파라미터로 받는 것은 
        //       SpringServletContainerInitailizer클래스 위에 선언한
        //       @HandlesTypes 애노테이션에 지정된
        //       지정된 WebApplicationInitializer.class의 구현체 목록이다.
        //    => 즉 WebApplicationInitializer를 구현한 클래스를 모두 찾아
        //       그 클래스 정보를 목록에 담아 준다.
        //    => 그러면 SpringServletContainerInitailizer의 onStart()에서는
        //       목록에 등록된 클래스의 객체를 한 개씩 만들고,
        //       그 객체에 대해 onStartup()을 호출한다.
        //    => 즉, 지금 여기에서 만드는 MyWebApplicationInitializer
        //       객체를 만들고 onStartup()을 호출한다.
        //
        System.out.println("MyWebApplicationInitializer");
        
    }

    
}
