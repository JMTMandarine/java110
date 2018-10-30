package bitcamp.java110.cms.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class AuthInterceptor implements HandlerInterceptor{
    
    @Override
    public boolean preHandle(
            HttpServletRequest request, 
            HttpServletResponse response, 
            Object handler) throws Exception {
        
        System.out.println("AuthInterceptor.preHandle()....");
        
        HttpSession session = request.getSession(); // 로그인했는지 정보얻기
        if(session.getAttribute("loginUser") == null) {
            response.sendRedirect("/app/auth/form"); // web브라우저 입장에서 경로
            return false; // 페이지 컨트롤러의 request handler를 실행하지 말라!
        }
        
        return true;
    }
}
