package learning.designPattern.observer;

public interface Observable {


    void registerObserver(Observer obj);

    void notifyObserver();


}

