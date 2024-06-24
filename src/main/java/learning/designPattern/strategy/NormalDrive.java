package learning.designPattern.strategy;

public class NormalDrive implements DriveStrategy{
    @Override
    public String drive() {
        return "This is a normal drive";
    }
}
