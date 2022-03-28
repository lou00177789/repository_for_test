import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

/**
 * @author liuLiang
 * @create 2022/2/26 19:14
 * @Description
 * @explain
 *
 * 6::手机号码
 * 15::排查状态
 * 40::排查结果
 * 42::处置措施
 * 47::核酸检测结果(最近)
 * 48::核酸检测时间(最近)
 */
public class Control {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\刘亮\\Desktop\\三天两检\\风险人员清单20220226143333.xlsx");
        //1.创建Excel对象
        XSSFWorkbook wb = null;
        try {
            wb = new XSSFWorkbook(file);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
        XSSFSheet sheetAt = wb.getSheetAt(0);
        Iterator<Row> iterator = sheetAt.iterator();
        //总数
        int count = 0;
        //已排查
        int checked = 0;
        // 待排查
        int notChecked = 0;
        while (iterator.hasNext()){
            count++;
            Row next = iterator.next();
            Cell cell = next.getCell(14);
            String s = cell.toString();
            System.out.println(s);
            if (cell.equals("已排查")) checked++;
            if (cell.equals("待排查")) notChecked++;
        }
        System.out.println(45);
        try {
            wb.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
