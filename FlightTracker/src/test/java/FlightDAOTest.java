import Application.Application;
import Application.DAO.FlightDAO;
import Application.Model.Flight;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * This class tests using the dummy data inserted as part of the Application.Application.databaseSetup() method.
 * It contains the following records:
 *      (1, 'tampa', 'dallas'),
 *      (2, 'tampa', 'reston'),
 *      (3, 'reston', 'morgantown'),
 *      (4, 'morgantown', 'dallas'),
 *      (5, 'tampa', 'dallas'),
 *      (6, 'dallas', 'tampa')
 */
public class FlightDAOTest {
    public FlightDAO flightDAO;

    /**
     * set up a flightDAO and recreate the database tables and mock data.
     */
    @Before
    public void setUp(){
        Application.databaseSetup();
        flightDAO = new FlightDAO();
    }

    /**
     * The flightDAO should retrieve all flights when getAllFlights is called.
     */
    @Test
    public void getAllFlightsTest1(){
        List<Flight> allFlights = flightDAO.getAllFlights();
        Flight f1 = new Flight(1, "tampa", "dallas");
        Flight f2 = new Flight(2, "tampa", "reston");
        Flight f3 = new Flight(3, "reston", "morgantown");
        Flight f4 = new Flight(4, "morgantown", "dallas");
        Flight f5 = new Flight(5, "tampa", "dallas");
        Flight f6 = new Flight(6, "dallas", "tampa");
        Assert.assertTrue(allFlights.contains(f1));
        Assert.assertTrue(allFlights.contains(f2));
        Assert.assertTrue(allFlights.contains(f3));
        Assert.assertTrue(allFlights.contains(f4));
        Assert.assertTrue(allFlights.contains(f5));
        Assert.assertTrue(allFlights.contains(f6));
    }

    /**
     * The flightDAO should retrieve a flight with a specific ID when getFlightById is called.
     */
    @Test
    public void getFlightByIDTest1(){
        Flight flight = flightDAO.getFlightById(6);
        Flight f6 = new Flight(6, "dallas", "tampa");
        Assert.assertTrue(flight.equals(f6));
    }
    /**
     * The flightDAO should retrieve a flight with a specific ID when getFlightById is called.
     */
    @Test
    public void getFlightByIDTest2(){
        Flight flight = flightDAO.getFlightById(4);
        Flight f9012 = new Flight(4, "morgantown", "dallas");
        Assert.assertTrue(flight.equals(f9012));
    }

    /**
     * When there is one flight between two cities, getAllFlightsFromCityToCity should return a list containing
     * that flight. It should not contain other flights.
     */
    @Test
    public void getFlightsFromCityToCityTest1(){
        List<Flight> flights = flightDAO.getAllFlightsFromCityToCity("reston", "morgantown");
        Flight f1 = new Flight(1, "tampa", "dallas");
        Flight f3 = new Flight(3, "reston", "morgantown");
        Flight f5 = new Flight(5, "tampa", "dallas");
        Assert.assertFalse(flights.contains(f1));
        Assert.assertTrue(flights.contains(f3));
        Assert.assertFalse(flights.contains(f5));
    }

    /**
     * When there are multiple flights between two cities, getAllFlightsFromCityToCity should return a list containing
     * both flights. It should not contain other flights.
     */
    @Test
    public void getFlightsFromCityToCityTest2(){
        List<Flight> flights = flightDAO.getAllFlightsFromCityToCity("tampa", "dallas");
        Flight f1 = new Flight(1, "tampa", "dallas");
        Flight f3 = new Flight( 3, "reston", "morgantown");
        Flight f5 = new Flight( 5, "tampa", "dallas");
        Assert.assertTrue(flights.contains(f1));
        Assert.assertFalse(flights.contains(f3));
        Assert.assertTrue(flights.contains(f5));
    }

    /**
     * When a flight is added via the flightDAO, it should be retrievable by retrieving the flight by ID.
     */
    @Test
    public void addFlightCheckByIdTest1(){
        Flight f7 = new Flight( "tampa", "morgantown");
        flightDAO.insertFlight(f7);
        Flight f7expected = new Flight(7, "tampa", "morgantown");
        Flight f7actual = flightDAO.getFlightById(7);
        Assert.assertEquals(f7expected, f7actual);
    }

    /**
     * When a flight is added via the flightDAO, it should be retrievable by retrieving all flights.
     */
    @Test
    public void addFlightCheckAllFlightsTest1(){
        Flight f7 = new Flight( "tampa", "morgantown");
        flightDAO.insertFlight(f7);
        Flight f7expected = new Flight(7, "tampa", "morgantown");
        List<Flight> allFlights = flightDAO.getAllFlights();
        Assert.assertTrue(allFlights.contains(f7expected));
    }

    /**
     * When a flight is updated via the flightDAO, the updated values should be retrieved when the flight is next
     * accessed.
     */
    @Test
    public void updateFlightTest1(){
        Flight f1updated = new Flight( "reston", "dallas");
        flightDAO.updateFlight(1, f1updated);
        Flight f1expected = new Flight(1, "reston", "dallas");
        Flight f1actual = flightDAO.getFlightById(1);
        Assert.assertEquals(f1expected, f1actual);
    }
}
