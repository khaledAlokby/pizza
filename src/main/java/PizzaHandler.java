

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class PizzaHandler {
    public static int Maximum;
    public static int typesSize;
    public static int[] pizzas;
    public static int minDiff;
    public static List minIndexes;

    public static void optemizeSlices(){
        int limit = upCounting();
        for (int i = limit; i < pizzas.length; i++) {
            downCounting(i);
        }
        write2File();
    }

    private static void downCounting(int highestIndex) {
        List<Integer> indexes = new ArrayList<>();
        int diff = Maximum;
        for (int i = highestIndex; i >= 0 ; i--) {
            if (diff < pizzas[i])
                continue;
            indexes.add(i);
            diff -= pizzas[i];
        }
        if (diff < minDiff){
            System.out.println("down better than up in this case");
            minDiff = diff;
            minIndexes = indexes;
        }
    }

    private static int upCounting() {
        List<Integer> indexes = new ArrayList<>();
        int diff = Maximum;
        int i = 0;
        for (; i < pizzas.length; i++) {
            if (diff < pizzas[i])
                break;
            indexes.add(i);
            diff -= pizzas[i];
        }
        minDiff = diff;
        minIndexes = indexes;
        return i;
    }

    private static void write2File() {
        try {
            writeRes2File();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeRes2File() throws IOException {
        OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream("e_result.in",false), StandardCharsets.UTF_8);
        out.flush();
        out.write(minIndexes.size()+"\n");
        for (int i = 0; i < minIndexes.size(); i++) {
            out.write(minIndexes.get(i)+" ");
        }
        out.close();
    }
}
