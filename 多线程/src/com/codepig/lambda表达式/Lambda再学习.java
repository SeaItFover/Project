package com.codepig.lambda表达式;

/**
 * 接口 实现类 实现方法 抽象类
 * Lambda Express
 * 口诀：拷贝小括号，写死右箭头，落地大括号
 * @FunctionalInterface函数式接口
 * 所谓函数式接口，在jdk1。8之后就是接口内部只有一个声明但未实现的方法，其余必须都是default或者static修饰的实现方法
 * default
 * static
 * Lambda表达式只适合函数式接口
 */
@FunctionalInterface
interface Foo{
    public void div1(int x,int y);

    default int div2(int x,int y){
        return x/y;
    }
    static int div3(int x,int y){
        return x * y;
    }
}

public class Lambda再学习 {
    public static void main(String[] args) {
        //匿名内部类
        Foo foo1 = new Foo() {
            @Override
            public void div1(int x, int y) {
                System.out.println(x+y);
            }
        };

        //Lambda表达式
        Foo foo2 = (x,y)-> System.out.println(x+y) ;
        foo2.div1(10,2);

        //接口中Default方法的调用
        Foo foo3 = (x,y)-> System.out.println(x+y);
        System.out.println(foo3.div2(9,3));

        //接口中Static方法的调用
        System.out.println(Foo.div3(2,3));
        System.out.println(Thread.currentThread().getName());
    }
}
