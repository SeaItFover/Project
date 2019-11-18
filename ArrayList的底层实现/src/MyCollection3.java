import java.util.ArrayList;
import java.util.List;

/**
 * 增加自动扩容和数组越界警告
 */
public class MyCollection3<E> extends Object{
    private Object[] elementData;
    private final static int DEFAULT_CAPACITY = 10;
    private int size;

    public MyCollection3(){
        elementData = new Object[DEFAULT_CAPACITY];
    }
    public MyCollection3(int capacity){
        elementData  = new Object[capacity];
    }

    public void add(E obj){
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
        MyCollection3 list = new MyCollection3();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        System.out.println(list);
        List list1 = new ArrayList();
    }
}
