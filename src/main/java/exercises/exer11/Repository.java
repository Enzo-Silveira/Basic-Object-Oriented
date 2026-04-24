package exercises.exer11;

public interface Repository <T>{
    public void register(T e);
    public <T,R> T findById(R id);
}
