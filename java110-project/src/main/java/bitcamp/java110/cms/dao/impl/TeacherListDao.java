package bitcamp.java110.cms.dao.impl;

import java.util.ArrayList;
import java.util.List;

import bitcamp.java110.cms.domain.Teacher;

public class TeacherListDao {
    private List<Teacher> list=new ArrayList<>();
    
    
    public int insert(Teacher teacher) {
        for(Teacher item: list) {
            if(item.getEmail().equals(teacher.getEmail())){
                return 0; // 걍 멈추지않고 값을준다? 에헤
            }
        }
        list.add(teacher);
        return 1;
    }
    
    public List<Teacher> findAll() {
        return list;
    }
    
    public Teacher findByEmail(String email) {
        for(Teacher item: list) {
            if(item.getEmail().equals(email)){
                return item;
            }
        }
        return null;
    }
    
    public int delete(String email) {
        for(Teacher item: list) {
            if(item.getEmail().equals(email)){
                list.remove(item);
                return 1;
            }
        }
        return 0;
    }

}
