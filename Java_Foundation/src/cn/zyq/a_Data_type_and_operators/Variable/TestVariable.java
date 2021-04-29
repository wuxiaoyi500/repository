package cn.zyq.a_Data_type_and_operators.Variable;
/**
 * 测试变量
 * */
public class TestVariable {

	int a;//成员变量/实例变量，从属于对象，成员变量会被自动初始化
	static int z;//静态变量，从属于类
	public static void main(String[] args) {
		{
			int age =18;//局部变量，从属于语句块，局部变量必须先声明，初始化，再使用
		}
		double number=3.1415926;//局部变量，从属于方法
		System.out.println(number);

		int i;
//		int j=i+8;  编译出错，i还未被初始化

	}
}