import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class task_01 {
    public static void main(String[] args) {
        // чтение данных из файла и запись в списочный массив
        File file = new File("input.txt");
        List<String> listOfStrings = new ArrayList<String>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                listOfStrings.add(line);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println();
        }
        // преобразуем полученный список в массив данных
        String[] array = listOfStrings.toArray(new String[0]);
        // массив для хранения значений переменных
        double[] totalAmount = new double[array.length];
        // из массива данных (array) забираем значения переменных и записываем в массив для хранения значений переменных
        int i = 0;
        for (String item : array) {
            String[] itemInfo = item.split(" ");
            totalAmount[i] = Double.parseDouble(itemInfo[1]);
            i += 1;
        }
        // записываем вычисления в выходной файл
        try (
                FileWriter fw = new FileWriter("output.txt", StandardCharsets.UTF_8)) {
            for (i = 0; i <= (array.length - 2); i += 2) {
                if ((totalAmount[i] != 0) || (totalAmount[i + 1] != 0)) {
                    Double result = Math.pow(totalAmount[i + 1], totalAmount[i]);
                    String stringresult = Double.toString(result);
                    fw.append(stringresult);
                    fw.append("\n");
                    // fw.flush();
                } else {
                    String text = "не определенно\n";
                    fw.write(text);
                    // fw.flush();
                }
            }
            fw.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            
        }
        System.out.println(listOfStrings);
    }
}