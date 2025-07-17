import java.util.Scanner;

public class JogoDaVelha {
    //método principal
    public static void main(String[] args){
        Scanner elementoDigitado = new Scanner(System.in);
        System.out.println("Digite a letra X ou O, seguido da linha e da coluna. Formato: x(2,1):");

        //declara o array de elementos
        String[][] elementos = {{" ", " "," "},
                                {" ", " "," "},
                                {" ", " "," "}};

        //mostra o jogo antes de começar o jogo
        JogoDaVelha.MostraElementosNoConsole(elementos);
        
        //repete as rodadas até o jogo acabar
        while(!JogoDaVelha.FimDeJogo(elementos)[0]){
        
        //recebe o input
        String entrada = elementoDigitado.nextLine();

        //verifica se o formato está correto e volta o while
        if(!JogoDaVelha.FormatoCorreto(entrada)){
            System.out.println("Formato errado. Digite novamente. Formato: x(2,1)");
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
        if (JogoDaVelha.Verificador(elementos, posI, posJ)){
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
    public static void MostraElementosNoConsole(String[][] elementos){
        for(int j = 0; j < 3; j++){
            for(int i = 0; i < 3; i++){
                System.out.printf("%s ", elementos[j][i].toUpperCase());
                if(i == 2 || i == 5 || i == 8){
                    System.out.printf("\n");
                } else {
                    System.out.printf("| ");
                }
            }
            if(j != 2){
                System.out.println("---------");
            }
        }
    } 
    

    //verificador de spot ocupado
    public static boolean Verificador(String[][] elementos, int i, int j){
        if(elementos[i][j].equalsIgnoreCase("x") || elementos[i][j].equalsIgnoreCase("o")){
            System.out.println("Posição já ocupada. Selecione outra posição");
            return false;
        }
        else return true;
    }

    public static String[] TrataOsDados(String entrada) {
        String letra = entrada.substring(0,1);
        String posI = entrada.substring(2,3);
        String posJ = entrada.substring(4,5);
        String[] dadosFormatados = {letra, posI, posJ};
        return dadosFormatados;
    }

    //ganhou ou não ganhouSystem.out.println(
    public static boolean[] FimDeJogo(String[][] elementos){
        for (int z=0;z<3;z++) {
            if (JogoDaVelha.ComparacoesDeLinhasParaFimDeJogo(elementos, z, "x")){
                boolean[] resultado = {true, true};
            return resultado;
            }

            if (JogoDaVelha.ComparacoesDeLinhasParaFimDeJogo(elementos, z, "o")){
                boolean[] resultado = {true, false};
            return resultado;
            }
        }

        for (int z=0; z<3; z++) {
            if (JogoDaVelha.ComparacoesDeColunasParaFimDeJogo(elementos, z, "x")){
            boolean[] resultado = {true, true};
            return resultado;
            }

            if (JogoDaVelha.ComparacoesDeColunasParaFimDeJogo(elementos, z, "o")){
            boolean[] resultado = {true, false};
            return resultado;
            }
        }
        
        if (JogoDaVelha.ComparacoesDeDiagonaisParaFimDeJogo(elementos, 0, 0, 2, "x")) {
            boolean[] resultado = {true, true};
            return resultado;
        }

        if (JogoDaVelha.ComparacoesDeDiagonaisParaFimDeJogo(elementos, 0, 0, 2, "o")) {
            boolean[] resultado = {true, false};
            return resultado;
        }

        if (JogoDaVelha.ComparacoesDeDiagonaisParaFimDeJogo(elementos, 0, 2, 0, "x")) {
            boolean[] resultado = {true, true};
            return resultado;
        }

        if (JogoDaVelha.ComparacoesDeDiagonaisParaFimDeJogo(elementos, 0, 2, 0, "o")){
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

    public static boolean ComparacoesDeLinhasParaFimDeJogo(String[][] elementos, int num, String letra){
        return (
        elementos[num][0].equals(elementos[num][1])
        && elementos[num][1].equals(elementos[num][2])
        && elementos[num][0].equalsIgnoreCase(letra)
        );
    }

    public static boolean ComparacoesDeColunasParaFimDeJogo(String[][] elementos, int num, String letra){
        return (
        elementos[0][num].equals(elementos[1][num])
        && elementos[1][num].equals(elementos[2][num])
        && elementos[0][num].equalsIgnoreCase(letra)
        );
    }

    public static boolean ComparacoesDeDiagonaisParaFimDeJogo(String[][] elementos, int num1, int num2, int num3, String letra){
        return (
            elementos[num1][num2].equals(elementos[1][1])
            && elementos[1][1].equals(elementos[2][num3])
            && elementos[num1][num2].equalsIgnoreCase(letra)
        );
    }

    public static boolean DeuVelha(String[][] elementos){
        
        for(int j = 0; j < 3; j++){
            for(int i = 0; i < 3; i++){
                if(!(elementos[i][j].equalsIgnoreCase("x") || elementos[i][j].equalsIgnoreCase("o"))){
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean FormatoCorreto(String entrada){
        if(
            (entrada.substring(0,1).equalsIgnoreCase("x") || entrada.substring(0,1).equalsIgnoreCase("o"))
            && entrada.substring(1,2).equalsIgnoreCase("(")
            && ehNumerico(entrada.substring(2,3))
            && ehNumerico(entrada.substring(4,5))
            && entrada.substring(3,4).equalsIgnoreCase(",")
            && entrada.substring(5,6).equalsIgnoreCase(")")
            && Integer.parseInt(entrada.substring(2,3)) <= 3
            && Integer.parseInt(entrada.substring(4,5)) <= 3
        ){
            return true;
        }
        return false;
    }

    public static boolean ehNumerico(String str){
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}