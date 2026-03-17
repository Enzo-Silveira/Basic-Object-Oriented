package exercises.exer4;

public class Quantity {
    public static int quantityOf(String sentence, String word){
        int num = 0;
        String[] wordsSentence = sentence.toLowerCase().split("[,\\s\\.]+");
        String lowerWord = word.toLowerCase();
        for(String words : wordsSentence){
            if(words.equals(lowerWord)){
                num++;
            }
        }
        return num;
    }

    public static void main(String[] args){
        System.out.println(quantityOf("Enzo aqui, filho de Anquises, esteve aqui. Louvado seja Deus.", "casaco"));
    }
}
