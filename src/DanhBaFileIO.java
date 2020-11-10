import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: AnhNBT (anhnbt.it@gmail.com)
 * Date: 10/11/2020
 * Time: 9:33 SA
 */

public class DanhBaFileIO implements FileIO<DanhBa> {
    @Override
    public boolean writeCSVFile(List<DanhBa> danhBaList, String csvFile) {
        try {
            File file = new File(csvFile);
            if (!file.exists()) file.createNewFile();
            Writer writer = new BufferedWriter(new FileWriter(file));
            for (DanhBa student : danhBaList) {
                String text = "";
//                String text = student.getId() + "," + student.getName() + "," + student.getAddress() + "," + student.getPhone() + "," + student.getEmail() + "," + student.getGender() + "\n";
                try {
                    writer.write(text);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            writer.flush();
            writer.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<DanhBa> readCSV(String csvFile) {
        List<DanhBa> danhBaList = new ArrayList<>();
        try {
            File file = new File(csvFile);
            if (!file.exists()) file.createNewFile();
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                String cvsSplitBy = ",";
                if (line.contains(cvsSplitBy)) {
                    String[] data = line.split(cvsSplitBy);
//                    danhBaList.add(new DanhBa(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4], data[5]));
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return danhBaList;
    }
}
