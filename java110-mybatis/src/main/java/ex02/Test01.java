// 주제 : Factory method 및 builder 디자인 패턴 적용
package ex02;

import java.util.List;

public class Test01 {
    public static void main(String[] args) throws Exception {
        // 1 mybatis 설정 파일 경로
//        String resource = "ex02/mybatis/example/mybatis-config.xml";
        
        // 2 설정파일을 읽을 InputStream 준비
        //   => 자바 classpath에서 설정 파일을 찾는다.
//        InputStream inputStream = Resources.getResourceAsStream(resource);
        
        // 3 SqlSession 객체를 생성해 줄 팩토리 객체를 준비
        //   => mybatis 설정 파일에 정의된 대로 객체를 준비한다.
        /*SqlSessionFactory sqlSessionFactory =
          new SqlSessionFactoryBuilder().build(inputStream);*/
        
        MemberDaoFactory factory = new DaoBuilder().build();
        
        MemberDao memberDao = factory.createMemberDao();
        
        List<Member> list = memberDao.findAll();
        
        for(Member m : list) {
            System.out.printf("%d, %s, %s, %s\n"
                            ,m.getNo()
                            ,m.getName()
                            ,m.getEmail()
                            ,m.getTel());
        }
    }

}
