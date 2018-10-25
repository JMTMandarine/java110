package ex02;

import java.sql.Date;
import java.util.Arrays;

public class Car {
    int no;
    String model;
    String maker;
    boolean auto;
    Date createDate;
    Tire[] tires;
    String[] musics;
    Engine engine;
    
    
    
    public int getNo() {
        return no;
    }
    public void setNo(int no) {
        this.no = no;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getMaker() {
        return maker;
    }
    public void setMaker(String maker) {
        this.maker = maker;
    }
    public boolean isAuto() {
        return auto;
    }
    public void setAuto(boolean auto) {
        this.auto = auto;
    }
    public Engine getEngine() {
        return engine;
    }
    public void setEngine(Engine engine) {
        this.engine = engine;
    }
    public Date getCreateDate() {
        return createDate;
    }
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    public Tire[] getTires() {
        return tires;
    }
    public void setTires(Tire[] tires) {
        this.tires = tires;
    }
    public String[] getMusics() {
        return musics;
    }
    public void setMusics(String[] musics) {
        this.musics = musics;
    }
    
    @Override
    public String toString() {
        return "Car [no=" + no + ", model=" + model + ", maker=" + maker + ", auto=" + auto + ", createDate="
                + createDate + ", tires=" + Arrays.toString(tires) + ", musics=" + Arrays.toString(musics) + ", engine="
                + engine + "]";
    }
  
    
    
    
    
}
