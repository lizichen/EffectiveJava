package scropio0zry_csdn;

//边结点
public class Side {
    private char name;
    //定义权重
    private int weight;
    //指向后继结点
    private Side next;
    public Side() {
        super();
    }

    public Side(char name, int weight) {
        super();
        this.name = name;
        this.weight = weight;
        this.next = null;
    }

    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public Side getNext() {
        return next;
    }
    public void setNext(Side next) {
        this.next = next;
    }
}