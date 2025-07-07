import java.util.Scanner;

public class JogoDaVelha {
    public static void main(String[] args) {
        Scanner elementoDigitado = new Scanner(System.in);
        System.out.println("Digite X ou O:");
        String entrada = elementoDigitado.nextLine();
        int posI = elementoDigitado.nextInt();
        int posJ = elementoDigitado.nextInt();

        String[][] elementos = {{" ", " "," "},
                                {" ", " "," "},
                                {" ", " "," "}};
        elementos[posI][posJ] = entrada;

        JogoDaVelha.MostraElementosNoConsole(elementos);
        JogoDaVelha.Verificador(elementos, posI,posJ);

        elementoDigitado.close();
    }

    //mostra os elementos do jogo (a tabela)
    public static void MostraElementosNoConsole(String[][] elementos) {
        for(int j = 0; j < 3; j++){
            for(int i = 0; i < 3; i++){
                System.out.printf("%s ", elementos[j][i]);
                if(i == 2 || i == 5 || i == 8){
                    System.out.printf("\n");
                } else {
                    System.out.printf("| ");
                }
            }
            System.out.println("---------");
        }
    } 
    

    //verificador de spot ocupado
    public static boolean Verificador(String[][] elementos, int i, int j) {
        if(elementos[i][j].equalsIgnoreCase("x") || elementos[i][j].equalsIgnoreCase("o")){
            System.out.println("Posição já ocupada. Selecione outra posição");
            return false;
        }
        else return true;
    }      
}