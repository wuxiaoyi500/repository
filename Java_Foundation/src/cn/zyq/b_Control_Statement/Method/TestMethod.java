package cn.zyq.b_Control_Statement.Method;
/**
 * 测试方法
 * */
public class TestMethod {

	public static void main(String[] args) {
		int num1=10;
		int num2=20;
		int sum=add(num1,num2);
		System.out.println("sum="+sum);
		print();
	}
	public static int add(int i,int j) {
		int sum=i+j;
		return sum;
	}
	public static void print() {
		System.out.println("武汉加油！！！");
	}
}