import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        long time1 = System.currentTimeMillis();
        Calculate x = new Calculate();
        String caso = "caso05";
        x.carregaArq(caso);
        boolean join = x.joinTree();
        if(join)
            x.getHeight();
        long time2 = System.currentTimeMillis();
        long tempo = time2 - time1;
        System.out.print("Caso de teste: "+ caso + "\n");
        System.out.format("Tempo: %,8d (ms)", tempo);
    }
}