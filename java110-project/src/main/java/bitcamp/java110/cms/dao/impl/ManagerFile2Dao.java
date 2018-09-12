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
import bitcamp.java110.cms.dao.DuplicationDaoException;
import bitcamp.java110.cms.dao.ManagerDao;
import bitcamp.java110.cms.dao.MandatoryValueDaoException;
import bitcamp.java110.cms.domain.Manager;

@Component
public class ManagerFile2Dao implements ManagerDao{
    static String defaultFilename ="data/manager2.dat";
    String filename;
    private List<Manager> list=new ArrayList<>();
    
    @SuppressWarnings("unchecked")
    public ManagerFile2Dao(String filename) {
        this.filename=filename;
        File dataFile = new File(filename);
        try(    FileInputStream in0= new FileInputStream(dataFile);
                BufferedInputStream in1=new BufferedInputStream(in0);
                ObjectInputStream in=new ObjectInputStream(in1);
                ){
            list = (List<Manager>)in.readObject();
            /*while(true) {
                try {
                    Manager m = (Manager)in.readObject();
                    list.add(m);
                }catch(Exception e) {
                    break;
                }
            }*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ManagerFile2Dao() { //생성자에서 다른 생성자를 생성함 (항상 첫번째로 호출해야함)
        this(defaultFilename);
    }
    
    public void save() {
        File dataFile=new File(filename);
        try(
                FileOutputStream out0= new FileOutputStream(dataFile);
                BufferedOutputStream out1 = new BufferedOutputStream(out0);
                ObjectOutputStream out = new ObjectOutputStream(out1);){
//            for (Manager m : list) {
                out.writeObject(list);
//            }
            out.flush();
        }catch (Exception e) {e.printStackTrace();}
        
        
    }
    
    public int insert(Manager manager) {
        //예외처리 문법이 없던 시절에는 리턴값으로 예외 상황을 호출자에게 알렸다.
        if(manager.getName().length()==0||
           manager.getEmail().length()==0||
           manager.getPassword().length()==0) {
            // 호출자에게 예외 정보를 만들어 던짐
            throw new MandatoryValueDaoException();
        }
        for(Manager item: list) {
            if(item.getEmail().equals(manager.getEmail())){
                // 호출자에게 예외 정보를 만들어 던짐
                throw new DuplicationDaoException();
            }
        }
        list.add(manager);
        save();
        return 1;
    }
    
    public List<Manager> findAll() {
        return list;
    }
    
    public Manager findByEmail(String email) {
        for(Manager item: list) {
            if(item.getEmail().equals(email)){
                return item;
            }
        }
        return null;
    }
    
    public int delete(String email) {
        for(Manager item: list) {
            if(item.getEmail().equals(email)){
                list.remove(item);
                save();
                return 1;
            }
        }
        return 0;
    }

}
