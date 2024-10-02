/**
 * Represents a single car in a train
 * The car holds passengers and has a limited capacity
 */
import java.util.ArrayList;

public class Car {

    private ArrayList<Passenger> passengers; // List of passengers onboard
    private int capacity;                    // Maximum capacity of the car

    /**
     * Constructor to initialize a car with a maximum capacity
     * 
     * @param capacity The maximum number of passengers the car can hold
     */
    public Car(int capacity) {
        this.capacity = capacity;
        this.passengers = new ArrayList<Passenger>();
    }

    /**
     * Accessor for the car's capacity
     * 
     * @return The maximum capacity of the car
     */
    public int getCapacity() {
        return this.capacity;
    }

    /**
     * Returns the number of seats remaining in the car
     * 
     * @return The number of seats that are still available
     */
    public int seatsRemaining() {
        return this.capacity - this.passengers.size();
    }

    /**
     * Adds a passenger to the car if there are seats available
     * 
     * @param p The passenger to add
     * @return true if the passenger was added, false if the car is full
     */
    public boolean addPassenger(Passenger p) {
        if (seatsRemaining() > 0) {
            passengers.add(p);
            return true;
        }
        return false; // Car is full
    }

    /**
     * Removes a passenger from the car
     * 
     * @param p The passenger to remove
     * @return true if the passenger was removed, false if the passenger was not found
     */
    public boolean removePassenger(Passenger p) {
        return passengers.remove(p); // Return whether the passenger was found and removed
    }

    /**
     * Prints a list of all passengers in the car
     */
    public void printPassengers() {
        if (passengers.isEmpty()) {
            System.out.println("This car is EMPTY.");
        } else {
            for (Passenger p : passengers) {
                System.out.println("- " + p.getName());
            }
        }
    }
}
