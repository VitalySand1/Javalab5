import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Streams {
    private PhoneBook phonebook;

    Streams(PhoneBook p){
        this.phonebook = p;
    }
    public int countOfSameName(Abonent a) {
        return (int)this.phonebook.getAbonent().stream().filter(x->x.getImya().equals(a.getImya())).count();
    }
    public int countOfSameSurname(Abonent a) {
        return (int)this.phonebook.getAbonent().stream().filter(x->x.getFamiliya().equals(a.getFamiliya())).count();
    }
    public int getAmountOfAbonents() {
        return (int)this.phonebook.getAbonent().stream().count();
    }
    public List<Abonent> sortAbonentFromAtoZ(){
        return this.phonebook.getAbonent().stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
    }
    public List<Abonent> sortAbonentFromZtoA(){
        return this.phonebook.getAbonent().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }
    public static void main(String args[]){
        Abonent A1 = new Abonent("Vitaly", "Sand",false,03722424, LocalDate.of(1995,12,14));
        Abonent A2 = new Abonent("Anton", "Antonw",false,03722424, LocalDate.of(1988,11,10));
        Abonent A3 = new Abonent("Bodya", "BodyaAA",false,03722424, LocalDate.of(1997,5,5));
        List<Abonent> Abonent1 = new ArrayList<>();
        Abonent1.add(A1);
        Abonent1.add(A2);
        Abonent1.add(A3);
        PhoneBook P = new PhoneBook(300,"Blue","Bukovina", Abonent1,LocalDate.of(2017,5,22));
        Streams s  = new Streams(P);
        System.out.println(s.countOfSameName(A1));

    }
}







