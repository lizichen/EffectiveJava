package scropio0zry_csdn;

/**
 * Created by lizichen on 1/19/18.
 */
import java.util.Scanner;

//邻接矩阵(图)
public class MyGraph_2 {
    int MAX_SIZE = 100;
    // 定义一个一维数组存储顶点
    final static int INFINITE = Integer.MAX_VALUE;
    char[] vex;
    // 定义二维数组存储边
    int[][] side;
    // 边的数量
    int numSide;
    // 顶点的数量
    int numVertex;

    public void createGraph() {
        // 输入边和顶点的数量
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入边的数量");
        numSide = sc.nextInt();
        System.out.println("请输入顶点的数量");
        numVertex = sc.nextInt();
        // 根据顶点数建立数组
        vex = new char[numVertex];
        side = new int[numVertex][numVertex];
        // 输入顶点
        Scanner sc2 = new Scanner(System.in);
        System.out.println("请输入顶点");
        String str = sc2.nextLine();
        // 利用正则表达式,将非法顶点字符去掉
        vex = str.replaceAll("[^1-9a-zA-Z]*", "").substring(0, numVertex)
                .toCharArray();

        // 矩阵初始化
        for (int i = 0; i < side.length; i++) {
            for (int j = 0; j < side.length; j++) {
                if (i == j) {
                    side[i][j] = 0;
                } else {
                    side[i][j] = INFINITE;
                }
            }
        }

        // 数据输入
        System.out.println("请输入图的结构:1.无向图   2.有向图");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                method1();
                break;
            case 2:
                method2();
                break;
            default:
        }

    }

    // 有向图
    private void method2() {
        Scanner sc = new Scanner(System.in);
        // 依次输入权重
        for (int i = 0; i < side.length; i++) {
            for (int j = 0; j < side.length; j++) {
                if (i == j) {

                } else {
                    System.out.println("请输入" + vex[i] + "到" + vex[j] + "的权重");
                    int weight = sc.nextInt();
                    side[i][j] = weight;
                    side[j][i] = side[i][j];
                }
            }
        }
    }

    // 无向图
    public void method1() {
        Scanner sc = new Scanner(System.in);
        // 依次输入权重
        for (int i = 0; i < side.length; i++) {
            for (int j = i; j < side.length; j++) {
                if (i == j) {

                } else {
                    System.out.println("请输入" + vex[i] + "到" + vex[j] + "的权重");
                    int weight = sc.nextInt();
                    side[i][j] = weight;
                    side[j][i] = side[i][j];
                }
            }
        }
    }


    public static void main(String[] args) {
        MyGraph_2 m = new MyGraph_2();
        m.createGraph();
    }
}