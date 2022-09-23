import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class ReadJSON {
    
    private static final File FILE_JSON = new File(
            "C:\\Users\\Thinkpad L3\\working-files\\working-files\\src\\file-json.json");
    public static void main(String[] args) throws IOException {

        FileReader fileReader = new FileReader(FILE_JSON);

        JsonArray jsonArray = (JsonArray) JsonParser.parseReader(fileReader);

        List<Person> persons = new ArrayList<Person>();

        for (JsonElement jsonElement : jsonArray) {
            Person person = new Gson().fromJson(jsonElement, Person.class);
            persons.add(person);
            
        }

        persons.forEach(p->System.out.println(p.toString()));

    }
}
