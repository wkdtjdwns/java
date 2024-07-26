import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int sum = l + r + b;
        int temp = b - Math.abs(l - r);

        System.out.println(temp >= 0 ? sum - temp % 2 : sum - Math.abs(temp));
    }
}
