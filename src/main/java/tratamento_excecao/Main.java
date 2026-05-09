package tratamento_excecao;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static boolean isEven(String val) {
        int num = Integer.parseInt(val);
        return num % 2 == 0;
    }

    public static String readFile(String fileName) throws IOException {
        Objects.requireNonNull(fileName, "File name must not be null!"); // same as if(fileName == null) throw new NullPointerException(...);
        File file = new File(fileName);
        return Files.lines(file.toPath()).collect(Collectors.joining("\n")); // The utility class Files provides a lines() method that returns a Stream
    }

    public static String readFiles(String fileName) {
        Objects.requireNonNull(fileName, "File name must not be null!");
        File file = new File(fileName);
        Stream<String> lines = null;
        try {
            lines = Files.lines(file.toPath());
            return lines.collect(Collectors.joining("\n"));
        } catch (IOException _ ) {
            System.err.println("File could not be found or is corrupted!");
        } finally {
            if(lines != null) lines.close(); // If the Stream is not null, it will be closed
        }
        return "";
    }


    void main() {
        Scanner scanner = new Scanner(System.in);
        // Any exception thrown inside the try block will immediately redirect the execution flow to the respective catch block
        try {
            String input = scanner.nextLine();
            System.out.println("The input number is " + (isEven(input) ? "even!" : "odd!"));
        }
        // It will catch any NumberFormatException, but not other exceptions like NullPointerException
        catch (NumberFormatException e){
            System.err.println("Invalid number!");
        }

        try {
            System.out.print("Array size: "); int size = scanner.nextInt();
            System.out.print("Element index: "); int index = scanner.nextInt();
            String [] strings = new String[size];
            strings[index] = "Ops!";
            System.out.println("strings[" + index + "] = " + strings[index]);
        } catch (InputMismatchException | ArrayIndexOutOfBoundsException e) {
            System.err.println(e);
        }catch (Exception e){
            System.err.println(e);
        }

        try {
            System.out.println(readFile("legends.csv")); // main should handle or throw (and exit with error in case of an exception)
        } catch (IOException _ ) { // Since Java 21, unused exception parameters can be replaced by ‘_’
            System.err.println("File not found!");
        }

        System.out.println(readFiles("legends.csv"));

        scanner.close();
    }
}
