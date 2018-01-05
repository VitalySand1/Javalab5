import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class StreamsTest {
    PhoneBook P;
    Abonent Abonent1, Abonent2, Abonent3, Abonent4;
    Streams test_object;
    @BeforeTest
    void setup() {
        Abonent1 = new Abonent("Aitaly", "Sand",false,03722424, LocalDate.of(1988,12,14));
        Abonent2 = new Abonent("Citaly", "Sand",false,03722424, LocalDate.of(1996,12,14));
        Abonent3 = new Abonent("Betya", "Pechkin",false,03722424, LocalDate.of(1998,12,14));
        Abonent4 = new Abonent("Ditaly", "Pipkin",false,03722424, LocalDate.of(1948,12,14));
        List<Abonent> abonent = new ArrayList<Abonent>();
        abonent.add(Abonent1);
        abonent.add(Abonent2);
        abonent.add(Abonent3);
        abonent.add(Abonent4);
        P = new PhoneBook(300,"Blue","Bukovina", abonent, LocalDate.of(2017,5,22));
        test_object = new Streams(P);
    }
    @DataProvider
    public Object[][] testForAtoZprovider() {
        List<Abonent> products2 = new ArrayList<Abonent>();
        products2.add(Abonent1);
        products2.add(Abonent3);
        products2.add(Abonent2);
        products2.add(Abonent4);
        return new Object[][] { { P, products2 } };
    }

    @Test(dataProvider = "testForAtoZprovider")
    public void testForAtoZ(PhoneBook phoneBook, List<Abonent> a) {
        Assert.assertEquals(new Streams(phoneBook).sortAbonentFromAtoZ(), a);
    }
    @DataProvider
    public Object[][] testForZtoAprovider() {
        List<Abonent> products2 = new ArrayList<Abonent>();
        products2.add(Abonent4);
        products2.add(Abonent2);
        products2.add(Abonent3);
        products2.add(Abonent1);
        return new Object[][] { { P, products2 } };
    }

    @Test(dataProvider = "testForZtoAprovider")
    public void testForZtoA(PhoneBook phoneBook, List<Abonent> a) {
        Assert.assertEquals(new Streams(phoneBook).sortAbonentFromZtoA(), a);
    }
    @Test
    public void AmountOfProducts() {
        Assert.assertEquals(test_object.getAmountOfAbonents(), 4);
    }
    @DataProvider
    public Object[][] testForSameSurnameProvider(){

        return new Object[][] {{P,2}};
    }
    @Test(dataProvider = "testForSameSurnameProvider")
    public void testForSameSurname (PhoneBook phoneBook, int res){
        Assert.assertEquals(new Streams(phoneBook).countOfSameSurname(Abonent1),res);
    }
}