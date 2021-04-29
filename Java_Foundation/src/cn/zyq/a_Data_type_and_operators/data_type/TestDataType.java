package cn.zyq.a_Data_type_and_operators.data_type;

import java.math.BigDecimal;

public class TestDataType {

	public static void main(String[] args) {
		//整型数据类型
		long a=55555;//编译成功，在int表示的范围内(21亿内)。
//		long b=55555555555;   不加L编译错误，已经超过int表示的范围。
		long b=55555555555L;

		//浮点型数据类型
		double f1 = 314e2;  //314*10^2-->31400.0
		double f2 = 314e-2; //314*10^(-2)-->3.14

		//浮点型数据类型的比较一：
		float f = 0.1f;
		double d = 1.0/10;
		System.out.println(f==d);//结果为false

		//浮点型数据类型的比较二：
		float d1 = 423432423f;
		float d2 = d1+1;
		if(d1==d2){
			System.out.println("d1==d2");//输出结果为d1==d2
		}else{
			System.out.println("d1!=d2");
		}
		/*运行以上两个示例，发现结果是“false”“d1==d2”。这是因为由于字长有限，浮点数能够精确表示的数是有限的，因而也是离散的。
		 *  浮点数一般都存在舍入误差，很多数字无法精确表示(例如0.1)， 其结果只能是接近， 但不等于。
		 *  二进制浮点数不能精确的表示0.1、0.01、0.001这样10的负次幂。并不是所有的小数都能可以精确的用二进制浮点数表示。*/

		//使用BigDecimal进行浮点数的比较
		BigDecimal bd = BigDecimal.valueOf(1.0);
		bd = bd.subtract(BigDecimal.valueOf(0.1));
		bd = bd.subtract(BigDecimal.valueOf(0.1));
		bd = bd.subtract(BigDecimal.valueOf(0.1));
		bd = bd.subtract(BigDecimal.valueOf(0.1));
		bd = bd.subtract(BigDecimal.valueOf(0.1));
		System.out.println(bd);//0.5
		System.out.println(1.0 - 0.1 - 0.1 - 0.1 - 0.1 - 0.1);//0.5000000000000001
		System.out.println("-------------------------------------");

		System.out.println(0.2 + 0.1);
		System.out.println(0.3 - 0.1);
		System.out.println(0.2 * 0.1);
		System.out.println(0.3 / 0.1);

		System.out.println("-------------------------------------");

		//测试字符类型
		char e='Z';
		char g='曾';
		char h='\u0061';
		System.out.println(h);

		//转义字符
		System.out.println(""+e+'\n'+g);
		System.out.println(""+g+'\t'+h);
		System.out.println(""+g+'\b'+h);
		System.out.println(""+g+'\r'+h);
		System.out.println(""+g+'\"'+h);
		System.out.println(""+g+'\\'+h);

		String s="abc";//String 就是字符序列
	}
}

