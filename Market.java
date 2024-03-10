package hw_2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Market implements MarketBehaviour, QueueBehaviour {
    private Queue<Person> queue;
    private Queue<Order> orders;
    private Random random;

    public Market() {
        this.queue = new LinkedList<>();
        this.orders = new LinkedList<>();
        this.random = new Random();
    }

    @Override
    public void enqueue(Person person) {
        queue.add(person);
    }

    @Override
    public Person dequeue() {
        return queue.poll();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public void addPerson(Person person) {
        enqueue(person);
    }

    @Override
    public Person removePerson() {
        return dequeue();
    }

    @Override
    public void update() {
        if (!queue.isEmpty()) {
            Person person = queue.poll();
            System.out.println(person.getName() + " вышел из очереди и делает заказ.");

            int executionTime = random.nextInt(5000);
            Order order = new Order("Заказ для " + person.getName());
            orders.add(order);
            try {
                Thread.sleep(executionTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
             System.out.println("Заказ для " + person.getName() + " выполнен за " + executionTime + " мс.");
        }
    }
}
