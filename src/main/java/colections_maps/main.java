package colections_maps;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class main {
    public List<Employee> imperativeFilterComputerScientists(List<Employee> employees){
        final List<Employee> filtered = new ArrayList<>();
        for (Employee employee : employees) {
            if(employee.getJobTitle().equals("Computer Scientist")){
                filtered.add(employee);
            }
        }
        return filtered;
    }

    public List<Employee> declarativeFilterComputerScientists(List<Employee> employees){
        return employees.stream().filter(e -> e.getJobTitle().equals("Computer Scientist")).toList();
    }

    public double imperativeAverageSalary(List<Employee> employees){
        if(employees.isEmpty()) return 0;
        double sumOfSalaries = 0;
        for (Employee employee : employees) {
            sumOfSalaries += employee.getSalary();
        }
        return sumOfSalaries / employees.size();
    }

    public double declarativeAverageSalary(List<Employee> employees){
        return employees.stream().mapToDouble(e -> e.getSalary()).average().orElse(0);
    }

//    public double declarativeAverageSalary(List<Employee> employees){
//        return employees.stream().mapToDouble(Employee::getSalary).average().orElse(0);
//    }

    public void imperativePrintEmployeesHiredBeforeLastYear(List<Employee> employees){
        for (Employee employee : employees) {
            if(employee.getYearsOfService() > 1){
                System.out.println(employee);
            }
        }
    }

    public void declarativePrintEmployeesHiredBeforeLastYear(List<Employee> employees){
        employees.stream().filter(e -> e.getYearsOfService() > 1).forEach(e -> System.out.println(e));
    }

    public Set<TechnicalSkill> imperativeCompanySkills(List<Employee> employees){
        Set<TechnicalSkill> allSkills = new HashSet<>();
        for (Employee employee : employees) {
            allSkills.addAll(employee.getSkills());
        }
        return allSkills;
    }

    public Set<TechnicalSkill> declarativeCompanySkills(List<Employee> employees){
        return employees.stream().flatMap(e -> e.getSkills().stream()).collect(Collectors.toSet());
    }

    void main() {
        List<Employee> employees = new ArrayList<>();
        var ada = new Employee("01", "Ada Lovelace", "Computer Programmer", 10_000.0, LocalDate.now());
        employees.add(ada);
        employees.add(new Employee("03", "Edsger Dijkstra", "Computer Scientist", 10_400.0, LocalDate.now().minusYears(2)));
        employees.add(1, new Employee("02", "David Huffman", "Computer Scientist", 10_700.0, LocalDate.now().minusYears(1)));
        for (Employee employee : employees)
            System.out.println(employee);
        System.out.println("employees.size() = " + employees.size());
        employees.remove(ada);
        System.out.println("employees.contains(ada) = " + employees.contains(ada));
        System.out.println("employees.size() = " + employees.size());

        var dijkstra = new Employee("03", "Edsger Dijkstra", "Computer Scientist", 10_400.0, LocalDate.now().minusYears(2));
        var huffman = new Employee("02", "David Huffman", "Computer Scientist", 10_700.0, LocalDate.now().minusYears(1));
        final List<Employee> immutableList = List.of(ada, dijkstra);
        final List<Employee> fixedSizeList = Arrays.asList(ada, dijkstra);
        // immutableList.add(huffman); // throws java.lang.UnsupportedOperationException
        // fixedSizeList.add(huffman); // throws java.lang.UnsupportedOperationException
        fixedSizeList.set(0, huffman);
        System.out.println(fixedSizeList.get(0)); // Employee{name='02', name='David Huffman', jobTitle='Computer Scientist, ..}
        // immutableList.set(0, huffman); // throws

        // List.of() produces an immutable list. As it cannot be sorted, it is necessary to create an ArrayList from it.
        List<String> legendsNames = new ArrayList<>(List.of("Ada", "Hopper", "von Neumann", "Turing"));
        Collections.sort(legendsNames);
        final String output = String.join(", ", legendsNames);
        System.out.println(output); // it prints 'Ada, Hopper, Turing, von Neumann’
        List<Integer> legendsBirthYear = new ArrayList<>(List.of(1815, 1906, 1903, 1912));
        Collections.sort(legendsBirthYear);
        StringJoiner joiner = new StringJoiner(", ");
        for (Integer year : legendsBirthYear)
            joiner.add(year.toString());
        System.out.println(joiner); // it prints '1815, 1903, 1906, 1912'

        List<Employee> legends = new ArrayList<>();
        legends.add(new Employee("03", "Edsger Dijkstra", "Computer Scientist", 10_400.0, LocalDate.now().minusYears(2)));
        legends.add(new Employee("01", "Ada Lovelace", "Computer Programmer", 10_000.0, LocalDate.now()));
        legends.add(new Employee("02", "David Huffman", "Computer Scientist", 10_700.0, LocalDate.now().minusYears(1)));
        Collections.sort(legends); // use Collections.reverse(legends) to sort in reverse order
        joiner = new StringJoiner("\n");
        for (Employee legend : legends) {
            joiner.add(legend.toString());
        }
        System.out.println(joiner);

        legends.sort(new ComparatorBySalary()); // the same as Collections.sort(legends, new ComparatorBySalary());
        for (Employee legend : legends)
            System.out.println(legend);
        System.out.println("---");
        legends.sort(new ComparatorByYearsOfEmployment());
        for (Employee legend : legends)
            System.out.println(legend);

        final Comparator<Employee> bySalary = (e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary());
        legends.sort(bySalary);
        for (Employee legend : legends)
            System.out.println(legend);
        // The Comparator interface also includes static factory methods that create Comparator instances based on Integers, Doubles, etc.
        final Comparator<Employee> byYearsOfService = Comparator.comparingInt(e -> (int) e.getYearsOfService());
        legends.sort(byYearsOfService);
        System.out.println("---");
        for (Employee legend : legends)
            System.out.println(legend);

        List<TechnicalSkill> technicalSkills = List.of(new TechnicalSkill("Postgres", 5), new TechnicalSkill("Java", 4), new TechnicalSkill("Bash", 3));
        Set<TechnicalSkill> hashSet = new HashSet<>(technicalSkills);
        Set<TechnicalSkill> treeSet = new TreeSet<>(technicalSkills);
        Set<TechnicalSkill> linkedHashSet = new LinkedHashSet<>(technicalSkills);
        for (var skill : hashSet)
            System.out.println("HashSet = " + skill);
        for (var skill : treeSet)
            System.out.println("TreeSet = " + skill);
        for (var skill : linkedHashSet)
            System.out.println("LinkedHashSet = " + skill);

        // Maps

        Map<String, Employee> employeess = new HashMap<>(); // Map<Key, Value>
        employeess.put("01", new Employee("01", "Ada Lovelace", "Computer Programmer", 10_000.0, LocalDate.now()));
        employeess.put("02", new Employee("02", "David Huffman", "Computer Scientist", 10_700.0, LocalDate.now().minusYears(1)));
        employeess.put("03", new Employee("03", "Edsger Dijkstra", "Computer Scientist", 10_400.0, LocalDate.now().minusYears(2)));
        System.out.println("employees.get(\"03\") = " + employeess.get("03"));
        System.out.println("employees.containsKey(\"04\") = " + employeess.containsKey("04")); // uses hashmap and then equals
        employeess.put("03", new Employee("03", "John von Neumann", "Polymath", 35_400.0, LocalDate.now().minusYears(7))); // put or replace
        employeess.replace("04", new Employee("04", "Claude Shannon", "Information Scientist", 5_300.0, LocalDate.now())); // replace or ignore
        for (String keys : employeess.keySet()) System.out.println("Key = " + keys);
        for (Employee value : employeess.values()) System.out.println("Value = " + value);
        for (Map.Entry<String, Employee> entry : employeess.entrySet()) System.out.println("Entry = " + entry);

        final List<Employee> employes = List.of(
                new Employee("01", "Ada Lovelace", "Computer Programmer", 10_000.0, LocalDate.now()),
                new Employee("02", "David Huffman", "Computer Scientist", 10_700.0, LocalDate.now().minusYears(1)),
                new Employee("03", "Edsger Dijkstra", "Computer Scientist", 10_400.0, LocalDate.now().minusYears(2)),
                new Employee("04", "John von Neumann", "Polymath", 35_400.0, LocalDate.now().minusYears(7)));

        System.out.println(imperativeFilterComputerScientists(employes));
        System.out.println(declarativeFilterComputerScientists(employes));
        System.out.println("---");
        System.out.println(imperativeAverageSalary(employes));
        System.out.println(declarativeAverageSalary(employes));
        System.out.println("---");
        imperativePrintEmployeesHiredBeforeLastYear(employes);
        declarativePrintEmployeesHiredBeforeLastYear(employes);
        System.out.println("---");
//        System.out.println(imperativeCompanySkills(employes));
//        System.out.println(declarativeCompanySkills(employes));

        String[] skillNames = {"Java", "Object-orientation", "functional programming"};
        Stream.of(skillNames)
                .map(String::toUpperCase) // B
                .map(TechnicalSkill::new) // D – suppose a constructor of one argument
                .sorted(Comparator.comparing(TechnicalSkill::getSkillName)) // B
                .forEach(System.out::println); // C

        ada.createPaycheck(LocalDate.now().plusMonths(1));
        ada.createPaycheck(LocalDate.now());
        // ada.getPaychecks(); // the getter is not available
        final Iterator<Paycheck> paycheckIterator = ada.iteratorPaychecks();
        while (paycheckIterator.hasNext()) {
            final Paycheck paycheck = paycheckIterator.next(); // it accesses one element at time
            System.out.println(paycheck);

        }

        System.out.println(SalaryUtils.averageSalary(1_000.0, 3_000.0));
        System.out.println(SalaryUtils.averageSalary(1_000.0, 3_000.0, 5_000.0));
        System.out.println(SalaryUtils.averageSalary(1_000.0, 3_000.0, 5_000.0, 7_000.0));
    }
}
