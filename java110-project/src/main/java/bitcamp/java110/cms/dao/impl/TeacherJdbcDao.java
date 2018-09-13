package bitcamp.java110.cms.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import bitcamp.java110.cms.annotaion.Component;
import bitcamp.java110.cms.dao.TeacherDao;
import bitcamp.java110.cms.domain.Teacher;

@Component
public class TeacherJdbcDao implements TeacherDao{
    
    public int insert(Teacher teacher) {
        
        Connection con=null;
        Statement stmt=null;
        ResultSet autogeneratedKeys=null;
        
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");
            
            con.setAutoCommit(false);
            
            stmt=con.createStatement();
            String sql=" insert into p1_memb(name,email,pwd,tel,cdt)"
                     + " values('"+teacher.getName()+"' "
                     + " , '"+teacher.getEmail()+"'     "
                     + " , '"+teacher.getPassword()+"   "
                     + " , '"+teacher.getTel()+"'       "
                     + " ,now() )                       ";
            
            stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            
            autogeneratedKeys=stmt.getGeneratedKeys();
            autogeneratedKeys.next();
            int memberNo=autogeneratedKeys.getInt(1);
            
             
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public List<Teacher> findAll() {
    }
    
    public Teacher findByEmail(String email) {
    }
    
    public int delete(String email) {
    }

}
