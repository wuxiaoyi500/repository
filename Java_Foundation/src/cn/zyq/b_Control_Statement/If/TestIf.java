package cn.zyq.b_Control_Statement.If;
/**
 * 测试选择语句
 * */
public class TestIf {

	public static void main(String[] args) {
		//单选择
		int j=(int)(6*Math.random())+1;
		int d=(int)(6*Math.random())+1;
		int k=(int)(6*Math.random())+1;
		int count=j+d+k;

		if(count>15) {
			System.out.println("今天运气非常好，得了"+count+"分");
		}
		if(count<=15&&count>=10) {
			System.out.println("今天运气还不错，得了"+count+"分");
		}
		if(count<10) {
			System.out.println("今天运气不咋滴，得了"+count+"分");
		}
		System.out.println("-------------------");
		//if-else 双选择
		double r =4*Math.random();
		double area=Math.PI*Math.pow(r, 2);
		double cycle=2*Math.PI*r;

		if(area>cycle) {
			System.out.println("面积大于周长");
		}else {
			System.out.println("周长大于面积");
		}
		//条件运算符
		int a=3;
		int b=4;
		System.out.println((a>b)?a:b);
		//用if-else代替条件运算符（三元运算符）
		if(a>b) {
			System.out.println(a);
		}else {
			System.out.println(b);
		}

		System.out.println("-------------------");
		//if-else 多选择结构
		int age=(int)(100*Math.random());
		if(age<15) {
			System.out.println("儿童，贪玩");
		}else if(age<25) {
			System.out.println("青年，爱学习");
		}else if(age<45) {
			System.out.println("中年，爱工作");
		}else if(age<65) {
			System.out.println("中老年，爱养生");
		}else if(age<85) {
			System.out.println("老年，爱运动");
		}else {
			System.out.println("老寿星，古来稀");
		}
	}
}
