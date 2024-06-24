package learning.designPattern.observer;

public class TelevisionObserverImpl implements Observer {

    WeatherObservableImpl obj;

    public TelevisionObserverImpl(WeatherObservableImpl obj) {
        this.obj = obj;
    }

    @Override
    public void update() {
        System.out.println("Showing on Television and the current temp is " + obj.getData());
    }
}
