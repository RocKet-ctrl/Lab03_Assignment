import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Flight {
    private String flightId;
    private String from;
    private String to;
    private int price;

    public Flight(String flightId, String from, String to, int price) {
        this.flightId = flightId;
        this.from = from;
        this.to = to;
        this.price = price;
    }

    public String getFlightId() {
        return flightId;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Flight ID: " + flightId +
                "\nFrom: " + from +
                "\nTo: " + to +
                "\nPrice: " + price + "\n";
    }
}

class FlightSearchApp {
    public static void main(String[] args) {
        List<Flight> flights = new ArrayList<>();
        flights.add(new Flight("AI161E90", "BLR", "BOM", 5600));
        flights.add(new Flight("BR161F91", "BOM", "BBI", 6750));
        flights.add(new Flight("AI161F99", "BBI", "BLR", 8210));
        flights.add(new Flight("VS171E20", "JLR", "BBI", 5500));
        flights.add(new Flight("AS171G30", "HYD", "JLR", 4400));
        flights.add(new Flight("AI131F49", "HYD", "BOM", 3499));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter your choice: ");
            System.out.println("1. Search by Flight ID");
            System.out.println("2. Search by Source City");
            System.out.println("3. Search by Destination City");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter Flight ID: ");
                    String flightIdInput = scanner.next();
                    searchByFlightId(flights, flightIdInput);
                    break;
                case 2:
                    System.out.println("Enter Source City: ");
                    String sourceCityInput = scanner.next();
                    searchBySourceCity(flights, sourceCityInput);
                    break;
                case 3:
                    System.out.println("Enter Destination City: ");
                    String destinationCityInput = scanner.next();
                    searchByDestinationCity(flights, destinationCityInput);
                    break;
                case 4:
                    System.out.println("Exiting program.");
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    public static void searchByFlightId(List<Flight> flights, String flightIdInput) {
        for (Flight flight : flights) {
            if (flight.getFlightId().equalsIgnoreCase(flightIdInput)) {
                System.out.println(flight);
                return;
            }
        }
        System.out.println("Flight not found with ID: " + flightIdInput);
    }

    public static void searchBySourceCity(List<Flight> flights, String sourceCityInput) {
        for (Flight flight : flights) {
            if (flight.getFrom().equalsIgnoreCase(sourceCityInput)) {
                System.out.println(flight);
            }
        }
    }

    public static void searchByDestinationCity(List<Flight> flights, String destinationCityInput) {
        for (Flight flight : flights) {
            if (flight.getTo().equalsIgnoreCase(destinationCityInput)) {
                System.out.println(flight);
            }
        }
    }
}