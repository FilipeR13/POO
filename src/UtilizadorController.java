import javax.swing.plaf.metal.MetalMenuBarUI;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class UtilizadorController {

    private Vintage v;
    Utilizador u;
    public UtilizadorController(Vintage v) {
        this.v = v;
        u = null;
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
        System.out.print("NIF :: ");
        u.setNif(sc.nextInt());
        u.setId(Codigos.gerarCodigo());
        return u;
    }

    public void login () throws VintageException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Email: ");
        String email = sc.nextLine();
        this.u = v.getUtilizadores().get(email);
        if (u == null)
            throw new VintageException("Não existe nenhum utilizador com o email " + email);
    }

    public void adicionaSapatilha () {
        int atacador = -1, dia, mes,ano, estado = -1;

        Sapatilhas s = new Sapatilhas();
        Scanner sc = new Scanner(System.in);
        System.out.print("Marca :: ");
        s.setMarca(sc.nextLine());
        System.out.print("Tamanho :: ");
        s.setTamanho(sc.nextInt());
        System.out.print("Cor :: ");
        s.setCor(sc.nextLine());

        do {
            System.out.print("Atacador (0 ou 1) :: ");
            atacador = sc.nextInt();
        } while (atacador != 0 && atacador != 1);
        s.setAtacador(atacador);

        System.out.print("Ano de lançamento :: ");
        ano = sc.nextInt();
        System.out.print("Mes de lançamento :: ");
        mes = sc.nextInt();
        System.out.print("Dia de lançamento :: ");
        dia = sc.nextInt();

        LocalDate date = LocalDate.of(ano,mes,dia);
        s.setDate(date);
        do {
            System.out.print("Estado do Artigo (0->Novo, 1 -> Usado) :: ");
            estado = sc.nextInt();
        } while (estado != 0 && estado != 1);
        s.setEstado(estado);

        if (estado == 1) {
            System.out.print("Número de Donos ::");
            s.setnDonos(sc.nextInt());
            System.out.print("Danos do Artigo ::");
            s.setDanos(sc.nextLine());
        }

        System.out.print("Descrição ::");
        s.setDescricao(sc.nextLine());
        System.out.print("Preço ::");
        s.setPreco(sc.nextDouble());
        System.out.println ("Escolha a Transportadora:");
        for (Map.Entry<String, Transportadora> a : v.getTransportadoras().entrySet()) {
            Transportadora t = a.getValue();
            System.out.println(t.getId() + " -> " + t.getTransportadora());
        }
        String transportadora = null;
        do {
            transportadora = sc.nextLine();
        } while (!v.getTransportadoras().containsKey(transportadora));
        s.setTransportadora(v.getTransportadoras().get(transportadora));
        s.setUser_id(this.u.getEmail());

        v.addSapatilha(s);
        u.adiconaSapatilhaVenda(s);
    }
    public void adicionaArtigo () {
        Menu tipoArtigo = new Menu(new String[] {
                "Sapatilha",
                "Mala",
                "TShirt"
        });
        tipoArtigo.setHandler(1,this :: adicionaSapatilha);
        tipoArtigo.run();
    }
}
