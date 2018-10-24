package ex01;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MyWebApplicationInitializer 
    /*implements WebApplicationInitializer */{

    /*@Override*/
    public void onStartup(ServletContext servletContext) throws ServletException {
        System.out.println("MyWebApplicationInitializer3");
        
        // 프론트 컨트롤러가 사용할 IoC 컨테이너 준비
        AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
        ac.register(AppConfig.class);
        //ac.refresh();
        
        // 프론트 컨트롤러(DispatcherServlet)를 웹 애플리케이션에 등록하기
        // => 프론트 컨트롤러 객체를 만들 때 생성자에 위에서 만든 IoC 컨테이너는 넘긴다.
        DispatcherServlet servlet = new DispatcherServlet(ac);
        
        // 서블릿 컨테이너의 서블릿 등록기를 통해 위에서 만든
        // 프론트 컨트롤러 객체를 등록한다.
        ServletRegistration.Dynamic registration = 
                servletContext.addServlet("app", servlet);
        // 해당 서블릿의 옵션을 설정한다.
        registration.setLoadOnStartup(1);
        
        
        // 해당 서블릿의 URL을 연결한다.
        registration.addMapping("/app/*");
        
        //web-03에 등록하는 것 비교 참고해서 볼것!
    }

}
