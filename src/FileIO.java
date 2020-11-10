import java.io.*;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: AnhNBT (anhnbt.it@gmail.com)
 * Date: 10/11/2020
 * Time: 9:12 SA
 */

public interface FileIO<T> {

    boolean writeCSVFile(List<T> lists, String csvFile);

    List<T> readCSV(String csvFile);
}
