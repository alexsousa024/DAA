import java.util.Scanner; 

public class cigarras_a{

    public static int insere(int[] caminho, int nnos, int novo){
        for(int i = 0; i < nnos; i++){
            if (caminho[i] == novo){
                return i+1; 
            }
        }
        caminho[nnos] = novo; 
        return nnos + 1; 

    }

    public static void escreveCaminhoA(int[] caminho,int nnos){
        for(int i = 0; i < nnos; i++){
            System.out.println(caminho[i]);
        }
    }
    public static int cigarras_a(int[] caminho){
        Scanner stdin = new Scanner(System.in);
        int inicio = stdin.nextInt(); 
        //Criar o array caminho 
        caminho[0] = inicio;
        int nnos  = 1; 
        int novo = stdin.nextInt(); 
        while(novo != 0){
            nnos = insere(caminho,nnos,novo);
            novo = stdin.nextInt(); 
        } 
        return nnos; 
    }

    public static void escreveCaminhoB(int[] caminho, int p ){
        while(p != 0){
            System.out.println(p);
            p = caminho[p]; 
        }
    }

    public static int cigarras_b(int[] caminho){
        Scanner stdin = new Scanner(System.in);
        int inicio = stdin.nextInt(); 
        int corr = inicio; 
        while(true){
            int novo = stdin.nextInt(); 
            caminho[corr] = novo; 
            corr = novo; 
            if(corr == 0){
                break; 
            }
        }
        return inicio;   
    }
    public static void main(String[] args){
        int[] caminho = new int[30];
        System.out.println("Funcao A: ");
        int nnos = cigarras_a(caminho); 
        System.out.println("Caminho final A :");
        escreveCaminhoA(caminho,nnos);
        System.out.println("Funcao B: ");
        int inicio = cigarras_b(caminho);
        System.out.println("Caminho final B : ");
        escreveCaminhoB(caminho,inicio); 
    }
}