package bitcamp.java110.cms.dao;

import java.util.List;

import bitcamp.java110.cms.annotaion.Component;
import bitcamp.java110.cms.domain.Manager;

@Component
public interface ManagerDao {
    
    int insert(Manager manager); 
    List<Manager> findAll();
    Manager findByEmail(String email); 
    int delete(String email);

}
