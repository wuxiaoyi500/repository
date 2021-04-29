package cn.zyq.a_Data_type_and_operators.data_type;

import java.util.Scanner;

/**
 * 测试键盘输入
 * */
public class TestScanner {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入你的名字：");
		String name=scanner.nextLine();
		System.out.println("请输入你的年龄：");
		String age =scanner.nextLine();
		System.out.println("请输入你的爱好：");
		String favorite=scanner.nextLine();

		System.out.println("----------------");
		System.out.println(name+age+favorite);
	}
}
