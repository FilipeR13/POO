import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Read_Scanner {
    public static int getInt(Scanner sc){
        int n = 0;
        while (true){
            try{
                n = sc.nextInt();
                break;
            } catch (InputMismatchException ex){
                System.out.println("A informação introduzida não é válida: " + ex.getMessage());
            }
        }
        return n;
    }

    public static double getDouble(Scanner sc){
        double n = 0;
        while (true){
            try{
                n = sc.nextDouble();
                break;
            } catch (InputMismatchException ex){
                System.out.println("A informação introduzida não é válida: " + ex.getMessage());
            }
        }
        return n;
    }

    public static LocalDate getData(Scanner sc){
        LocalDate d = null;
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
        while(true){
            System.out.print("Data a considerar :: ");
            String input = sc.nextLine();
            try {
                d = LocalDate.parse(input, formatter);
                break;
            } catch (DateTimeParseException ex) {
                System.out.println("A informação introduzida não é válida: " + ex.getMessage());
            }
        }
        return d;
    }
}
