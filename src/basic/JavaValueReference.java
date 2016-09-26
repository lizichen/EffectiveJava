package basic;

/**
 * Created by lizichen1 on 8/30/16.
 */
public class JavaValueReference {
    // you manipulate object references, not objects.
    // An object reference describes th location of an object in Java,

    public static void main(String[] args) {
        SimpleIntHolder value1 = new SimpleIntHolder(1);
        SimpleIntHolder value2 = value1;
        SimpleIntHolder value3 = new SimpleIntHolder(2);

        System.out.println("value1 = "+value1.getSimpleInteger()+" value2 = "+value2.getSimpleInteger());

        value1.setSimpleInteger(2);
        System.out.println("value1 = "+value1.getSimpleInteger()+" value2 = "+value2.getSimpleInteger());

        System.out.println("value1 == value2 ? "+ (value1 == value2));
        System.out.println("value1.equal(value2) ? "+ (value1.equals(value2)));
        System.out.println("value1 == value3 ? "+ (value1 == value3));
        System.out.println("value1.equal(value3) ? "+ (value1.equals(value3)));
        System.out.println("value1.getSimpleInteger() == value3.getSimpleInteger() ? "+ (value1.getSimpleInteger() == value3.getSimpleInteger()));

    }
}

class SimpleIntHolder{
    private int simpleInteger;
    public SimpleIntHolder(int simpleInteger){
        this.simpleInteger = simpleInteger;
    }

    public int getSimpleInteger() {
        return simpleInteger;
    }

    public void setSimpleInteger(int simpleInteger) {
        this.simpleInteger = simpleInteger;
    }
}
