package exercises.exer14;

import java.util.*;

public class EmployeeRepository implements Repository<Employee,String>{
    private static final Map<String, Employee> db = new LinkedHashMap<>();


    @Override
    public void create(Employee employee) {
        Objects.requireNonNull(employee,"Employee must not be null");
        db.put(employee.getId(),employee);
    }

    @Override
    public Optional<Employee> findOne(String key) {
        return Optional.ofNullable(db.get(key));
    }

    @Override
    public List<Employee> findAll() {
        return new ArrayList<>(db.values());
    }

    @Override
    public boolean update(Employee employee) {
        Objects.requireNonNull(employee,"Employee must not be null");
        return db.replace(employee.getId(), employee) != null;
    }

    @Override
    public boolean deleteBykey(String key) {
        return db.remove(key) != null;
    }

    @Override
    public boolean delete(Employee employee) {
        Objects.requireNonNull(employee,"Employee must not be null");
        return deleteBykey(employee.getId());
    }
}
