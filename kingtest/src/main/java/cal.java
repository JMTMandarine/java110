import java.util.Scanner;

public class cal {    
    public static void main(String[] args) {
        
        int su1;
        int su2;
        String cal; 
        
        Scanner in=new Scanner(System.in);
        
        System.out.println("첫번째 수!");
        su1=Integer.parseInt(in.nextLine());
        System.out.println("계산식을 선택하세요 (+ - * /)");
        cal=in.nextLine();
        System.out.println("두번째 수!");
        su2=Integer.parseInt(in.nextLine());
        
        if(cal.equals("+"))
        {
            System.out.println(su1+su2);
        }else if(cal.equals("-")) {
            System.out.println(su1-su2);
        }else if(cal.equals("*")) {
            System.out.println(su1*su2);
        }else if(cal.equals("/")) {
            System.out.println(su1/su2);
        };
        
        
        
    }

}
