import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Repository {

    /**
     * reads from file
     * @param fileName name of file
     * @param character the separator
     * @return the list of Ausfluge objects created from the file
     */
    public List<Ausfluge> readFromFile(String fileName, String character) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        String line = bufferedReader.readLine();
        String[] attributes;
        Ausfluge fluge;
        List<Ausfluge> liste = new ArrayList<>();
        while (line != null) {
            attributes = line.split(character);
            fluge = new Ausfluge(Long.parseLong(attributes[0]), attributes[1],
                    Integer.parseInt(attributes[2]),
                    Integer.parseInt(attributes[3]), Integer.parseInt(attributes[4]));
            liste.add(fluge);

            line = bufferedReader.readLine();
        }
        return liste;
    }

    /**
     * writes to file
     * @param fileName name of file
     * @param liste list of Ausfluge objects
     * @param character the separator
     */
    public void writeToFile(String fileName, List<Ausfluge> liste, String character) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));
        for (Ausfluge obj : liste) {
            String line = obj.getId() + character + obj.getReisezahl() + character +
                    obj.getPreis() + character + obj.getMax_anz() + character + obj.getAnzahl();
            bufferedWriter.write(line);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
    }

    /**
     * sorts the list by flight number of participants in descending order
     * @throws IOException
     */
    public void sort() throws IOException {
        List<Ausfluge> List = readFromFile("ausfluge.txt", "&&");
        List<Ausfluge> sortedList = List.stream()
                .sorted(Ausfluge::kleiner).toList();

        this.writeToFile("ausflugesortiert.txt",sortedList,"&&");

    }

    /**
     * writes every city and its occupancy percent to a file given as a parameter
     * @param lista flight list
     * @param fileName the file we are writing to
     */
    public void getTopActors(List<Ausfluge> lista, String fileName) throws IOException {
        Map<String, Float> flugeMap = new HashMap<>();
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));

        for (Ausfluge fluge : lista){
            int anz = 0;
            float sum = 0;
            for (Ausfluge fluge2 : lista)
                if (fluge2.getReisezahl() == fluge.getReisezahl()){
                    anz += 1;
                    sum += ( float) fluge2.getAnzahl()/ (float) fluge2.getMax_anz()*100;
                }
            flugeMap.put(fluge.getReisezahl(), sum/anz);
        }

        flugeMap.entrySet().stream().sorted(Map.Entry.comparingByValue()).toList();

        for (var entry : flugeMap.entrySet().stream().sorted(Map.Entry.comparingByValue()).toList()) {
            String line = entry.getKey() + ":  " + entry.getValue() + "%";
            bufferedWriter.write(line);
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }



}
