/**
 * Represents a train consisting of an engine and multiple cars
 */
import java.util.ArrayList;

public class Train {

    private Engine engine;         // The engine powering the train
    private ArrayList<Car> cars;   // List of cars attached to the train

    /**
     * Constructor to initialize a train with an engine and a specified number of cars
     * 
     * @param fuelType          The type of fuel the engine uses
     * @param fuelCapacity      The fuel capacity of the engine
     * @param nCars             The number of cars in the train
     * @param passengerCapacity The maximum number of passengers each car can hold
     */
    public Train(FuelType fuelType, double fuelCapacity, int nCars, int passengerCapacity) {
        this.engine = new Engine(fuelType, fuelCapacity);
        this.cars = new ArrayList<Car>();

        // Add cars to the train
        for (int i = 0; i < nCars; i++) {
            cars.add(new Car(passengerCapacity));
        }
    }

    /**
     * Accessor for the train's engine.
     * 
     * @return The engine of the train
     */
    public Engine getEngine() {
        return this.engine;
    }

    /**
     * Gets a specific car by index.
     * 
     * @param i The index of the car to retrieve
     * @return The car at the specified index
     */
    public Car getCar(int i) {
        return cars.get(i);
    }

    /**
     * Calculates the total capacity of the train.
     * 
     * @return The sum of the capacities of all cars
     */
    public int getMaxCapacity() {
        int totalCapacity = 0;
        for (Car car : cars) {
            totalCapacity += car.getCapacity();
        }
        return totalCapacity;
    }

    /**
     * Calculates the remaining seats across all cars.
     * 
     * @return The total number of seats still available
     */
    public int seatsRemaining() {
        int totalSeatsRemaining = 0;
        for (Car car : cars) {
            totalSeatsRemaining += car.seatsRemaining();
        }
        return totalSeatsRemaining;
    }

    /**
     * Prints the passenger list for the entire train.
     */
    public void printPassengers() {
        for (int i = 0; i < cars.size(); i++) {
            System.out.println("Car " + (i + 1) + " passenger:");
            cars.get(i).printPassengers();
        }
    }
}

