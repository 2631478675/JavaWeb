package javaweb.ThirdTestriy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Second {
    public static void main(String args[]){
        int sum =0;
        List list = new ArrayList();
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入不超过50个数（以-1作为输入结束标志）");
        for(int i=0;i<50;i++){
            int number = scanner.nextInt();
            if(number==-1){
                break;
            }
            if(number>=0&&number<=100){
                list.add(number);
            }
        }
        System.out.println("其中有效的学生分数的个数为"+list.size());
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            sum = sum +(Integer) iterator.next();
        }
        System.out.println("有效分数的总分"+sum);
        System.out.println("平均值为"+sum/list.size());
    }
}
