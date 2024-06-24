package learning.designPattern.observer;

import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        WeatherObservableImpl observable = new WeatherObservableImpl();
        MobileObserverImpl mobileObserver = new MobileObserverImpl(observable);
        TelevisionObserverImpl televisionObserver = new TelevisionObserverImpl(observable);

        observable.registerObserver(mobileObserver);
        observable.registerObserver(televisionObserver);

        while (true) {

            Scanner scnr = new Scanner(System.in);
            int a = scnr.nextInt();
            observable.setData(a);
        }

    }
}
