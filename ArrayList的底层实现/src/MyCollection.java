import java.util.ArrayList;
import java.util.List;

public class MyCollection extends Object{
    private Object[] elementData;
    private final static int DEFAULT_CAPACITY = 10;
    private int size;

    public MyCollection(){
        elementData = new Object[DEFAULT_CAPACITY];
    }
    public MyCollection(int capacity){
        elementData  = new Object[capacity];
    }

    public void add(Object obj){
        elementData[size++] = obj;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(elementData[i] + ",");
        }
        sb.setCharAt(sb.length()-1,']');
        return sb.toString();
    }

    public static void main(String[] args) {
        MyCollection list = new MyCollection();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        System.out.println(list);
        List list1 = new ArrayList();
    }
}
