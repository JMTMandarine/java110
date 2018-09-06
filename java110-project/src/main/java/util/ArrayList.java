package util;

public class ArrayList<T> {
    
    //개별적으로 관리해야할 값이라면 인스턴스변수로 선언
    private Object[] list=new Object[100];
    private int index = 0;
    
    public void add(T obj) {
            
            if(index == list.length) {
                increaseStorage();
            }
            list[index++] = obj;
            
    }
    
    private void increaseStorage() {
        Object[] newList = new Object[list.length+3];
        for(int i=0; i<list.length; i++) {
            newList[i]=list[i];
        }
        list = newList;
    }
    
    public void remove(int no) {
        if(no < 0|| no >= index) {
            System.out.println("잘못된 번호입니다.");
            return;
        }
        
        for(int i=no; i<index-1; i++){
            list[i] = list[i+1];
        }
        index--;
    }
    
    public int size() {
        return this.index;
    }
    
    @SuppressWarnings("unchecked")
    public T get(int no) {
        if(no<0||no>=index) {
            System.out.println("잘못된 번호입니다.");
            return null;
        }
        return (T)list[no];
    }
    
    
    
}
