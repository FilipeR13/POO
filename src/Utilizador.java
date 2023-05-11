import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Utilizador implements Serializable {
    private int nif;
    private String id,nome,morada,email;
    private double preco_vendidos;
    private Map <String, Artigos> venda,vendeu;
    private List <Artigos> carrinho;
    private Map <String, Encomenda> encomendas;

    public Utilizador() {
        id = "";
        nif = -1;
        nome = morada = email = null;

        preco_vendidos = 0;
        venda = new HashMap<>();
        vendeu = new HashMap<>();
        carrinho = new ArrayList<>();
        encomendas = new HashMap<>();
    }

    public Utilizador (String id) {
        this.id = id;
        nif = -1;
        nome = morada = email = null;

        preco_vendidos = 0;
        venda = new HashMap<>();
        vendeu = new HashMap<>();
        carrinho = new ArrayList<>();
        encomendas = new HashMap<>();
    }

    public Utilizador (String id, int nif, String nome,String morada, String email) {
        this.id = id;
        this.nif = nif;
        this.nome = nome;
        this.morada = morada;
        this.email = email;

        preco_vendidos = 0;
        venda = new HashMap<>();
        vendeu = new HashMap<>();
        carrinho = new ArrayList<>();
        encomendas = new HashMap<>();
    }

    public Utilizador (Utilizador a) {
        this.id = a.getId();
        this.nome = a.getNome();
        this.nif = a.getNif();
        this.nome = a.getNome();
        this.email = a.getEmail();
        this.morada = a.getMorada();
        this.preco_vendidos = a.getPreco_vendidos();
        this.vendeu = a.getVendeu();
        this.venda = a.getVenda();
        this.carrinho = a.getCarrinho();
        this.encomendas = a.getEncomendas();
    }

    public double getPreco_vendidos() {
        return preco_vendidos;
    }

    public String getId() {
        return id;
    }

    public int getNif() {
        return nif;
    }

    public String getEmail() {
        return email;
    }

    public String getMorada() {
        return morada;
    }

    public String getNome() {
        return nome;
    }

    public List<Artigos> getCarrinho () {
        return this.carrinho.stream().map(a -> a.clone()).collect(Collectors.toList());
    }

    public void setNome (String nome1) {
        nome = nome1;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPreco_vendidos(double preco_vendidos) {
        this.preco_vendidos = preco_vendidos;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public void setVenda(Map<String,Artigos> venda) {
        for (Map.Entry<String, Artigos> a : venda.entrySet())
            this.venda.put(a.getKey(),a.getValue().clone());
    }

    public void setVendeu(Map<String,Artigos> vendeu) {
        for (Map.Entry<String, Artigos> a : vendeu.entrySet())
            this.venda.put(a.getKey(),a.getValue().clone());
    }

    private void setCarrinho (List<Artigos> carrinho) {
        this.carrinho = carrinho.stream().map(a -> a.clone()).collect(Collectors.toList());
    }

    public void setComprou(Map<String,Artigos> comprou) {
        for (Map.Entry<String, Encomenda> a : encomendas.entrySet())
            this.encomendas.put(a.getKey(),a.getValue().clone());
    }

    public Map<String,Encomenda> getEncomendas() {
        return this.encomendas.entrySet().stream().collect(Collectors.toMap((e)->e.getKey(), (e)->e.getValue().clone()));
    }

    public Map<String,Artigos> getVenda() {
        return this.venda.entrySet().stream().collect(Collectors.toMap((e)->e.getKey(), (e)->e.getValue().clone()));
    }

    public Map<String,Artigos> getVendeu() {
        return this.vendeu.entrySet().stream().collect(Collectors.toMap((e)->e.getKey(), (e)->e.getValue().clone()));
    }

    public Utilizador clone() {
        return new Utilizador (this);
    }

    public boolean equals(Object obj) {
        if(obj==this)
            return true;
        if(obj==null || obj.getClass() != this.getClass())
            return false;
        Utilizador le = (Utilizador) obj;
        return le.getId().equals(this.id) &&
                le.getEmail().equals(this.email) &&
                le.getMorada().equals(this.morada) &&
                le.getNome().equals(this.nome) &&
                le.getNif() == this.nif &&
                le.getPreco_vendidos() == this.preco_vendidos &&
                this.venda.equals(le.getVenda()) &&
                this.vendeu.equals(le.getVendeu()) &&
                this.carrinho.equals(le.getCarrinho()) &&
                this.encomendas.equals(le.getEncomendas());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Utilizador:: {");
        sb.append("Id: ").append(this.id);
        sb.append("Nome: ").append(this.nome);
        sb.append("Email: ").append(this.email);
        sb.append("Morada: ").append(this.morada);
        sb.append("Nif: ").append(this.nif);
        sb.append("Preco Total Vendido: ").append(this.preco_vendidos);
        sb.append("Lista de Artigos em Venda:").append(this.venda);
        sb.append("Lista de Artigos Vendidos:").append(this.vendeu);
        sb.append("Lista de Artigos no Carrinho:").append(this.carrinho);
        sb.append("Lista de Artigos que Comprou:").append(this.encomendas).append("}");

        return sb.toString();
    }

    public void adiconaArtigosVenda (Artigos a) {
        venda.put(a.getCodigo(),a);
    }

    public void vendaArtigo (String codigo) {
        Artigos a = venda.get(codigo);
        vendeu.put(codigo,a);
        venda.remove(codigo);
    }

    public void adicionaCarrinho (Artigos a) {
        carrinho.add(a);
    }

    public void removeCarrinho (String a) {
        carrinho.removeIf(e -> e.getCodigo().equals(a));
    }

}

