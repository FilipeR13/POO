import jdk.jshell.execution.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Utilizador {
    private int id,nif;
    private String nome,morada,email;
    private double preco_vendidos;
    private List <Artigos> venda,vendeu,comprou;

    public Utilizador() {
        id = -1;
        nif = -1;
        nome = morada = email = null;

        preco_vendidos = 0;
        venda = vendeu = comprou = new ArrayList<>();
    }

    public Utilizador (int id) {
        this.id = id;
        nif = -1;
        nome = morada = email = null;

        preco_vendidos = 0;
        venda = vendeu = comprou = new ArrayList<>();
    }

    public Utilizador (int id, int nif, String nome,String morada, String email) {
        this.id = id;
        this.nif = nif;
        this.nome = nome;
        this.morada = morada;
        this.email = email;

        preco_vendidos = 0;
        venda = vendeu = comprou = new ArrayList<>();
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
        this.comprou = a.getComprou();
    }

    public double getPreco_vendidos() {
        return preco_vendidos;
    }

    public int getId() {
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

    public void setNome (String nome1) {
        nome = nome1;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(int id) {
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

    public void setVenda(List<Artigos> venda) {
        for (Artigos a : venda)
            this.venda.add(a.clone());
    }

    public void setVendeu(List<Artigos> vendeu) {
        for (Artigos a : vendeu)
            this.vendeu.add (a.clone());
    }

    public void setComprou(List<Artigos> comprou) {
        for (Artigos a : comprou)
            this.comprou.add(a.clone());
    }

    public List<Artigos> getComprou() {
        return this.comprou.stream().map (e -> e.clone()).collect(Collectors.toList());
    }

    public List<Artigos> getVenda() {
        return this.venda.stream().map (e -> e.clone()).collect(Collectors.toList());
    }

    public List<Artigos> getVendeu() {
        return this.vendeu.stream().map (e -> e.clone()).collect(Collectors.toList());
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
        return le.getId() == this.id &&
                le.getEmail().equals(this.email) &&
                le.getMorada().equals(this.morada) &&
                le.getNome().equals(this.nome) &&
                le.getNif() == this.nif &&
                le.getPreco_vendidos() == this.preco_vendidos &&
                this.venda.equals(le.getVenda()) &&
                this.vendeu.equals(le.getVendeu()) &&
                this.comprou.equals(le.getComprou());
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
        sb.append("Lista de Artigos que Comprou:").append(this.comprou).append("}");

        return sb.toString();
    }
}

