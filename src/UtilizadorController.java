import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.HashMap;
import java.util.Map;

public class UtilizadorController {
    private Map<String,Utilizador> utilizadores;

    public UtilizadorController(Map<String,Utilizador> utilizadores) {
        this.utilizadores = utilizadores;
    }

    public Utilizador registerUtilizador() {
        Utilizador u = new Utilizador();
        Scanner sc = new Scanner(System.in);
        System.out.print("Email :: ");
        u.setEmail(sc.nextLine());
        System.out.print("Nome :: ");
        u.setNome(sc.nextLine());
        System.out.print("Morada :: ");
        u.setMorada(sc.nextLine());
        System.out.print("id :: ");
        u.setId(sc.nextLine());
        System.out.print("nif :: ");
        u.setNif(sc.nextInt());
        return u;
    }

}
