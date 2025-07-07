import java.util.Scanner;

public class JogoDaVelha {
    public static void main(String[] args) {
        int[][] elementos = {{0,0,0},{0,0,0},{0,0,0}};

        JogoDaVelha.MostraElementosNoConsole(elementos);
    }

    public static int[][] MostraElementosNoConsole(int[][] elementos) {
        for(int j = 0; j < 3; j++){
            for(int i = 0; i < 3; i++){
                System.out.printf("%d ", elementos[j][i]);
                if(i == 2 || i == 5 || i == 8){
                    System.out.printf("\n");
                } else {
                    System.out.printf("| ");
                }
            }
            System.out.println("---------");
        }

        return elementos;
    }
}