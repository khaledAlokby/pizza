import java.io.*;
import java.net.URL;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        URL url = Main.class.getResource("a_example.in");
        File file = new File(url.getPath());
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String st;
        st = br.readLine();
        if (st == null)
            System.exit(-1);
        String[] meta = st.split(" ");
        PizzaHandler.Maximum = Integer.valueOf(meta[0]);
        PizzaHandler.typesSize = Integer.valueOf(meta[1]);
        PizzaHandler.pizzas = new int[PizzaHandler.typesSize];
        st = br.readLine();
        String[] strPizzas = st.split(" ");
        for (int i = 0; i < PizzaHandler.typesSize; i++) {
            PizzaHandler.pizzas[i] = Integer.valueOf(strPizzas[i]);
        }
        PizzaHandler.optemizeSlices();
        br.close();
    }

}
