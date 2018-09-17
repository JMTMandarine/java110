package practice;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int[] won= {500,100,50};
		int tot= 0;
		
		System.out.println("<< 동전계산 프로그램! >>");
		
		System.out.println("1. 오백원 수 :");
		int su1=Integer.parseInt(in.nextLine());
		
		System.out.println("2. 백원 수 :");
		int su2=Integer.parseInt(in.nextLine());
	
		System.out.println("3. 오십원 수 :");
		int su3=Integer.parseInt(in.nextLine());
		
		int sum=(won[0]*su1)+(won[1]*su2)+(won[2]*su3);
		System.out.println("총금액 : "+sum+"원");
	}
}
