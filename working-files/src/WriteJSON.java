import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class WriteJSON {
    
    private static final File FILE_JSON = new File(
            "C:\\Users\\Thinkpad L3\\working-files\\working-files\\src\\file-json.json");
    public static void main(String[] args) throws IOException {

        Person person1 = new Person("Michel", "michelfernandes3@gmail.com");
        person1.setUsername("michelfernandes3");
        person1.setPassword("joão@123");

        Person person2 = new Person("Pollyana", "pollyana@gmail.com");
        person2.setUsername("pollyana");
        person2.setPassword("polly@123");

        List<Person> persons = new ArrayList<Person>();
        persons.add(person1);
        persons.add(person2);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();  //beutify json
        String jsonPerson = gson.toJson(persons);

        if(!FILE_JSON.isFile()){
            System.out.println("----------- CREATE NEW FILE IF IT NOT EXIST ----------");
            FILE_JSON.createNewFile();
        }

        /* you can use OutputStreamWrite for avoid error withsome characters
         * OutputStreamWrite fileWriter = new OutputStreamWrite(new FileWriter(FILE_JSON), "UTF-8");
         */
        FileWriter fileWriter = new FileWriter(FILE_JSON);
        fileWriter.write(jsonPerson);
        fileWriter.flush();
        fileWriter.close();

    }
}
