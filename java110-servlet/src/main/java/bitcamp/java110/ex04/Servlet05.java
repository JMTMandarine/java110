/* 클라이언트가 보낸 데이터 읽기 - POST 요청으로 보낸 한글이 깨지는 문제해결 
 * 
*/
package bitcamp.java110.ex04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/ex04/servlet05")
public class Servlet05 extends  GenericServlet{

    private static final long serialVersionUID = 1L;
    
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        
        // 테스트 :
        // => http://localhost:8888/ex04/post2.htmlㅍ 페이지에서 값을 입력한 후 보내기 버튼 클릭
        
        // 클라이언트가 보낸데이터가 어떤 문자표에 따라 인코딩했는지 명시해줌 
        // (안하면 한글깨짐 because, 기본 ISO-8859-1로 인코딩 되기때문)
        // 주의! 
        // 서블릿 앞에 필터를 꼽았고, 
        // 그 필터에서 getParameter()를 호출한 경우,
        // setCharacterEncoding를 호출해봐야 소용없다.
       
        req.setCharacterEncoding("UTF-8"); //반드시 getParameter 전에 선언해야함
        
        
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        boolean working = Boolean.parseBoolean(req.getParameter("working"));
        
        res.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = res.getWriter();
        out.printf("name=%s\n", name);
        out.printf("age=%s\n", age);
        out.printf("working=%s\n", working);

    }



    
}





//POST 요청
//=> POST 요청으로 값을 보내기 위
/*
POST /ex04/servlet02 HTTP/1.1
Host: localhost:8888
Connection: keep-alive
Content-Length: 52
Pragma: no-cache
Cache-Control: no-cache
Origin: http://localhost:8888
Upgrade-Insecure-Requests: 1
Content-Type: application/x-www-form-urlencoded
User-Agent: Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,....
Referer: http://localhost:8888/ex04/form.html
Accept-Encoding: gzip, deflate, br
Accept-Language: ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7
Cookie: JSESSIONID=CB0DB4B4E1221299ADBCC85EF601241D

name=%ED%95%A0%EB%9E%84%EB%9D%BC&age=45&working=true
*/


//POST요청의 특징 
//- message-body 영역에 데이터를 포함
// => URL에 데이터가 포함되어 있지 않기때문에 즐겨찾기에 추가해 봐야 소용 없다
// => 즐겨 찾기에는 URL만 저장 되기 때문에 데이터가 포함 되지 않은 URL을 저장해 봐야 소용없다
// => 데이터 조회 화면을 요청 할 때는 POST방식을 사용 하지 않는다
//- 보안 
// => URL에 데이터가 포함되어 있지 않기 때문에 
//    데이터가 노출 되지 말아야 할 경우 (예를 들면  로그인, 회원가입 등 ) 적합
//
//- 대용량 데이터
// => 대부분의 웹서버는 request-uri 또는 헤더를 포함한 메타 데이터 크기를  8KB 미만으로 설정하고 있다.
//   그러나 message-body 영역은 제한을 두지 않거나 큰 용량을 허락하고 있다.
// => 그래서 대용량 데이터를 보낼 때는 POST 방식을 사용한다.
//-바이너리 데이터 전송
// => message-body부분에 첨부하기 때문에 바이너리 데이터를 전송할 수 있다.
//  단, 멀티파트 형식으로 보낸다.
//
//-적용부분
// => 로그인 회원가입 처럼 데이터가 캐시에 보관되거나 노출되지 말아야 하는 경우
// => 게시글 등록/변경 처럼 대용량의 데이터를 전송해야 하는 경우
// => 파일 업로드 처럼 바이너리 데이터를 전송해야 하는 경우
