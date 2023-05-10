import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String args[]) {
        Vintage v = new Vintage();
        try {
            v = EstadoPrograma.carregaEstado(args[0] + "/log1.txt");
        } catch (FileNotFoundException ex) {
            System.out.println ("Ficheiro nao existe: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Não conseguiu aceder o ficheiro: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Não encontrou a classe :" + ex.getMessage());
        }

        UtilizadorController user = new UtilizadorController(v);
        AdminController admin = new AdminController(v.getTransportadoras());
        VintageController mainController = new VintageController(v,user,admin);
        MainView client = new MainView(mainController);
        client.run();

        try {
            EstadoPrograma.guardaEstado(args[0] + "/log1.txt", v);
        } catch (FileNotFoundException ex) {
            System.out.println ("Ficheiro nao existe: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Não conseguiu aceder o ficheiro: " + ex.getMessage());
        }
    }
}

