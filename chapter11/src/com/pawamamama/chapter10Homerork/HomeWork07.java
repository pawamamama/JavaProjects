package com.pawamamama.chapter10Homerork;

/**
 * @author pawamamama
 */
public class HomeWork07 {
    static void main() {
       new Car(36).new Air().flow();
        Car car = new Car(100);
        Car.Air air = car.getAir();
        air.flow();
    }
}
class Car {
    private double temperature;

    public Car(double temperature) {
        this.temperature = temperature;
    }
    public class  Air {
        public void flow() {
            if (temperature > 40) {
                System.out.println("吹冷气");

            }else if (temperature <= 0 ) {
                System.out.println("吹暖气");
            }else {
                System.out.println("关空调");
            }
        }
    }
    public Air  getAir() {
        return new Air();
    }
}