import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileText {
    
    //VALID OR TXT EITHER CSV
    //private static final File FILE_INPUT = new File("C:\\Users\\Thinkpad L3\\working-files\\working-files\\src\\fileInput.txt");
    //private static final File FILE_OUTPUT = new File("C:\\Users\\Thinkpad L3\\working-files\\working-files\\src\\fileOutput.txt");
    private static final File FILE_INPUT = new File("C:\\Users\\Thinkpad L3\\working-files\\working-files\\src\\fileInput.csv");
    private static final File FILE_OUTPUT = new File("C:\\Users\\Thinkpad L3\\working-files\\working-files\\src\\fileOutput.csv");
    private static final Person PERSON_01 = new Person("Michel", "michel@fernandes.com");
    private static final Person PERSON_02 = new Person("Pollyana", "pollyana@fernandes.com");
    private static final Person PERSON_03 = new Person("Giulia", "giulia@fernandes.com");
    private static final Person PERSON_04 = new Person("Lucas", "lucas@fernandes.com");
    public static void main(String[] args) throws Exception {
        
        System.out.println("----------- WRITE FILE ----------");

        if(!FILE_INPUT.isFile()){
            System.out.println("----------- CREATE NEW FILE IF IT NOT EXIST ----------");
            FILE_INPUT.createNewFile();
        }
        List<Person> persons = new ArrayList<Person>();
        persons.add(PERSON_01);
        persons.add(PERSON_02);
        persons.add(PERSON_03);
        persons.add(PERSON_04);

        writeResult(FILE_INPUT, persons);  
        readFile();
        
    }

    private static void readFile() throws IOException {
        System.out.println("----------- READ FILE ----------");

        if(!FILE_OUTPUT.isFile()){
            System.out.println("----------- CREATE NEW FILE IF IT NOT EXIST ----------");
            FILE_OUTPUT.createNewFile();
        }

        FileInputStream fileInputStream = new FileInputStream(FILE_INPUT);
        List<Person> persons = new ArrayList<Person>();

        try (Scanner scanner = new Scanner(fileInputStream, "UTF-8")) {
            scanner.nextLine(); //except header text file
            while(scanner.hasNext()){
                String line = scanner.nextLine();
                if(line != null && !line.isEmpty()){
                    String[] data = line.split(";");
                    Person person = new Person(data[0], data[1]);
                    persons.add(person);
                }                    
            }
        }
        persons.forEach(pers ->{System.out.println(pers.toString());});
        writeResult(FILE_OUTPUT, persons);      
    }

    private static void writeResult(File file, List<Person> persons) throws IOException{
        System.out.println("----------- WRITE FILE ----------");
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write("NAME;EMAIL\n");
        fileWriter.write("\n");

        for (Person p : persons) {
            fileWriter.write(p.getName()+";"+p.getEmail()+"\n");
        }

        fileWriter.flush();
        fileWriter.close();
    }
}
