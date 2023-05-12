import javax.swing.plaf.metal.MetalMenuBarUI;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
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
        int index = 1;
        Map<Integer,Transportadora> transp = new HashMap<>();
        for (Map.Entry<String, Transportadora> a : v.getTransportadoras().entrySet()) {
            Transportadora t = a.getValue();
            transp.put(index,t);
            System.out.println(index + " -> " + t.getTransportadora());
            index++;
        }
        int choice;
        do {
            choice = sc.nextInt();
        } while(choice < 1 || choice > index);
        s.setTransportadora(transp.get(choice));
        s.setUser_id(this.u.getEmail());

        v.addArtigo(s);
        u.adiconaArtigosVenda(s);
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
        int index = 1;
        Map<Integer,Transportadora> transp = new HashMap<>();
        for (Map.Entry<String, Transportadora> a : v.getTransportadoras().entrySet()) {
            Transportadora t = a.getValue();
            transp.put(index,t);
            System.out.println(index + " -> " + t.getTransportadora());
            index++;
        }
        int choice;
        do {
            choice = sc.nextInt();
        } while(choice < 1 || choice > index);
        m.setTransportadora(transp.get(choice));
        m.setUser_id(this.u.getEmail());

        v.addArtigo(m);
        u.adiconaArtigosVenda(m);
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
        int index = 1;
        Map<Integer,Transportadora> transp = new HashMap<>();
        for (Map.Entry<String, Transportadora> a : v.getTransportadoras().entrySet()) {
            Transportadora tra = a.getValue();
            transp.put(index,tra);
            System.out.println(index + " -> " + tra.getTransportadora());
            index++;
        }
        int choice;
        do {
            choice = sc.nextInt();
        } while (choice < 1 || choice > index);
        t.setTransportadora(transp.get(choice));
        t.setUser_id(this.u.getEmail());

        v.addArtigo(t);
        u.adiconaArtigosVenda(t);
    }

    public void compraArtigo () throws VintageException {
        if (this.v.getArtigos().size() == 0)
            throw new VintageException("Não existem Artigos disponíveis.");
        else {
            this.v.getArtigos().forEach((key, value) -> {
                if (!value.getUser_id().equals(this.u.getEmail())) {
                    value.calculaDesconto(v.getCurrentDate());
                    System.out.println(value.getCodigo() + " -> "
                            + value.getClass() + ", " + value.getMarca() + " Descrição: " + value.getDescricao() + " Preço " + value.getPrecoDesconto());
                }
            });

            Scanner sc = new Scanner(System.in);

            System.out.print("Escolha o artigo para adicionar ao carrinho: ");
            String codigo = sc.nextLine();
            while (!this.v.getArtigos().containsKey(codigo)) {
                System.out.print("Artigo não existe!");
                System.out.print("Escolha o artigo para adicionar ao carrinho: ");
                codigo = sc.nextLine();
            }
            Artigos a = v.getArtigos().get(codigo);
            u.adicionaCarrinho(a); // adiciona ao carrinho do user
            v.getUtilizadores().get(a.getUser_id()).vendaArtigo(codigo); // move de venda para vendido no user a qual o artigo pertence
            v.removeArtigo(codigo); // remove da lista de artigos disponiveis
        }
    }

    public void printCarrinho() {
        u.getCarrinho().forEach(value -> System.out.println(value.getCodigo() + " -> "
                + value.getClass() + ", " + value.getMarca() + "Descrição: " + value.getDescricao() + "Preço " + value.getPrecoDesconto()));
    }

    public void validaCarrinho() {
        LocalDate data = v.getCurrentDate();
        u.getCarrinho().forEach(e -> v.getUtilizadores().get(e.getUser_id()).aumentaValor(e.getPrecoDesconto()));
        u.percorreCarrinho(data);
    }


    public void devolveEncomenda () {
        AtomicBoolean existe = new AtomicBoolean(false);
        u.getEncomendas().forEach((key,value) -> {
            if (value.getEstadoE() == Encomenda.Estado.Finalizada && ChronoUnit.DAYS.between(v.getCurrentDate(),value.getData())<=2) {
                System.out.println(value.getCodigo() + " -> " + value.getLista());
                existe.set(true);
            }
        });
        if (existe.get()) {
            System.out.print("Escolha encomenda a devolver: ");
            Scanner sc = new Scanner(System.in);
            String codigo = sc.nextLine();
            while (!u.getEncomendas().containsKey(codigo)) {
                System.out.print("O código inserido não corresponde a nenhuma encomenda! ");
                codigo = sc.nextLine();
            }

            Encomenda e = u.getEncomendas().get(codigo);
            u.getEncomendas().remove(codigo);

            e.getLista().forEach(a-> {
                v.getUtilizadores().get(a.getUser_id()).removeVendeu(a.getCodigo());
                v.addArtigo(a);
            });
        }
    }
}
