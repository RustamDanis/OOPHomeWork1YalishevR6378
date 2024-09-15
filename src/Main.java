class HotDrink {
    private String name;
    private int volume;

    public HotDrink(String name, int volume) {
        this.name = name;
        this.volume = volume;
    }

    public String getName() {
        return name;
    }

    public int getVolume() {
        return volume;
    }

    @Override
    public String toString() {
        return "HotDrink{" +
                "name='" + name + '\'' +
                ", volume=" + volume +
                '}';
    }
}


class HotDrinkWithTemperature extends HotDrink {
    private int temperature;

    public HotDrinkWithTemperature(String name, int volume, int temperature) {
        super(name, volume);
        this.temperature = temperature;
    }

    public int getTemperature() {
        return temperature;
    }

    @Override
    public String toString() {
        return "HotDrinkWithTemperature{" +
                "name='" + getName() + '\'' +
                ", volume=" + getVolume() +
                ", temperature=" + temperature +
                '}';
    }
}


interface VendingMachine {
    HotDrink getProduct(String name, int volume);

    HotDrinkWithTemperature getProduct(String name, int volume, int temperature);
}


class HotDrinksVendingMachine implements VendingMachine {
    @Override
    public HotDrink getProduct(String name, int volume) {
        return new HotDrink(name, volume);
    }

    @Override
    public HotDrinkWithTemperature getProduct(String name, int volume, int temperature) {
        return new HotDrinkWithTemperature(name, volume, temperature);
    }
}


public class Main {
    public static void main(String[] args) {

        HotDrink tea = new HotDrink("Tea", 250);
        HotDrinkWithTemperature coffee = new HotDrinkWithTemperature("Coffee", 200, 85);


        HotDrinksVendingMachine vendingMachine = new HotDrinksVendingMachine();


        HotDrink teaFromMachine = vendingMachine.getProduct("Tea", 250);
        HotDrinkWithTemperature coffeeFromMachine = vendingMachine.getProduct("Coffee", 200, 85);

        // Вывод информации
        System.out.println(teaFromMachine);
        System.out.println(coffeeFromMachine);
    }
}