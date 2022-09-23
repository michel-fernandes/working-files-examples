import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ApachePoiOutput {
    
    private static final File FILE_EXCEL = new File("C:\\Users\\Thinkpad L3\\working-files\\working-files\\src\\file-excel.xls");
    private static final Person PERSON_01 = new Person("Michel", "michel@fernandes.com");
    private static final Person PERSON_02 = new Person("Pollyana", "pollyana@fernandes.com");
    private static final Person PERSON_03 = new Person("Giulia", "giulia@fernandes.com");
    private static final Person PERSON_04 = new Person("Lucas", "lucas@fernandes.com");
    private static int rowNumber=0;
    public static void main(String[] args) throws Exception {
        
        List<Person> persons = new ArrayList<Person>();
        persons.add(PERSON_01);
        persons.add(PERSON_02);
        persons.add(PERSON_03);
        persons.add(PERSON_04);

        if(!FILE_EXCEL.isFile()){
            System.out.println("----------- CREATE NEW FILE IF IT NOT EXIST ----------");
            FILE_EXCEL.createNewFile();
        }

        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        HSSFSheet hssfSheet = hssfWorkbook.createSheet("Workseet person");
        
        persons.forEach(per -> {
            Row row = hssfSheet.createRow(rowNumber++);
            int cellColumnNumer = 0;
            Cell cellName = row.createCell(cellColumnNumer++);
            cellName.setCellValue(per.getName());
            Cell cellEmail = row.createCell(cellColumnNumer++);
            cellEmail.setCellValue(per.getEmail());
            System.out.println(per.toString());
        });

        System.out.println("----------- WRITE FILE ----------");
        FileOutputStream fileOutputStream = new FileOutputStream(FILE_EXCEL);
        hssfWorkbook.write(fileOutputStream);

        fileOutputStream.flush();
        fileOutputStream.close();
        hssfWorkbook.close();
    }
}
