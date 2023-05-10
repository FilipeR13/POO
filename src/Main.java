import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;

public class Main {

    public static void main(String args[]) {
        Vintage v = null;
        try {
            v = EstadoPrograma.carregaEstado(args[0] + "/log.txt");
        } catch (FileNotFoundException ex) {
            System.out.println ("Ficheiro nao existe: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Não conseguiu aceder o ficheiro: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Não encontrou a classe :" + ex.getMessage());
        }

        UtilizadorController user = new UtilizadorController(v.getUtilizadores());
        AdminController admin = new AdminController(v.getTransportadoras());
        VintageController mainController = new VintageController(v,user,admin);
        ViewClient client = new ViewClient(mainController);
        client.run();

        try {
            EstadoPrograma.guardaEstado(args[0] + "/log.txt", v);
        } catch (FileNotFoundException ex) {
            System.out.println ("Ficheiro nao existe: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Não conseguiu aceder o ficheiro: " + ex.getMessage());
        }
    }
}

