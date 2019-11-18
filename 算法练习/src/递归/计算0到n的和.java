package 递归;

public class 计算0到n的和 {
    public static void main(String[] args) {
        System.out.println(sum(555));
    }

    public static int sum(int n){
        return n<=0? 0:n+sum(n-1);
    }
}
