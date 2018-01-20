package scropio0zry_csdn;
import java.util.Scanner;

/**
  (学习java)邻接表 图的简单创建
  http://blog.csdn.net/scropio0zry/article/details/78522498
*/

//邻接表
public class MyGraph {
    // 一维数组储存所有顶点
    private Vertex[] graph;
    // 边的数量
    int numSide;
    // 顶点的数量
    int numVertex;

    public MyGraph() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void createGraph() {
        // 输入边和顶点的数量
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        System.out.println("请输入边的数量");
        numSide = sc.nextInt();
        System.out.println("请输入顶点的数量");
        numVertex = sc.nextInt();

        // 输入顶点
        getVertex();

        // 输入边
        for (int i = 0; i < graph.length; i++) {
            getfirst(graph, i);
        }
    }

    // 定义边
    private void getfirst(Vertex[] graph, int n) {
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        System.out.println("请输入顶点" + graph[n].getVertex() + "的邻结点的数量 :");
        int num = sc.nextInt();
        System.out.println("请输入邻结点");
        String str = sc2.nextLine();
        // 将第一个结点和他的所有邻结点放入字符数组中
        char[] newStr = (graph[n].getVertex() + str.replaceAll("[^1-9a-zA-Z]*",
                "").substring(0, num)).toCharArray();
        // 定义graph的头结点 值为null
        Side pre = new Side();
        graph[n].setSide(pre);
        // 邻结点数量为0
        if (num == 0) {
        } else {
            for (int j = 1; j < newStr.length; j++) {
                System.out.println("请输入" + newStr[0] + "到" + newStr[j] + "的权重");
                int weight = sc.nextInt();
                Side side = new Side(newStr[j], weight);
                pre.setNext(side);
                pre = side;
            }
        }
    }

    // 获取顶点
    public void getVertex() {
        Scanner sc = new Scanner(System.in);
        this.graph = new Vertex[numVertex];
        System.out.println("请输入顶点:");
        String str = sc.nextLine();
        char[] newStr = str.replaceAll("[^1-9a-zA-Z]*", "").substring(0, numSide).toCharArray();
        for (int i = 0; i < newStr.length; i++) {
            // 创建graph[]中每个vertex对象
            graph[i] = new Vertex(newStr[i], null);
        }
    }

    //测试类
    public static void main(String[] args) {
        MyGraph m = new MyGraph();
        m.createGraph();
        System.out.println("hello");
    }
}