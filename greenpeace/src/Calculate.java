import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Calculate {
    static ArrayList<String> arvPre = new ArrayList<>();
    static ArrayList<String> arvInfix =  new ArrayList<>();
    static int index = 0;
    static int height = 0;

    public void carregaArq(String caso) throws IOException {
        Path arq = Paths.get(caso+".txt");
        try (Scanner sc = new Scanner(Files.newBufferedReader(arq, Charset.forName("utf8")))) {
            String  aux ="";
            String arvPreAux[] = sc.nextLine().split(" ");
            String arvCen2Aux[] = sc.nextLine().split(" ");
            for(int x = 0; x<arvPreAux.length;x++){
                arvPre.add(arvPreAux[x]);
                arvInfix.add(arvCen2Aux[x]);
            }
        }
        catch (IOException x) {
            System.err.format("Erro de E/S: %s%n", x);
        }
    }

    public static boolean joinTree(){
        try {
            int from = 0;
            int to = arvInfix.size() - 1;
            BinaryTree root = tree(from,to);
            height = treeHeight(root);
            return true;
        } catch(Exception e)
        {
            System.out.println(e);
            return false;
        }
    }

    public static BinaryTree tree(int from, int to) {//forma a árvore
        if (from > to)
            return null;

        String currentPre = arvPre.get(index++);//vou de índice em índice
        BinaryTree sub = new BinaryTree(currentPre);//coloco na árvore o valor atual do indíce
        if (from == to)//cheguei a até o máximo desse lado, retorno a última sub árvore inserida
            return sub;

        int mark = arvInfix.indexOf(sub.element);//marco na infixada o elemento atual do índice a marca é um nodo pai
        sub.left = tree(from, mark-1);//vou colocar na árvore a esquerda deste nodo, só pode ir até a marca -1 (esquerda)
        sub.right = tree(mark+1, to);//vou colocar na árvore a direita do nodo, tem que começar da marca mais um
        System.out.println(sub.element);
        return sub;//retorna o nodo atual
    }

    public static int treeHeight(BinaryTree r) {//calculo a altura
        if (r == null)
            return -1;//r nulo = altura vazia
        else {
            int hLeft = treeHeight(r.left);
            int hRight = treeHeight(r.right);

            if (hLeft < hRight) return (++hRight);//retorno a maior, esquer ou direita
            else return (++hLeft);
        }
    }

    public void getHeight(){//imprimo a altura
        if(height>=0)
            System.out.println("A altura é: " + height);
        else
            System.out.println("Àrvore não existe");
    }
}
