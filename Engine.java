/**
 * Represents the engine of a train
 * The engine has a specific fuel type and can store a certain amount of fuel
 */
public class Engine {

    // Engine attributes
    private FuelType fuelType;   // The type of fuel used by the engine
    private double maxFuelLevel; // Maximum amount of fuel the engine can hold
    private double currentFuelLevel; // Current amount of fuel in the engine

    /**
     * Constructor to initialize the engine with a fuel type and max fuel level.
     * 
     * @param fuelType      The type of fuel the engine uses (ELECTRIC, STEAM, etc)
     * @param maxFuelLevel  The maximum amount of fuel the engine can hold
     */
    public Engine(FuelType fuelType, double maxFuelLevel) {
        this.fuelType = fuelType;
        this.maxFuelLevel = maxFuelLevel;
        this.currentFuelLevel = maxFuelLevel; // Start fully fueled
    }

    /**
     * Refuels the engine by resetting the current fuel level to its maximum
     */
    public void refuel() {
        this.currentFuelLevel = this.maxFuelLevel;
        System.out.println("Engine refueled to maximum capacity.");
    }

    /**
     * Starts the engine and decreases fuel
     * 
     * @return true if there is still fuel, false if the engine has run out of fuel
     */
    public boolean go() {
        if (this.currentFuelLevel > 0) {
            this.currentFuelLevel -= 10; // Decrease fuel level by 10 units
            System.out.println("Engine running... Current fuel level: " + this.currentFuelLevel);
            return true;
        } else {
            System.out.println("Engine out of fuel!");
            return false;
        }
    }

    /**
     * Accessor for the fuel type
     * 
     * @return The type of fuel used by the engine
     */
    public FuelType getFuelType() {
        return this.fuelType;
    }

    /**
     * Accessor for the current fuel level
     * 
     * @return The current amount of fuel in the engine
     */
    public double getCurrentFuelLevel() {
        return this.currentFuelLevel;
    }

    /**
     * Main method for testing the engine, train, car, and passenger classes
     */
    public static void main(String[] args) {

        // Create a Train object with an electric engine, 200.0 fuel capacity, 3 cars, each with 4 seats
        Train train = new Train(FuelType.ELECTRIC, 200.0, 3, 4);

        // Get the train's engine and run it until it runs out of fuel
        Engine trainEngine = train.getEngine();
        System.out.println("Starting the train's engine:");
        while (trainEngine.go()) {
            System.out.println("Choo choo!");
        }
        System.out.println("Out of fuel.");

        // Refuel the train's engine
        trainEngine.refuel();
        System.out.println("Train engine refueled!");

        // Run the engine again
        while (trainEngine.go()) {
            System.out.println("Choo choo!");
        }
        System.out.println("Out of fuel");

        // Create passengers
        Passenger p1 = new Passenger("Alice");
        Passenger p2 = new Passenger("Bob");
        Passenger p3 = new Passenger("Charlie");

        // Add passengers to different cars
        train.getCar(0).addPassenger(p1); // Add Alice to car 1
        train.getCar(1).addPassenger(p2); // Add Bob to car 2
        train.getCar(2).addPassenger(p3); // Add Charlie to car 3

        // Print the train's list of passengers
        System.out.println("Train's passenger list:");
        train.printPassengers();

        // Print total seats remaining in the entire train
        System.out.println("Seats remaining across all cars: " + train.seatsRemaining());
    }
}

