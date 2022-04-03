import org.junit.jupiter.api.*;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class StringLocaleTest {

    LocalizationServiceImpl localTest;

    @BeforeAll
    public static void beforeAllMethod() {
        System.out.println("BeforeAll call");
    }

    @BeforeEach
    public void beforeEachMethod() {
        System.out.println("BeforeEach call");
        localTest = new LocalizationServiceImpl();
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
        Country country = Country.RUSSIA;
        String expected = "Добро пожаловать";
        String result = localTest.locale(country);
        assertEquals(expected, result);
        assertNotNull(result);
    }

}
