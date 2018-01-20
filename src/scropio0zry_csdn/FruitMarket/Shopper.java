package scropio0zry_csdn.FruitMarket;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Shopper {
    public void shop() throws IOException {
        Scanner sc = new Scanner(System.in);
        ArrayList<Fruit> list = new ArrayList<Fruit>();
        check(list);
        while (true) {
            System.out
                    .println("                                       欢迎光临水果系统");
            System.out
                    .println("请输入你的操作:(1.查看水果        2.购买水果        3.结账         4.退出)");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    // 查看水果
                    print(list);
                    break;
                case 2:
                    // 购买水果
                    buy(list);
                    break;
                case 3:
                    // 结账
                    checkOut(list);
                    break;
                case 4:
                    // 退出
                    return;
                default:
                    System.out.println("你输入的操作有误!");
            }

        }

    }

    //结账
    private void checkOut(ArrayList<Fruit> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            Fruit f = list.get(i);
            sum += f.getMoney();
        }

        if(sum>200){
            int newSum = (int) (sum * 0.9);
            System.out.println("金额：" + sum+ "元, 优惠价格："+ newSum+"元");
        }else{
            System.out.println("金额：" + sum+"元");
        }

        //结完账后，将数量清0
        for (int i = 0; i < list.size(); i++) {
            Fruit f = list.get(i);
            f.setNumber(0);
        }
    }

    // 购买水果
    public void buy(ArrayList<Fruit> list) throws IOException {
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        print(list);
        while (true) {
            System.out.println("购买超过200元，享受九折优惠！");
            System.out.println("请输入想要购买的水果的ID：(如果不想购买，请输入-1退出)");
            String id = sc1.nextLine();
            if ("-1".equals(id)) {
                System.out.println("购买已结束，请去结账 ");
                return;
            } else {
                boolean flag = false;
                for (int i = 0; i < list.size(); i++) {
                    Fruit f = list.get(i);
                    if(f.getId().equals(id)) {
                        System.out.println("请输入购买" + f.getName() + "数量： ");
                        int num = sc2.nextInt();
                        f.setNumber(num);
                        flag = true;
                    }
                }
                if(!flag){
                    System.out.println("你输入的水果ID不正确,请重新输入");
                }
            }

        }

    }

    // 查看水果
    public void check(ArrayList<Fruit> list) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("fruit.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            String[] str = line.split(" ");
            Fruit f = new Fruit(str[0], str[1], Integer.parseInt(str[2]),
                    str[3]);
            list.add(f);
        }
        br.close();
    }

    public void print(ArrayList<Fruit> list) {
        System.out.println("ID\t水果\t价格\t单位");
        for (int i = 0; i < list.size(); i++) {
            Fruit f = list.get(i);
            System.out.println(f.getId() + "\t" + f.getName() + "\t"
                    + f.getPrice() + "\t" + f.getUnit());
        }
    }
}