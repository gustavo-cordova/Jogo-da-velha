import java.util.Scanner;

public class JogoDaVelha {
    public static void main(String[] args) {
        Scanner elementoDigitado = new Scanner(System.in);
        System.out.println("Digite X ou O, seguido da linha e da coluna. Ex: x(2,1):");
        

        String[][] elementos = {{" ", " "," "},
                                {" ", " "," "},
                                {" ", " "," "}};
        
        while (!JogoDaVelha.FimDeJogo(elementos)){
        String entrada = elementoDigitado.nextLine();
        JogoDaVelha.TrataOsDados(entrada);
        int posI = Integer.parseInt(JogoDaVelha.TrataOsDados(entrada)[1])-1;
        int posJ =  Integer.parseInt(JogoDaVelha.TrataOsDados(entrada)[2])-1;
        String letra = JogoDaVelha.TrataOsDados(entrada)[0];
        if (JogoDaVelha.Verificador(elementos,posI,posJ)){
            elementos[posI][posJ] = letra;
        }
        JogoDaVelha.MostraElementosNoConsole(elementos);
        }
        

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

    public static String[] TrataOsDados(String entrada) {
        entrada = entrada.trim();
        String letra = entrada.substring(0,1);
        String posI = entrada.substring(2, 3);
        String posJ = entrada.substring(4, 5);
        String[] dadosFormatados = {letra,posI,posJ};
        return dadosFormatados;
    }

    //ganhou ou não ganhou
    public static boolean FimDeJogo(String[][] elementos) {

        for (int z=0;z<3;z++) {
            if (elementos[z][0].equals(elementos[z][1]) && elementos[z][1].equals(elementos[z][2]) && (elementos[z][0].equalsIgnoreCase("X") || elementos[z][0].equalsIgnoreCase("O"))) {
            return true;
            }
        }

        for (int z=0;z<3;z++) {
            if (elementos[0][z].equals(elementos[1][z]) && elementos[1][z].equals(elementos[2][z]) && (elementos[0][z].equalsIgnoreCase("X") || elementos[0][z].equalsIgnoreCase("O"))) {
            return true;
            }
        }
        
            if (elementos[0][0].equals(elementos[1][1]) && elementos[1][1].equals(elementos[2][2]) && (elementos[0][0].equalsIgnoreCase("X") || elementos[0][0].equalsIgnoreCase("O"))) {
                return true;
        
            }

            if (elementos[0][2].equals(elementos[1][1]) && elementos[1][1].equals(elementos[2][0]) && (elementos[0][2].equalsIgnoreCase("X") || elementos[0][2].equalsIgnoreCase("O"))) {
                return true;
            }

            return false;
      
}
}