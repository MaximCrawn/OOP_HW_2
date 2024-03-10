package hw_2;

import java.util.LinkedList;

public class Market implements MarketBehaviour, QueueBehaviour {
    private LinkedList<Person> queue;
    
    public Market() {
        this.queue = new LinkedList<>();
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
        // Implement update method for Market
        // Accept and process orders
    }
}