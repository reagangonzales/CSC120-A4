/**
 * Represents a passenger who can board and get off cars in a train
 */
public class Passenger {

    private String name;

    /**
     * Constructor to initialize a passenger with a name
     * 
     * @param name The passenger's name
     */
    public Passenger(String name) {
        this.name = name;
    }

    /**
     * Accessor for the passenger's name
     * 
     * @return The name of the passenger
     */
    public String getName() {
        return this.name;
    }

    /**
     * Boards the passenger onto a car
     * 
     * @param c The car to board
     */
    public void boardCar(Car c) {
        if (c.addPassenger(this)) {
            System.out.println(this.name + " boarded the car.");
        } else {
            System.out.println("Car is full. " + this.name + " couldn't board.");
        }
    }

    /**
     * Removes the passenger from a car
     * 
     * @param c The car to get off from
     */
    public void getOffCar(Car c) {
        if (c.removePassenger(this)) {
            System.out.println(this.name + " got off the car.");
        } else {
            System.out.println(this.name + " wasn't found in this car.");
        }
    }
}
