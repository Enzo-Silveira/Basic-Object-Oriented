package exercises.exer12;

import java.util.*;

public class Main {
    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        while (!word.isEmpty()&&!word.equals("0")){
            list.add(word);
            word = scanner.nextLine();
        }
        Set<String> treeSet = new TreeSet<>(list);
        System.out.println("Todas as palavras digitadas:\n");
        for (String element : list){
            System.out.println(element);
        }
        System.out.println("\nAs palavras digitadas sem repetição e em ordem alfabética:\n");
        for (String element : treeSet){
            System.out.println(element);
        }
        System.out.println("\nA frequência de cada palavra digitada:\n");
        Map<String, Integer> frequency = new HashMap<>();
        for (String element : list){
            frequency.put(element, frequency.getOrDefault(element, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : frequency.entrySet()) System.out.println(entry);
    }
}
