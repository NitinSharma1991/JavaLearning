package com.designPattern.observer;

public interface Observable {


    void registerObserver(Observer obj);
    void removeObserver(Observer obj);

    void notifyObserver();


}

