import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;

public class Main {

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
        }finally {
            v = new Vintage();
        }

        try {
            e.guardaEstado(args[1], v);
        } catch (FileNotFoundException ex) {
            System.out.println ("Ficheiro nao existe: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Não conseguiu aceder o ficheiro: " + ex.getMessage());
        }
        Utilizador u = new Utilizador("wjwokdwojd",1093103910,"Joao Coelho","Ruilhe","joaoerineu@gmail.com");
        v.addUtilizador(u);
        UtilizadorController user = new UtilizadorController(v.getUtilizadores());
        VintageController mainController = new VintageController(v,user);
        ViewClient client = new ViewClient(mainController);
        client.run();

    }
}

