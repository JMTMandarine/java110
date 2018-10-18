// 인스턴스 비교 4 : equals()와 hashCode() 자동 생성하기
//
package ex05;

import java.util.HashSet;

public class Test02_p4 {

    static class Member{ // 기본으로 Object를 상속받음
        String name;
        int age;
        public Member(String name, int age) {
            this.name=name;
            this.age=age;
        }

        @Override
        public String toString() {
            return "Member [name=" + name + ", age=" + age + "]";
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + age;
            result = prime * result + ((name == null) ? 0 : name.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Member other = (Member) obj;
            if (age != other.age)
                return false;
            if (name == null) {
                if (other.name != null)
                    return false;
            } else if (!name.equals(other.name))
                return false;
            return true;
        }
        
    }
    public static void main(String[] args) {
        Member obj1 = new Member("홍길동", 20);
        Member obj2 = new Member("홍길동", 20);

        if(obj1==obj2) {
            System.out.println("같다");
        }else {
            System.out.println("다르디");
        }


        HashSet<Member> set2 = new HashSet<>();
        set2.add(obj1);
        set2.add(obj2);

        System.out.println("=========================");
        for (Member m: set2) {
            System.out.println(m);
        }
        System.out.println("=========================");
    }        

}
