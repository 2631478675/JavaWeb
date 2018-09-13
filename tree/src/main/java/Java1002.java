import java.util.Scanner;
import java.util.Stack;

/**
 * 1002 写出这个数（20 point(s)）
 * 读入一个正整数 n，计算其各位数字之和，用汉语拼音写出和的每一位数字。
 *
 * 输入格式：
 * 每个测试输入包含 1 个测试用例，即给出自然数 n 的值。这里保证 n 小于 10
 * ​100
 * ​​ 。
 *
 * 输出格式：
 * 在一行内输出 n 的各位数字之和的每一位，拼音数字间有 1 空格，但一行中最后一个拼音数字后没有空格。
 *
 * 输入样例：
 * 1234567890987654321123456789
 * 输出样例：
 * yi san wu
 */
public class Java1002 {
    public static void main(String[] args){
        //输入数字
        Scanner scanner = new Scanner(System.in);
        String n = scanner.nextLine();
        scanner.close();

        int sum = 0;
        for(int i=0;i<n.length();i++){
            sum += n.charAt(i) - '0';
        }

        Stack<String> stack = new Stack<>();
        do{
            int unit = sum%10;
            switch (unit){
                case 0:
                    stack.push("ling");
                    break;
                case 1:
                    stack.push("yi");
                    break;
                case 2:
                    stack.push("er");
                    break;
                case 3:
                    stack.push("san");
                    break;
                case 4:
                    stack.push("si");
                    break;
                case 5:
                    stack.push("wu");
                    break;
                case 6:
                    stack.push("liu");
                    break;
                case 7:
                    stack.push("qi");
                    break;
                case 8:
                    stack.push("ba");
                    break;
                case 9:
                    stack.push("jiu");
                    break;
            }
            sum /= 10;
        }while(sum != 0);

        System.out.print(stack.pop());
        while(!stack.isEmpty()){
            System.out.print(" "+stack.pop());
        }
    }
}
