package cn.zyq.b_Control_Statement.While;
/**
 * while 先判断再执行
 * do-while 先执行再判断
 * */
public class TestWhile {

	public static void main(String[] args) {
		int i=0;
		int sum=0;
		//测试while
		while(i<=100) {
			sum+=i++;
		}
		System.out.println("Sum="+sum);

		//测试do-while
		int i1=0;
		int sum1=0;
		do {
			sum1+=i1++;
		}while(i1<=100);
		System.out.println("Sum1="+sum1);
	}
}