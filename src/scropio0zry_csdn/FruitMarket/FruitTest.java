package scropio0zry_csdn.FruitMarket;

import java.io.IOException;
import java.util.Scanner;

public class FruitTest {
    public static void main(String[] args) throws IOException {

        System.out.println(System.getProperty("user.dir"));

        Scanner sc = new Scanner(System.in);
        Shopper shopper = new Shopper();
        Manager manager = new Manager();

        while(true){
            System.out.println( "                               欢迎光临水果系统");
            System.out.println("请输入你的角色:(1.顾客        2.管理员        3.退出)");
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    //顾客
                    shopper.shop();
                    break;
                case 2:
                    //管理员
                    manager.manager();
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("你的输入有误!");
            }
        }

    }
}