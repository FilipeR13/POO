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
        sc.nextLine(); //O nextInt mete um \n no final, é preciso skippar este \n
        System.out.print("Cor :: ");
        s.setCor(sc.nextLine());


        while (atacador != 0 && atacador != 1) {
            System.out.print("Atacador (0 ou 1) :: ");
            atacador = sc.nextInt();
        }
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
        sc.nextLine(); //O nextInt mete um \n no final, é preciso skippar este \n
        if (estado == 1) {
            System.out.print("Número de Donos ::");
            s.setnDonos(sc.nextInt());
            sc.nextLine(); //O nextInt mete um \n no final, é preciso skippar este \n
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

    public void adicionaMala () {
        int dimensao = -1, dia, mes,ano, estado = -1;

        Malas m = new Malas();
        Scanner sc = new Scanner(System.in);
        System.out.print("Marca :: ");
        m.setMarca(sc.nextLine());
        System.out.print("Material :: ");
        m.setMaterial(sc.nextLine());

        while (dimensao != 0 && dimensao != 1 && dimensao != 2) {
            System.out.print("Dimensão (0 -> pequena ou 1 -> media ou 2 -> grande) :: ");
            dimensao = sc.nextInt();
        }
        m.setDimensao(dimensao);

        System.out.print("Ano de lançamento :: ");
        ano = sc.nextInt();
        System.out.print("Mes de lançamento :: ");
        mes = sc.nextInt();
        System.out.print("Dia de lançamento :: ");
        dia = sc.nextInt();

        LocalDate date = LocalDate.of(ano,mes,dia);
        m.setDate(date);
        do {
            System.out.print("Estado do Artigo (0->Novo, 1 -> Usado) :: ");
            estado = sc.nextInt();
        } while (estado != 0 && estado != 1);
        m.setEstado(estado);
        sc.nextLine(); //O nextInt mete um \n no final, é preciso skippar este \n
        if (estado == 1) {
            System.out.print("Número de Donos ::");
            m.setnDonos(sc.nextInt());
            sc.nextLine(); //O nextInt mete um \n no final, é preciso skippar este \n
            System.out.print("Danos do Artigo ::");
            m.setDanos(sc.nextLine());
        }
        System.out.print("Descrição ::");
        m.setDescricao(sc.nextLine());
        System.out.print("Preço ::");
        m.setPreco(sc.nextDouble());
        System.out.println ("Escolha a Transportadora:");
        for (Map.Entry<String, Transportadora> a : v.getTransportadoras().entrySet()) {
            Transportadora t = a.getValue();
            System.out.println(t.getId() + " -> " + t.getTransportadora());
        }
        String transportadora = null;
        do {
            transportadora = sc.nextLine();
        } while (!v.getTransportadoras().containsKey(transportadora));
        m.setTransportadora(v.getTransportadoras().get(transportadora));
        m.setUser_id(this.u.getEmail());

        v.addMala(m);
        u.adiconaMalaVenda(m);
    }

    public void adicionaTshirt () {
        int tamanho = -1, padrao = -1, dia, mes,ano, estado = -1;

        TShirt t = new TShirt();
        Scanner sc = new Scanner(System.in);
        System.out.print("Marca :: ");
        t.setMarca(sc.nextLine());

        while (tamanho != 0 && tamanho != 1 && tamanho != 2 && tamanho != 3) {
            System.out.print("Dimensão (0 -> S ou 1 -> M ou 2 -> L ou 3 -> XL) :: ");
            tamanho = sc.nextInt();
        }
        t.setTamanho(tamanho);

        while (padrao != 0 && padrao != 1 && padrao != 2 && padrao != 3) {
            System.out.print("Padrão (0 -> Liso ou 1 -> Riscas ou 2 -> Palmeiras) :: ");
            padrao = sc.nextInt();
        }
        t.setPadrao(padrao);

        System.out.print("Ano de lançamento :: ");
        ano = sc.nextInt();
        System.out.print("Mes de lançamento :: ");
        mes = sc.nextInt();
        System.out.print("Dia de lançamento :: ");
        dia = sc.nextInt();

        LocalDate date = LocalDate.of(ano,mes,dia);
        t.setDate(date);
        do {
            System.out.print("Estado do Artigo (0->Novo, 1 -> Usado) :: ");
            estado = sc.nextInt();
        } while (estado != 0 && estado != 1);
        t.setEstado(estado);
        sc.nextLine(); //O nextInt mete um \n no final, é preciso skippar este \n
        if (estado == 1) {
            System.out.print("Número de Donos ::");
            t.setnDonos(sc.nextInt());
            sc.nextLine(); //O nextInt mete um \n no final, é preciso skippar este \n
            System.out.print("Danos do Artigo ::");
            t.setDanos(sc.nextLine());
        }
        System.out.print("Descrição ::");
        t.setDescricao(sc.nextLine());
        System.out.print("Preço ::");
        t.setPreco(sc.nextDouble());
        System.out.println ("Escolha a Transportadora:");
        for (Map.Entry<String, Transportadora> a : v.getTransportadoras().entrySet()) {
            Transportadora tra = a.getValue();
            System.out.println(tra.getId() + " -> " + tra.getTransportadora());
        }
        String transportadora = null;
        do {
            transportadora = sc.nextLine();
        } while (!v.getTransportadoras().containsKey(transportadora));
        t.setTransportadora(v.getTransportadoras().get(transportadora));
        t.setUser_id(this.u.getEmail());

        v.addTshirt(t);
        u.adiconaTshirtVenda(t);
    }
    public void adicionaArtigo () {
        Menu tipoArtigo = new Menu(new String[] {
                "Sapatilha",
                "Mala",
                "TShirt"
        });
        tipoArtigo.setHandler(1,this :: adicionaSapatilha);
        tipoArtigo.setHandler(2,this :: adicionaMala);
        tipoArtigo.setHandler(3,this :: adicionaTshirt);
        tipoArtigo.run();
    }
}
