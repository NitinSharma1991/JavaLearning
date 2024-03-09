package com.designPattern.observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherObservableImpl implements Observable {

    int data;

    List<Observer> observerList = new ArrayList<>();

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
        notifyObserver();
    }

    @Override
    public void registerObserver(Observer obj) {
        observerList.add(obj);
    }

    @Override
    public void removeObserver(Observer obj) {
        observerList.remove(obj);
    }

    @Override
    public void notifyObserver() {
        for (Observer obj : observerList) {
            obj.update();
        }
    }
}
