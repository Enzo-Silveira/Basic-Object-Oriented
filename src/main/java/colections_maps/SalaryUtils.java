package colections_maps;

import java.util.Arrays;

public class SalaryUtils {
    private SalaryUtils(){}
    public static double averageSalary(double... salaries){
        return Arrays.stream(salaries).average().orElse(0);
    }
}
