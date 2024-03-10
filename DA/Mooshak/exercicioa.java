import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class exercicioa{
    public static void main(String[] args){
            Scanner stdin = new Scanner(System.in);
            int n = stdin.nextInt(); // Número de pessoas
            int[] relations = new int[n];
            for (int i = 0; i < n; i++) {
                relations[i] = stdin.nextInt(); // Pessoa à esquerda de i+1
            }
            stdin.close();
    
            boolean[] visited = new boolean[n]; //Criar um array de booleanos para identificar se os numeros estao contidos ou nao
            int peopleOutside = n;
            List<List<Integer>> groups = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    int current = i;
                    List<Integer> group = new ArrayList<>();
                    while (!visited[current]) {
                        visited[current] = true;
                        group.add(current + 1); // Adiciona o número da pessoa (1-indexado)
                        current = relations[current] - 1; // Próxima pessoa na sequência
                    }
                    if (group.size() >= 3) {
                        peopleOutside -= group.size(); 
                        groups.add(group);
                    }
                }
            }
    
            
            
    
            // Ordenação dos grupos pelo identificador mais baixo
            groups.sort((a, b) -> Integer.compare(Collections.min(a), Collections.min(b)));
    
            // Impressão dos grupos com a ordem especificada
            for (List<Integer> group : groups) {
                System.out.print(group.size() + " ");
                // Primeiro elemento é o maior (já que é o identificador mais alto do grupo)
                int firstElement = Collections.max(group);
                System.out.print(firstElement + " ");
                // Remove o primeiro elemento da impressão subsequente
                group.remove(Integer.valueOf(firstElement));
                // Ordena o restante do grupo em ordem crescente
                Collections.sort(group);
                for (int person : group) {
                    System.out.print(person + " ");
                }
                System.out.println();
            }
            
            // Impressão do número de pessoas fora de grupos grandes
            System.out.println(peopleOutside);
        }
        

        
    }
         
    


