import java.util.Scanner;
import java.util.Map; 
import java.util.HashMap;
import java.util.Queue; 
import java.util.LinkedList; 

public class exercicioc{

    public static int chairs(Queue<Integer> ordem_pref, Map<Integer,Integer> cadeiras){
        int sentouse = 0; 
        while(ordem_pref.size() != 0){
            int n = ordem_pref.poll(); 
            if(cadeiras.get(n) > 0){
                cadeiras.put(n,cadeiras.get(n) - 1); 
                sentouse = 1; 
                break; 
            }
            continue;
        }
        return sentouse; 

    }
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        //input numero de tipo de cadeiras -> tc
        int tc = stdin.nextInt(); 
        
        int n_cadeiras_livres = 0; 
        
        //tipo de cadeiras e o numero 
        Map<Integer, Integer> cadeiras = new HashMap<Integer,Integer>(); 
        for(int i = 0; i < tc; i++){
            int tipo = stdin.nextInt(); 
            int valor = stdin.nextInt(); 
            cadeiras.put(tipo,valor);
        } 
        int n_h = stdin.nextInt(); 
        int n_pe = n_h ; 

        for(int j = 0; j < n_h; j++){
            Queue<Integer> ordem_pref = new LinkedList<Integer>();
            int n = stdin.nextInt(); 
            for(int k = 0; k < n; k++){
                ordem_pref.add(stdin.nextInt());
            }
            int sent = chairs(ordem_pref, cadeiras);
            if( sent == 1){
                n_pe --; 
            }
        }
        //Calcular o numero de cadeiras que restam: 
        for(Integer valor: cadeiras.values()){
            n_cadeiras_livres += valor; 
        }

        System.out.println(n_pe);
        System.out.println(n_cadeiras_livres);
    }
}