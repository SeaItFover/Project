package com.codepig.工厂方法模式;

public class AppleFactory implements FruitFactory {
    @Override
    public Fruit createFruit() {
        return new Apple();
    }
}
