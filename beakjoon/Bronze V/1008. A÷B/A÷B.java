import java.util.Scanner;

class _05_A나누기B {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	// 오차 범위를 벗어나지 않게 하기 위해서는 반드시 double형으로 출력을 해주어야 한다.
	double A, B;
	A = in.nextInt();
	B = in.nextInt();
	in.close();
	System.out.println(A / B);
    }
}
