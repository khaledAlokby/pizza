

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class PizzaHandler {
    public static int Maximum;
    public static int typesSize;
    public static int[] pizzas;

    public static void optemizeSlices(){
        ArrayList<Integer> indexes = new ArrayList<Integer>();
        int diff = Maximum;
        for (int i = 0; i < pizzas.length; i++) {
            if (diff < pizzas[i])
                break;
            indexes.add(i);
            diff -= pizzas[i];
        }
        try {
            writeRes2File(indexes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void writeRes2File(ArrayList<Integer> inds) throws IOException {
        OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream("e_result.in",false), StandardCharsets.UTF_8);
        out.flush();
        out.write(inds.size()+"\n");
        for (int i = 0; i < inds.size(); i++) {
            out.write(inds.get(i)+" ");
        }
        out.close();
    }
}
