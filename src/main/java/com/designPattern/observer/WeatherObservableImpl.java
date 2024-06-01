package com.designPattern.observer;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class WeatherObservableImpl implements Observable {

    @Getter
    int data;

    List<Observer> observerList = new ArrayList<>();

    public void setData(int data) {
        this.data = data;
        notifyObserver();
    }

    @Override
    public void registerObserver(Observer obj) {
        observerList.add(obj);
    }

    @Override
    public void notifyObserver() {
        for (Observer obj : observerList) {
            obj.update();
        }
    }
}
