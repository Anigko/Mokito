import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.i18n.LocalizationService;
import ru.netology.sender.MessageSender;
import ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessageSenderTest {

    @Test
    void message_Sender_Test_Ru() {

        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.123.12.19");


        String ip = "172.123.12.19";
        Location location = new Location("Moscow", Country.RUSSIA, "Lenina", 15);
        GeoService geoService = Mockito.mock(GeoService.class);
        Mockito.when(geoService.byIp(ip)).thenReturn(location);

        String expected = "Добро пожаловать";
        LocalizationService localizationService = Mockito.mock(LocalizationService.class);
        Mockito.when(localizationService.locale(Country.RUSSIA)).thenReturn(expected);

        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);
        assertEquals(expected, messageSender.send(headers));
    }

    @Test
    void message_Sender_Test_Us() {

        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.44.183.149");

        String ip = "96.44.183.149";
        Location location = new Location("New York", Country.USA, " 10th Avenue", 32);
        GeoService geoService = Mockito.mock(GeoService.class);
        Mockito.when(geoService.byIp(ip)).thenReturn(location);

        String expected = "Welcome";
        LocalizationService localizationService = Mockito.mock(LocalizationService.class);
        Mockito.when(localizationService.locale(Country.USA)).thenReturn(expected);

        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);
        assertEquals(expected, messageSender.send(headers));
    }
}
