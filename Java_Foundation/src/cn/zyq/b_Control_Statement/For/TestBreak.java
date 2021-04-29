package cn.zyq.b_Control_Statement.For;
/**
 * 测试break和continue
 * */
public class TestBreak {

	public static void main(String[] args) {

		//break
		int total=0;
		System.out.println("Begin");
		while(true) {
			total++;
			int i=(int)Math.round(100*Math.random());
			if(i==88) {
				break;
			}
		}
		System.out.println("Game over,used "+total+" times");

		//continue
		int count=0;
		for(int i=0;i<=150;i++) {
			if(i%3==0) {
				continue;
			}
			System.out.print(i+"、");
			count++;
			if(count%5==0) {
				System.out.println();
			}
		}
	}
}
