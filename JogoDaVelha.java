import java.util.Scanner;

public class JogoDaVelha {
    //método principal
    public static void main(String[] args) {
        Scanner elementoDigitado = new Scanner(System.in);
        System.out.println("Digite X ou O, seguido da linha e da coluna. Ex: x(2,1):");

        //declara o array de elementos
        String[][] elementos = {{" ", " "," "},
                                {" ", " "," "},
                                {" ", " "," "}};
        
        //repete as rodadas até o jogo acabar
        while (!JogoDaVelha.FimDeJogo(elementos)[0]){
        
        //recebe o input
        String entrada = elementoDigitado.nextLine();

        //verifica se o formato está correto e continua quando esta errado
        if(!JogoDaVelha.FormatoCorreto(entrada)){
            System.out.println("Formato errado. Digite novamente. Ex: x(2,1)");
            continue;
        }

        //divide as entradas em array
        JogoDaVelha.TrataOsDados(entrada);

        //identifica as posições
        int posI = Integer.parseInt(JogoDaVelha.TrataOsDados(entrada)[1])-1;
        int posJ = Integer.parseInt(JogoDaVelha.TrataOsDados(entrada)[2])-1;

        //identifica a letra
        String letra = JogoDaVelha.TrataOsDados(entrada)[0];

        //verifica se a posição esta ocupada e adiciona
        if (JogoDaVelha.Verificador(elementos,posI,posJ)){
            elementos[posI][posJ] = letra;
        }

        //da o print dos elementos
        JogoDaVelha.MostraElementosNoConsole(elementos);
        }

        //verifica quem ganhou caso não tenha dado velha
        if(!JogoDaVelha.DeuVelha(elementos)){
            if (JogoDaVelha.FimDeJogo(elementos)[1]){
                System.out.println("X ganhou");
            }

            if (!JogoDaVelha.FimDeJogo(elementos)[1]){
                System.out.println("O ganhou");
            }
        }
        
        //verifica se deu velha e da print na mensagem
        if (JogoDaVelha.FimDeJogo(elementos)[0] && JogoDaVelha.DeuVelha(elementos)){
            System.out.println("Deu velha");
        }

        //fecha o Scanner
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

    //ganhou ou não ganhouSystem.out.println(
    public static boolean[] FimDeJogo(String[][] elementos) {
        for (int z=0;z<3;z++) {
            if (elementos[z][0].equals(elementos[z][1]) && elementos[z][1].equals(elementos[z][2]) && elementos[z][0].equalsIgnoreCase("X")) {
                boolean[] resultado = {true, true};
            return resultado;
            }

            if (elementos[z][0].equals(elementos[z][1]) && elementos[z][1].equals(elementos[z][2]) && elementos[z][0].equalsIgnoreCase("O")) {
                boolean[] resultado = {true, false};
            return resultado;
            }
        }

        for (int z=0;z<3;z++) {
            if (elementos[0][z].equals(elementos[1][z]) && elementos[1][z].equals(elementos[2][z]) && elementos[0][z].equalsIgnoreCase("X")) {
            boolean[] resultado = {true, true};
            return resultado;
            }

            if (elementos[0][z].equals(elementos[1][z]) && elementos[1][z].equals(elementos[2][z]) && elementos[0][z].equalsIgnoreCase("O")) {
            boolean[] resultado = {true, false};
            return resultado;
            }
        }
        
        if (elementos[0][0].equals(elementos[1][1]) && elementos[1][1].equals(elementos[2][2]) && elementos[0][0].equalsIgnoreCase("X")) {
            boolean[] resultado = {true, true};
            return resultado;
        }

        if (elementos[0][0].equals(elementos[1][1]) && elementos[1][1].equals(elementos[2][2]) && elementos[0][0].equalsIgnoreCase("O")) {
            boolean[] resultado = {true, false};
            return resultado;
        }

        if (elementos[0][2].equals(elementos[1][1]) && elementos[1][1].equals(elementos[2][0]) && elementos[0][2].equalsIgnoreCase("X")) {
            boolean[] resultado = {true, true};
            return resultado;
        }

        if (elementos[0][2].equals(elementos[1][1]) && elementos[1][1].equals(elementos[2][0]) && elementos[0][2].equalsIgnoreCase("O")) {
            boolean[] resultado = {true, false};
            return resultado;
        }

        if (JogoDaVelha.DeuVelha(elementos)){
            boolean[] resultado = {true, false};
            return resultado; 
        }

        boolean[] resultado = {false, true};
        return resultado;
    }

    public static boolean DeuVelha(String[][] elementos) {
        
        for(int j = 0; j < 3; j++){
            for(int i = 0; i < 3; i++){
                if(!(elementos[i][j].equalsIgnoreCase("x") || elementos[i][j].equalsIgnoreCase("o"))){
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean FormatoCorreto(String entrada) {
        if((entrada.substring(0,1).equalsIgnoreCase("x") || entrada.substring(0,1).equalsIgnoreCase("o")) && entrada.substring(1,2).equalsIgnoreCase("(") && ehNumerico(entrada.substring(2,3)) && ehNumerico(entrada.substring(4,5)) && entrada.substring(3,4).equalsIgnoreCase(",") && entrada.substring(5,6).equalsIgnoreCase(")") && Integer.parseInt(entrada.substring(2,3)) <= 3 && Integer.parseInt(entrada.substring(4,5)) <= 3){
            return true;
        }
        return false;
    }

    public static boolean ehNumerico(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}