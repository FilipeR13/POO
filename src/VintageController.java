import java.net.URI;
import java.time.LocalDate;
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

    public void utilizadorMaisRendeu() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Deseja adicionar uma data limite (1 -> sim ou 0 -> não) :: ");
        if(sc.nextInt() == 1) {
            System.out.print("Data a considerar :: ");
            String data = sc.nextLine();
            LocalDate date = LocalDate.parse(data);
            v.utilizadorMaisRendeu(date);
        }
    }
}
