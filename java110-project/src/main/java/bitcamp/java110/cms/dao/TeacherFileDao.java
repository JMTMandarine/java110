package bitcamp.java110.cms.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import bitcamp.java110.cms.annotaion.Component;
import bitcamp.java110.cms.domain.Teacher;

@Component
public class TeacherFileDao implements TeacherDao{
    private List<Teacher> list=new ArrayList<>();
    
    public TeacherFileDao() {
        File file=new File("data/teacher.dat");
        try (BufferedReader in=new BufferedReader(new FileReader(file))){
           
            while(true) {
                String line = in.readLine();
                if(line==null) break;
                String[] values=line.split(",");
                Teacher t = new Teacher();
                    t.setName(values[0]);
                    t.setEmail(values[1]);
                    t.setPassword(values[2]);
                    t.setPay(Integer.parseInt(values[3]));
                    t.setSubjects(values[4]);
                    t.setTel(values[5]);
                    
                    list.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void save() {
        File file=new File("data/teacher.dat");
        
        try (BufferedWriter out=new BufferedWriter(new FileWriter(file))){
            for(Teacher t : list) {
                out.write(String.format("%s,%s,%s,%d,%s,%s\n"
                        ,t.getName()
                        ,t.getEmail()
                        ,t.getPassword()
                        ,t.getPay()
                        ,t.getSubjects()
                        ,t.getTel()));
            }
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public int insert(Teacher teacher) {
        for(Teacher item: list) {
            if(item.getEmail().equals(teacher.getEmail())){
                return 0; // 걍 멈추지않고 값을준다? 에헤
            }
        }
        list.add(teacher);
        save();
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
                save();
                return 1;
            }
        }
        return 0;
    }

}
