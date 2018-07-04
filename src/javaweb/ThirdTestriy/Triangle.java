package javaweb.ThirdTestriy;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 软件工程基础实验三
 */
public class Triangle {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        Set set=new HashSet();
        int  Sides[] = new int[3];
        for(int i=0 ; i<3;i++){
            System.out.println("请输入第"+(i+1)+"条边");
            Sides[i] = scanner.nextInt();
            set.add(Sides[i]);
        }
        for(int j=Sides.length-1;j>0;j--){
            for(int m=1;m<=j;m++){
                if(Sides[m-1]>Sides[m]){
                    int temp = Sides[m-1];
                    Sides[m-1] = Sides[m];
                    Sides[m] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(Sides));
        if(Sides[0]<=0||Sides[0]>1000||Sides[1]<=0||Sides[2]>1000||Sides[2]<=0||Sides[2]>1000){
            System.out.println("非三角形");
        }
        else if((Sides[0]+Sides[1])<Sides[2]){
            System.out.println("非三角形");
        }else if(set.size()==2){
            System.out.println("此三角形为等腰三角形");
        }else if(set.size()==1){
            System.out.println("此三角形为等边三角形");
        }else {
            System.out.println("此三角形为一般三角形");
        }

    }
}
