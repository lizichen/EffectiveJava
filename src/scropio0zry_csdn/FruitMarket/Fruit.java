package scropio0zry_csdn.FruitMarket;

/**
 * http://blog.csdn.net/scropio0zry/article/details/78440253
 */

public class Fruit {
    //定义ID
    private String id;
    //定义名称
    private String name;
    //定义价格
    private int price;
    //定义单位
    private String unit;

    //定义数量
    private int number;
    public Fruit(String id, String name, int price, String unit) {
        super();
        this.id = id;
        this.name = name;
        this.price = price;
        this.unit = unit;
    }
    public Fruit() {
        super();
        // TODO Auto-generated constructor stub
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public String getUnit() {
        return unit;
    }
    public void setUnit(String unit) {
        this.unit = unit;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }

    //获取价格
    public int getMoney(){
        return price * number;
    }

}