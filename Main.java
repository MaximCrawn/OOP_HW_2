package hw_2;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Market market = new Market();
        Random random = new Random();

        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(random.nextInt(5000));
                    Person person = new Person("Человек " + System.currentTimeMillis());
                    market.addPerson(person);
                    System.out.println(person.getName() + " встал в очередь.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                try {
                    market.update();
                    Thread.sleep(random.nextInt(5000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}




