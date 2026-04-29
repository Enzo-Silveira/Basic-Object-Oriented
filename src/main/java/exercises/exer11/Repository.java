package exercises.exer11;

public interface Repository <K,V>{
    void register(V e);
    V findById(K id);
}
