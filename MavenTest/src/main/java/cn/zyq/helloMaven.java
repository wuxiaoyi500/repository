package cn.zyq;

public class helloMaven {
    public static int addNumber(int n1,int n2) {
        return n1+n2;
    }
    public static void main(String args[]){
        helloMaven hm = new helloMaven();
        int result = hm.addNumber(10, 20);
        System.out.println(result   );
    }

}
