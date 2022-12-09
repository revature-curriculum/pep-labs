import Application.DAO.FlightDAO;
import Application.Model.Flight;
import Application.Service.FlightService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class FlightServiceTest {
    FlightDAO mockFlightDAO;
    FlightService flightService;

    /**
     * Before every test, set up a flight service that uses a flightDAO with fake behavior.
     * The actual behavior of flightDAO does not impact these tests: we define the mockFlightDAO's behavior
     * using Mockito and thereby test the logic of the flightService independently.
     * This allows you to code the flightService before the flightDAO is even finished!
     */
    @Before
    public void setUp(){
        mockFlightDAO = Mockito.mock(FlightDAO.class);
        flightService = new FlightService(mockFlightDAO);
    }

    /**
     * when a flightDAO returns all flights, flightService.getAllFlights should return all flights.
     */
    @Test
    public void getAllFlightsTest(){
        List<Flight> allFlightsReturned = new ArrayList<>();
        allFlightsReturned.add(new Flight(801, "tampa", "dallas"));
        allFlightsReturned.add(new Flight(802, "tampa", "morgantown"));
        allFlightsReturned.add(new Flight(803, "tampa", "reston"));
        allFlightsReturned.add(new Flight(804, "tampa", "dallas"));
        Mockito.when(mockFlightDAO.getAllFlights()).thenReturn(allFlightsReturned);
        Assert.assertEquals(allFlightsReturned, flightService.getAllFlights());
    }
    /**
     * When a flightAdded is called and the database does not already contain the flight,
     * the flight should be returned because the add should be successful. Subsequent attempts to add the flight
     * should return null as the flight already exists. Also, verify that the addFlight method of the flightDAO is
     * actually called.
     */
    @Test
    public void addFlightTest(){
//        object represents new flight
        Flight newFlight = new Flight( "dallas", "morgantown");
        Flight persistedFlight = new Flight(1, "dallas", "morgantown");
        Mockito.when(mockFlightDAO.insertFlight(newFlight)).thenReturn(persistedFlight);
        Flight actualFlight = flightService.addFlight(persistedFlight);
        Assert.assertEquals(persistedFlight, flightService.addFlight(actualFlight));
//        verify that addFlight was actually used (Mockito.any will accept any parameters)
        Mockito.verify(mockFlightDAO).insertFlight(Mockito.any());
    }


    /**
     * Regardless of if the flights are filtered with a SQL query or in the Java service class,
     * flightService.getAllFlightsFromCityToCity should return all the flights between two cities.
     */
    @Test
    public void getFlightsFromCityToCityTest1(){
        List<Flight> allFlightsReturned = new ArrayList<>();
        allFlightsReturned.add(new Flight(801, "tampa", "dallas"));
        allFlightsReturned.add(new Flight(802, "tampa", "morgantown"));
        allFlightsReturned.add(new Flight(803, "tampa", "reston"));
        allFlightsReturned.add(new Flight(804, "tampa", "dallas"));
        allFlightsReturned.add(new Flight(805, "dallas", "morgantown"));
        Flight f801 = new Flight(801, "tampa", "dallas");
        Flight f804 = new Flight(804, "tampa", "dallas");
        List<Flight> cityToCityFlightsReturned = new ArrayList<>();
        cityToCityFlightsReturned.add(f801);
        cityToCityFlightsReturned.add(f804);
//        both getAllFlights and getAllFlightsFromCityToCity are mocked in case you want to develop a solution
//        that relies on filtering within the Service rather than in the SQL query. Filtering in Java
//        is less efficient than in a SQL query, but it still works.
        Mockito.when(mockFlightDAO.getAllFlightsFromCityToCity("tampa", "dallas"))
                .thenReturn(cityToCityFlightsReturned);
        Mockito.when(mockFlightDAO.getAllFlights()).thenReturn(allFlightsReturned);
        Assert.assertTrue(flightService.getAllFlightsFromCityToCity("tampa", "dallas")
                .contains(f801));
        Assert.assertTrue(flightService.getAllFlightsFromCityToCity("tampa", "dallas")
                .contains(f804));

    }

    /**
     * When a flight exists, attempting to update it should return the updated flight. Also, verify that the
     * updateFlight method of the mockFlightDAO was called.
     */
    @Test
    public void updateFlightTest1(){
        List<Flight> allFlightsReturned = new ArrayList<>();
        allFlightsReturned.add(new Flight(801, "tampa", "dallas"));
        allFlightsReturned.add(new Flight(802, "tampa", "morgantown"));
        allFlightsReturned.add(new Flight(803, "tampa", "reston"));
        allFlightsReturned.add(new Flight(804, "tampa", "dallas"));
        allFlightsReturned.add(new Flight(805, "dallas", "morgantown"));
        Flight f801 = new Flight( "dallas", "morgantown");
        Flight expectedFlight = new Flight(801, "dallas", "morgantown");
        Mockito.when(mockFlightDAO.getAllFlights()).thenReturn(allFlightsReturned);
        Mockito.when(mockFlightDAO.getFlightById(801)).thenReturn(f801);
        Assert.assertEquals(flightService.updateFlight(801, f801), expectedFlight);
//        Verify that updateFlight was actually called (Mockito.any() will accept any parameters)
        Mockito.verify(mockFlightDAO).updateFlight(801, Mockito.any());
    }
    /**
     * When a flight does not exist, attempting to update it should return null. Also, verify that
     * flightDAO.updateFlight was never called.
     */
    @Test
    public void updateFlightTestNonExistent(){
        Flight f801 = new Flight( "tampa", "dallas");
        Assert.assertEquals(null, flightService.updateFlight(801, f801));
        Mockito.verify(mockFlightDAO, Mockito.never()).updateFlight(801, f801);
    }

}
