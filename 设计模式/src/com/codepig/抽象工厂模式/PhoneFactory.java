package com.codepig.抽象工厂模式;

public interface PhoneFactory {
    Cpu getCpu();           //获得使用的CPU
    Screen getScreen();     //获得使用的屏幕
}
