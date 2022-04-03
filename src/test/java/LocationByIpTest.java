import org.junit.jupiter.api.*;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LocationByIpTest {

    GeoServiceImpl ipTest;

    @BeforeAll
    public static void beforeAllMethod() {
        System.out.println("BeforeAll call");
    }

    @BeforeEach
    public void beforeEachMethod() {
        System.out.println("BeforeEach call");
        ipTest = new GeoServiceImpl();
    }

    @AfterEach
    public void afterEachMethod() {
        System.out.println("AfterEach call");
    }

    @AfterAll
    public static void afterAllMethod() {
        System.out.println("AfterAll call");
    }

    @Test
    public void testLocation() {
        String ip = "172.123.12.19";
        Country expected = Country.RUSSIA;
        Location result = ipTest.byIp(ip);
        assertEquals(expected, result.getCountry());
        assertNotNull(result);
    }
}
