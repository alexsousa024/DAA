import java.util.Scanner; 
import java.util.Arrays;
import java.util.List;

public class exerciciob{

    public static int troco(int[] moedas_disponiveis, int troco){
        
        while(true){
            int verificador = 0;
            if (troco >= 200 && moedas_disponiveis[0] > 0) {
                troco -= 200;
                moedas_disponiveis[0] -= 1;
                verificador = 1;
            } else if (troco >= 100 && moedas_disponiveis[1] > 0) {
                troco -= 100;
                moedas_disponiveis[1] -= 1;
                verificador = 1;
            } else if (troco >= 50 && moedas_disponiveis[2] > 0) {
                troco -= 50;
                moedas_disponiveis[2] -= 1;
                verificador = 1;
            } else if (troco >= 20 && moedas_disponiveis[3] > 0) {
                troco -= 20;
                moedas_disponiveis[3] -= 1;
                verificador = 1;
            } else if (troco >= 10 && moedas_disponiveis[4] > 0) {
                troco -= 10;
                moedas_disponiveis[4] -= 1;
                verificador = 1;
            } else if (troco >= 5 && moedas_disponiveis[5] > 0) {
                troco -= 5;
                moedas_disponiveis[5] -= 1;
                verificador = 1;
            }
            if (verificador == 0) {
                break;
            }
        } 
        return troco; 
    }
    public static void  main(String[] args){
        Scanner stdin = new Scanner(System.in); 

        //Criar um array 
        int[] moedas_disponiveis = new int[6];
        int n = 0; //numero de acertos
        int r = 0; // numero de transacoes
        int retido_total = 0;
        //Coletar as moedas do input
        for(int i = 0; i < 6; i++){
            moedas_disponiveis[i] = stdin.nextInt(); 
        }
        stdin.nextLine(); 

        while(stdin.hasNextLine()){
            String linha = stdin.nextLine(); 
            //Esta parte feita pelo chat q nao sei como estrurar os whiles
            if(linha.equals("0 0") || linha.isEmpty()) break; 
            String[] partes = linha.split(" ");
            int e = Integer.parseInt(partes[0]);
            int c = Integer.parseInt(partes[1]);
            
            int valor_a_pagar = c + e*100; 
            int valor_dado = 0; 
            while(stdin.hasNextInt()){
                int montante = stdin.nextInt(); 
                if(montante == 0){
                    stdin.nextLine(); 
                    break; 
                }
                //Adicionar a lista de moedas disponiveis para o troco
                else if(montante == 2){
                    moedas_disponiveis[0] += 1; 
                    valor_dado += montante *100; 
                }
                else if(montante == 1){
                    moedas_disponiveis[1] += 1; 
                    valor_dado += montante * 100;  
                }
                else if (montante == 50 ){
                    moedas_disponiveis[2] += 1; 
                    valor_dado += montante ; 
                }
                else if( montante == 20){
                    moedas_disponiveis[3] += 1; 
                    valor_dado += montante ; 
                }
                else if(montante == 10){
                    moedas_disponiveis[4] += 1; 
                    valor_dado += montante; 
                }
                else if(montante == 5){
                    moedas_disponiveis[5] += 1; 
                    valor_dado += montante; 
                } 
            }
            //Já temos as moedas que nos foram pagas e o valor de troco q temos de dar
            int troco = valor_dado - valor_a_pagar;  
            int retido = troco(moedas_disponiveis, troco);
            if(retido != 0){
                 n += 1; 
            }
            retido_total += retido; 
            r += 1; 
        }
        int r_e = retido_total /100;
        int r_c = retido_total % 100; 
        System.out.println(r_e + " " + r_c);
        System.out.println(n + "/" + r);
        
    }

}


