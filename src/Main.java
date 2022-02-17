import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
	Repository x = new Repository();
    x.sort();
    List <Ausfluge> lista = x.readFromFile("ausfluge.txt", "&&");
    x.getTopActors(lista, "statistik.txt");

    }
}
