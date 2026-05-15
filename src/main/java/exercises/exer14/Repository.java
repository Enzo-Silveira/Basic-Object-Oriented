package exercises.exer14;

import java.util.List;
import java.util.Optional;

public interface Repository<T,K> {
    void create(T type);

    Optional<T> findOne(K key);

    List<T> findAll();

    boolean update(T type);

    boolean deleteBykey(K key);

    boolean delete(T type);

}
