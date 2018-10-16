// 주제 : Mybatis - 1:다 관계의 데이터를 한번에 가져오기
package ex04;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test04_1 {
    public static void main(String[] args) throws Exception {
        String resource = "ex04/mybatis-config-04.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
          new SqlSessionFactoryBuilder().build(inputStream);
        
        MemberDao memberDao = new MemberDao();
        memberDao.setSqlSessionFactory(sqlSessionFactory);
        
        // 페이징 처리
        int pageNo=1;
        int pageSize = 100;
        
        HashMap<String,Object> params= new HashMap<>();
        params.put("rowNo", (pageNo-1)*pageSize);
        params.put("pageSize", pageSize);
        // 검색어로 데이터 찾기 (where절 설정)
        // <where> 태그를 사용하면 편리하다.
        // where절에 문장이 없으면 where절을 따로 만들지 않는다.
        // where절에 조건을 추가할때 or, and로 시작하면 자동으로 제거한다.
        // => 예를 들어 nameValue값을 지정하지 않으면,
        //    where절을 만들 때 다음과 같이 만들어질 수 있다.
        //      where or email like 'user%'
        //    그러나, <where>태그를 사용하면 자동으로 or키워드를 제거한다.
        //params.put("nameValue", "m%");
        params.put("emailValue", "user%");
        
        List<Member> list = memberDao.findAll(params);
        
        for(Member m : list) {
            System.out.printf("%d, %s, %s, %s\n"
                            ,m.getNo()
                            ,m.getName()
                            ,m.getEmail()
                            ,m.getTel());
        }
    }

}
