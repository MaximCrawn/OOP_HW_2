package hw_2;

public interface QueueBehaviour {
    void enqueue(Person person); 
    Person dequeue(); 
    boolean isEmpty(); 
    int size(); 
}
