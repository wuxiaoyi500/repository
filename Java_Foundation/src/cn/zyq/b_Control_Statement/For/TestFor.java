package cn.zyq.b_Control_Statement.For;
/**
 * 测试for循环
 * */
public class TestFor {

	public static void main(String[] args) {
		int sum=0;
		//1.求1-100之间的累加和
		for(int i=0;i<=100;i++) {
			sum+=i;
		}
		System.out.println("sum="+sum);

		//2.循环输出9-1之间的数
		for(int i=9;i>0;i--) {
			System.out.print(i+"、");
		}
		System.out.println();
		//3.输出90-1之间能被3整除的数
		for(int i=0;i<=90;i+=3) {
			System.out.print(i+"、");
		}
		System.out.println();

		//嵌套循环
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=5;j++) {
				System.out.print(i+"、");
			}
			System.out.println();
		}

		//用嵌套循环写99乘法表
		for(int i=1;i<=9;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print(j+"*"+i+"="+i*j+"    ");
			}
			System.out.println();
		}
	}
}
