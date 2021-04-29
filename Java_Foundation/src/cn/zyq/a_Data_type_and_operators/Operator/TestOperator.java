package cn.zyq.a_Data_type_and_operators.Operator;
/**
 *    +，-，*，/，%属于二元运算符
 *         二元运算符指的是需要两个操作数才能完成运算的运算符。
 *         算术运算符中++，--属于一元运算符，该类运算符只需要一个操作数。
 * */

public class TestOperator {

	public static void main(String[] args) {
		//测试一元二元运算符
		int a=3;
		int b=a++;//先赋值，再自增，执行完后b==3;
		System.out.println("a="+a+"\nb="+b);
		a=3;
		b=++a;//先自增再赋值，执行完后b=4;a=4;
		System.out.println("a="+a+"\nb="+b);

		//测试与和逻辑与
		//1>2的结果为false，那么整个表达式的结果即为false，将不再计算2>(3/0)
		boolean c = 1>2 && 2>(3/0);
		System.out.println(c);
		//1>2的结果为false，那么整个表达式的结果即为false，还要计算2>(3/0)，0不能做除数，//会输出异常信息
		boolean d = 1>2 & 2>(3/0);
		System.out.println(d);

		//测试位运算符
		int e=3;
		System.out.println(e);
	}
}
