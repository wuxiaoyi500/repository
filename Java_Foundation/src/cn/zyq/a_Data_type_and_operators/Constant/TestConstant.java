package cn.zyq.a_Data_type_and_operators.Constant;
/**
 * 测试常量
 * */
public class TestConstant {

	public static void main(String[] args) {
		final double PI=3.1415926;
//		PI=3.15;   错误，常量不能再修改
		double r=4;
		double area=PI*r*r;
		double cycle=2*PI*r;
		System.out.println(area);
		System.out.println(cycle);
	}
}
