package bitcamp.java110.cms.dao;

import java.util.ArrayList;
import java.util.List;

import bitcamp.java110.cms.domain.People;

public class PeopleDao {
    List<People> list=new ArrayList<>();
    
    public int insert(People people) {
        for(People item :list)
        {
            if(item.getEmail().equals(people.getEmail()))
                    {
                System.out.println("해당 이메일이 이미 존재합니다.");
                return 0;
            }
        }
        list.add(people);
        System.out.println("정보가 추가되었습니다.");
        return 1;
    }
    
    
    public int delete(People people) {
        for(People item:list) {
            if(item.getEmail().equals(people.getEmail()))
            {
                list.remove(item);
                return 1;
            }
        }
        System.out.println("해당 이메일의 회원을 찾을 수 없습니다.");
        return 0;
    }
}
