package scropio0zry_csdn.FruitMarket;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Manager {

    public void manager() throws IOException {
        if (load()) {
            Scanner sc = new Scanner(System.in);
            while (true) {
                ArrayList<Fruit> list = new ArrayList<Fruit>();
                check(list);
                System.out
                        .println("请输入您的操作： (1.查看水果种类         2.增加水果种类        3.修改水果种类      4.删除水果种类         5退出)");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        // 查看水果种类
                        print(list);
                        break;
                    case 2:
                        // 增加水果种类
                        addFruit(list);
                        break;
                    case 3:
                        // 修改水果种类
                        reverse(list);
                        break;
                    case 4:
                        // 删除水果种类
                        remove(list);
                        break;
                    case 5:
                        // 退出
                        return;
                    default:
                        System.out.println("你输入的操作有误!");
                        break;
                }
            }

        } else {
            return;
        }
    }

    public void remove(ArrayList<Fruit> list) throws IOException {
        Scanner sc = new Scanner(System.in);
        print(list);
        System.out.println("请输入要删除的水果ID: ");
        String id = sc.nextLine();
        for (int i = 0; i < list.size(); i++) {
            Fruit f = list.get(i);
            if(f.getId().equals(id)){
                list.remove(i);
                write(list);
                System.out.println("删除成功");
                return;
            }
        }
        System.out.println("找不到要删除的水果ID!");
    }

    //修改水果
    public void reverse(ArrayList<Fruit> list) throws IOException {
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        print(list);
        System.out.println("请输入要修改的水果ID: ");
        String id = sc1.nextLine();
        for (int i = 0; i < list.size(); i++) {
            Fruit f = list.get(i);
            if(f.getId().equals(id)){
                System.out.println("请输入水果的名称: ");
                String name = sc1.nextLine();
                System.out.println("请输入水果的价格: ");
                int price = sc2.nextInt();
                System.out.println("请输入水果的单位: ");
                String unit = sc1.nextLine();

                f.setName(name);
                f.setPrice(price);
                f.setUnit(unit);

                write(list);
                System.out.println("修改成功");
                return;
            }
        }
        System.out.println("找不到要修改的水果ID!");


    }

    //增加水果
    public void addFruit(ArrayList<Fruit> list) throws IOException {
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        print(list);
        System.out.println("请输入要增加水果的ID: ");
        String id = sc1.nextLine();
        for (int i = 0; i < list.size(); i++) {
            Fruit f = list.get(i);
            if(f.getId().equals(id)){
                System.out.println("水果ID名重复!");
                return;
            }
        }
        System.out.println("请输入水果的名字: ");
        String name = sc1.nextLine();
        System.out.println("请输入水果的价格: ");
        int price = sc2.nextInt();
        System.out.println("请输入水果的单位: ");
        String unit = sc1.nextLine();

        Fruit f = new Fruit(id, name, price, unit);
        list.add(f);

        write(list);
        System.out.println("增加成功");

    }
    //写入新加的种类
    private void write(ArrayList<Fruit> list) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("fruit.txt"));
        for (int i = 0; i < list.size(); i++) {
            Fruit f = list.get(i);
            bw.write(f.getId()+" " + f.getName() + " " + f.getPrice() + " " + f.getUnit());
            bw.newLine();
        }
        bw.close();
    }


    public void print(ArrayList<Fruit> list) {
        System.out.println("ID\t水果\t价格\t单位");
        for (int i = 0; i < list.size(); i++) {
            Fruit f = list.get(i);
            System.out.println(f.getId() + "\t" + f.getName() + "\t"
                    + f.getPrice() + "\t" + f.getUnit());
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

    // 登陆系统
    public boolean load() throws FileNotFoundException, IOException {
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入用户名： ");
        String username = sc.nextLine();
        System.out.println("请输入密码： ");
        String password = sc.nextLine();
        BufferedReader br = new BufferedReader(new FileReader("admin.txt"));
        String line = br.readLine();
        String[] str = line.split(",");
        if (str[0].equals(username) && str[1].equals(password)) {
            System.out.println("欢迎您进入水果管理系统： " + username);
            return true;
        } else {
            System.out.println("你的用户名或密码输入不正确，无法进入管理系统");
            return false;
        }
    }
}