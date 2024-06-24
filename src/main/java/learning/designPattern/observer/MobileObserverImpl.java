package learning.designPattern.observer;

public class MobileObserverImpl implements Observer {

    WeatherObservableImpl obj;

    public MobileObserverImpl(WeatherObservableImpl obj) {
        this.obj = obj;
    }

    @Override
    public void update() {
        System.out.println("Showing on Mobile and the current temp is " + obj.getData());
    }
}
