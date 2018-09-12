package bitcamp.java110.cms.dao.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import bitcamp.java110.cms.annotaion.Component;
import bitcamp.java110.cms.dao.TeacherDao;
import bitcamp.java110.cms.domain.Teacher;

@Component
public class TeacherFile2Dao implements TeacherDao{
    static String defaultFilename="data/teacher2.dat";
    String filename;
    private List<Teacher> list=new ArrayList<>();
    
    @SuppressWarnings("unchecked")
    public TeacherFile2Dao(String filename) {
        this.filename=filename;
        File dataFile=new File(filename);
        try (FileInputStream in2=new FileInputStream(dataFile);
             BufferedInputStream in1=new BufferedInputStream(in2);
             ObjectInputStream in=new ObjectInputStream(in1);
                ){
            list=(List<Teacher>)in.readObject();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public TeacherFile2Dao() {
        this(defaultFilename);
    }
    
    private void save() {
        File dataFile=new File(filename);
        
        try (FileOutputStream out2=new FileOutputStream(dataFile);
                BufferedOutputStream out1=new BufferedOutputStream(out2);
                ObjectOutputStream out=new ObjectOutputStream(out1)){
            out.writeObject(list);
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