// 인스턴스 비교 1 : equals() overriding 전
//
package ex05;

public class Test02_p1 {
    
    static class Member{ // 기본으로 Object를 상속받음
        String name;
        int age;
        public Member(String name, int age) {
            this.name=name;
            this.age=age;
        }
    }
    public static void main(String[] args) {
        Member obj1 = new Member("홍길동", 20);
        Member obj2 = new Member("홍길동", 20);


        //인스턴스 비교
        // 1) == 연산자는 레퍼런스에 저장된 인스턴스의 주소를 비교한다.
        if(obj1==obj2) {
            System.out.println("같다");
        }else {
            System.out.println("다르디");
        }
        // 2) Object에서 상속받은 equals() 메서드는 == 연산자와 같다
        if(obj1.equals(obj2)) {
            System.out.println("같다");
        }else {
            System.out.println("다르디");
        }
    }        

}
