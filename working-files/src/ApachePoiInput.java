import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ApachePoiInput {

    private static final File FILE_EXCEL = new File(
            "C:\\Users\\Thinkpad L3\\working-files\\working-files\\src\\file-excel.xls");

    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(FILE_EXCEL);

        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(fileInputStream);
        HSSFSheet hssfSheet = hssfWorkbook.getSheet("Workseet person");

        Iterator<Row> rows = hssfSheet.iterator();

        List<Person> persons = new ArrayList<Person>();

        while (rows.hasNext()) {
            Row row = rows.next();
            Iterator<Cell> cells = row.cellIterator();
            Person person = new Person();
            while (cells.hasNext()) {
                Cell cell = cells.next();

                switch (cell.getColumnIndex()) {
                    case 0:
                        person.setName(cell.getStringCellValue());
                        break;
                    case 1:
                        person.setEmail(cell.getStringCellValue());
                        break;
                }
            }
            persons.add(person);
        }
        persons.forEach(per -> System.out.println(per.toString()));

        fileInputStream.close();
        hssfWorkbook.close();
    }
}
