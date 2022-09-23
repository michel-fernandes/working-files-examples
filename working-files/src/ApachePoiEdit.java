import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ApachePoiEdit {
    
    private static final File FILE_EXCEL = new File(
            "C:\\Users\\Thinkpad L3\\working-files\\working-files\\src\\file-excel.xls");

    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(FILE_EXCEL);

        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(fileInputStream);
        HSSFSheet hssfSheet = hssfWorkbook.getSheet("Workseet person");

        Iterator<Row> rows = hssfSheet.iterator();

        while (rows.hasNext()) {
            Row row = rows.next();
            int cellsNumber =  row.getPhysicalNumberOfCells();
            Cell cell = row.createCell(cellsNumber);
            cell.setCellValue("BR");            
        }

        fileInputStream.close();
        FileOutputStream fileOutputStream = new FileOutputStream(FILE_EXCEL);
        hssfWorkbook.write(fileOutputStream);
        fileOutputStream.flush();
        fileOutputStream.close();
        hssfWorkbook.close();

    }
}
