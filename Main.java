package hw_2;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Market market = new Market();
        Random random = new Random();

        // Запуск потока для добавления людей в очередь
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(random.nextInt(5000)); // Случайная задержка до 5 сек
                    Person person = new Person("Человек " + System.currentTimeMillis());
                    market.addPerson(person);
                    System.out.println(person.getName() + " встал в очередь.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        // Запуск потока для удаления людей из очереди
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(random.nextInt(5000)); // Случайная задержка до 5 сек
                    if (!market.isEmpty()) {
                        Person person = market.removePerson();
                        System.out.println(person.getName() + " вышел из очереди.");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}

