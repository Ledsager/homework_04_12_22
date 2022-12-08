import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class task_01 {
    public static void main(String[] args) {
        
        File file = new File("demo.txt");
        List<String> listOfStrings = new ArrayList<String>();
        try (BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            String line;
            while ((line = br.readLine()) != null) {
                listOfStrings.add(line);                                    
            }
            
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println();
            
        }
        String[] array = listOfStrings.toArray(new String[0]);
        double[] totalAmount = new double[array.length];
        
        int i = 0;
        for (String item : array) {
            String[] itemInfo = item.split(" ");
            totalAmount[i] = Double.parseDouble(itemInfo[1]);
            i+=1;
        }

        try (DataOutputStream fw = new DataOutputStream(new FileOutputStream("result.bin"))) {
            
            for ( i = 0; i <= (array.length-2); i+=2) {
                // System.out.println(i);
                if ((totalAmount[i]!=0)&(totalAmount[i+1]!=0)&(i%2==0)&((i+1)%2!=0)) {
                    System.out.println(totalAmount[i+1]);
                    System.out.println(totalAmount[i]);
                    System.out.println(i);
                    double result = Math.pow(totalAmount[i+1],totalAmount[i]);

                    fw.writeDouble(result);
                    // System.out.println(result);
                }else {
                    System.out.println(totalAmount[i+1]);
                    System.out.println(totalAmount[i]);
                    System.out.println(i);
                    fw.writeUTF("не определено");
                }

            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    
        System.out.println(listOfStrings);
    }
}
