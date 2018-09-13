import java.util.Scanner;

public class Java1001 {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("please enter a number");
        int number = scanner.nextInt();
        int count = 0;
        while (number!=1){
            if(number%2 == 0)
            {
                number = number/2;
            }
            else{
                number = (number*3+1)/2;
            }
            count++;
        }

        System.out.println(count);
    }

}
