package learning.designPattern.decorator;

public class Runner {

    public static void main(String[] args) {
        BasePizza basePizza = new VeggieDecorator(new FarmHousePizza());
        BasePizza basePizza1 = new CheeseDecorator(basePizza);

        System.out.println(basePizza1.basePizzaCost());
    }
}
