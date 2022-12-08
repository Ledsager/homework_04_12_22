import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class task_01 {
    public static void main(String[] args) {
        
        File file = new File("demo.txt");
        List<String> listOfStrings = new ArrayList<String>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))){
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

        // File file = new File("result.txt");
        // String text = "sample text";
        File file1 = new File("result.txt");
        try {
                PrintWriter out = new PrintWriter(file1);
                for ( i = 0; i <= (array.length-2); i+=2) {
                // System.out.println(i);
                if ((totalAmount[i]!=0)&(totalAmount[i+1]!=0)) {
                    // System.out.println(totalAmount[i+1]);
                    // System.out.println(totalAmount[i]);
                    // System.out.println(i);
                    double result = Math.pow(totalAmount[i+1],totalAmount[i]);

                    out.println(result);
                    // out.append(result);
                    System.out.println("Successfully written data to the file");
                    // System.out.println(result);
                }else {
                    // System.out.println(totalAmount[i+1]);
                    // System.out.println(totalAmount[i]);
                    // System.out.println(i);
                    out.print("не определено");
                    System.out.println("Successfully written data to the file");
                    
                }
                out.close();
            }
            }
                // out.print(text);
                // System.out.println("Successfully written data to the file");
            catch (IOException e) {
            e.printStackTrace();
        }
        // try (FileWriter fw = new FileWriter("result.txt", false)) {
            
        //     for ( i = 0; i <= (array.length-2); i+=2) {
        //         // System.out.println(i);
        //         if ((totalAmount[i]!=0)&(totalAmount[i+1]!=0)) {
        //             System.out.println(totalAmount[i+1]);
        //             System.out.println(totalAmount[i]);
        //             System.out.println(i);
        //             double result = Math.pow(totalAmount[i+1],totalAmount[i]);

        //             fw.write(result);
        //             // System.out.println(result);
        //         }else {
        //             System.out.println(totalAmount[i+1]);
        //             System.out.println(totalAmount[i]);
        //             System.out.println(i);
        //             fw.println("не определено");
        //         }
        //         fw.close();
        //     }
        // } catch (IOException ex) {
        //     System.out.println(ex.getMessage());
        // }
    
        System.out.println(listOfStrings);
    }
}
