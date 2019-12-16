package JUC高级.example;

import java.util.*;

/**
 * 使用lambda表达式
 */
public class BetterSaleTicket {
    public static void main(String[] args) {
        //这是匿名内部类，不是lambda表达式
        new List(){

            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public boolean add(Object o) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean addAll(Collection c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public Object get(int index) {
                return null;
            }

            @Override
            public Object set(int index, Object element) {
                return null;
            }

            @Override
            public void add(int index, Object element) {

            }

            @Override
            public Object remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator listIterator() {
                return null;
            }

            @Override
            public ListIterator listIterator(int index) {
                return null;
            }

            @Override
            public List subList(int fromIndex, int toIndex) {
                return null;
            }

            @Override
            public boolean retainAll(Collection c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection c) {
                return false;
            }

            @Override
            public boolean containsAll(Collection c) {
                return false;
            }

            @Override
            public Object[] toArray(Object[] a) {
                return new Object[0];
            }
        };

        //集合类中重写了toString方法，所以可以直接进行打印
        //如果传入参数是数组的话，可以直接一个个传入数值即可
        List list = Arrays.asList(1,2,2,2,2,2);
        System.out.println(list);
        List l = new ArrayList();
        l.add(1);
        l.add(1);
        l.add(1);
        l.add(1);
        System.out.println(l);
    }
}
