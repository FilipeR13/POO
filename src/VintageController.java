import javax.swing.event.MouseInputListener;
import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

public class VintageController {
    private Vintage v;
    private UtilizadorController user;
    private AdminController admin;

    public VintageController(Vintage v, UtilizadorController user, AdminController admin) {
        this.v = v;
        this.user = user;
        this.admin = admin;
    }

    public UtilizadorController getUtilizadorController() {
        return user;
    }
    public AdminController getAdminController() {
        return admin;
    }

    public Vintage getVintage() {
        return v;
    }

    public void registerUtilizador() {
        try {
            v.addUtilizador(user.registerUtilizador());
        } catch (VintageException e){
            System.out.println(e.getMessage());
        }
    }

    public void login() {
        try {
            user.login();
        } catch (VintageException e) {
            System.out.println(e.getMessage());
            this.login();
        }
        UtilizadorView account = new UtilizadorView(user);
        account.run();
    }

    public void registerTransportadora () {
        v.addTransportadora(admin.registerTransportadora());
    }

    public void removeTransportadora () {
        admin.removeTransportadora();
    }

    public void verTransportadoras () {
        admin.verTransportadoras();
    }

    public void avancarTempo () {
        admin.avancaTempo();
    }

    public void alterarTransportadora() {
        admin.alterarTransportadora();
    }

    public void transportadoraMaisFaturou() {
        Transportadora t = v.maisFaturacao();
        System.out.println (t.getTransportadora() + "| Total Faturado:" + t.getTotalObtido());
    }

    public void encomendasVendedor() {
        v.getUtilizadores().forEach((key,value) -> System.out.println(key + " -> " + value.getEmail()));
        String codigo;
        Scanner sc = new Scanner(System.in);
        System.out.print("Ensira o email para obter a estatística: ");
        codigo = sc.nextLine();
        while (!v.getUtilizadores().containsKey(codigo)) {
            System.out.println("Email inválido");
            codigo = sc.nextLine();
        }

        List<Encomenda> l = v.listarEncomendasVendedor(codigo);
        for (Encomenda e : l) {
            System.out.println(e.getCodigo() + " -> Artigos: ");
            String finalCodigo = codigo;
            e.getLista().forEach(el->{
                if (finalCodigo.equals(el.getUser_id()))
                    System.out.println(el.getCodigo() + " -> "+ el.getClass() + ", Marca: " + el.getMarca() + ", Preco" + el.getPreco());
            });
        }
    }


    public void maioresComVen() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Pretende verificar os maiores vendedores (0) ou maiores compradores (1): ");
        int choice = -1;
        while (choice != 0 && choice != 1) {
            choice = Read_Scanner.getInt(sc);
        }
        sc.nextLine();
        System.out.print("Insira a data inicial: ");
        LocalDate dateI = Read_Scanner.getData(sc);
        System.out.print("Insira a data final: ");
        LocalDate dateF = Read_Scanner.getData(sc);

        Map <Double,Utilizador> m = null;

        if (choice == 0) m = v.maioresVendedores(dateI,dateF);
        if (choice == 1) m = v.maioresCompradores(dateI,dateI);

        int n = 1;
        for (Map.Entry <Double,Utilizador> e : m.entrySet()) {
            System.out.println(n + ". Email: " + e.getValue().getEmail() + " -> , Nome: " + e.getValue().getNome() + ", Total: " + e.getKey());
            n++;
        }
    }
}
