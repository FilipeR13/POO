import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;

public class Main extends Exception{
    public static void main(String args[]) {
        EstadoPrograma e = new EstadoPrograma();
        Vintage v = null;
        try {
            v = e.carregaEstado(args[1]);
        } catch (FileNotFoundException ex) {
            System.out.println ("Ficheiro nao existe: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Não conseguiu aceder o ficheiro: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Não encontrou a classe :" + ex.getMessage());
        }

        //executa views.......


        try {
            e.guardaEstado(args[1], v);
        } catch (FileNotFoundException ex) {
        System.out.println ("Ficheiro nao existe: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Não conseguiu aceder o ficheiro: " + ex.getMessage());
        }
    }
}

