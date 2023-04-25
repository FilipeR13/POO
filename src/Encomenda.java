import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Encomenda {
    public enum Dimensao {
        Pequena,
        Media,
        Grande
    }
    public enum Estado {
        Pendente,
        Finalizada,
        Expedida
    }
    private double preco;
    private Dimensao dimensao;
    private Estado estado;
    private Date data;
    private List<Artigos> lista;

    public Encomenda(){
        preco = 0;
        dimensao = null;
        estado = null;
        data = null;
        lista = new ArrayList<>();
    }

    public Encomenda(double preco, Dimensao dimensao, Estado estado, Date data, List<Artigos> lista){
        this.preco = preco;
        this.dimensao = dimensao;
        this.estado = estado;
        this.data = data;
        this.lista = lista.stream().map(e -> e.clone()).collect(Collectors.toList());
    }

    public Encomenda(Encomenda x){
        this.preco = x.getPrecoE();
        this.dimensao = x.getDimensao();
        this.estado = x.getEstadoE();
        this.data = x.getData();
        this.lista = x.getLista();
    }

    public double getPrecoE(){
        return preco;
    }

    public Dimensao getDimensao(){
        return dimensao;
    }

    public Estado getEstadoE(){
        return estado;
    }

    public Date getData(){
        return data;
    }

    public List<Artigos> getLista(){
        return this.lista.stream().map(e -> e.clone()).collect(Collectors.toList());
    }

    public void setPrecoE(double preco){
        this.preco = preco;
    }

    public void setDimensao(Dimensao dimensao){
        this.dimensao = dimensao;
    }

    public void setEstadoE(Estado estado){
        this.estado = estado;
    }

    public void setData(Date data){
        this.data = data;
    }

    public void setLista(List<Artigos> lista){
        for (Artigos a : lista){
            this.lista.add(a.clone());
        }
    }

    public Encomenda clone(){
        return new Encomenda(this);
    }

    public boolean equals(Object obj) {
        if(obj==this)
            return true;
        if(obj==null || obj.getClass() != this.getClass())
            return false;
        Encomenda x = (Encomenda) obj;
        return x.getPrecoE() == this.preco &&
                x.getDimensao().equals(this.dimensao) &&
                x.getEstadoE().equals(this.estado) &&
                x.getData().equals(this.data) &&
                this.lista.equals(x.getLista());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Encomenda:: {");
        sb.append("Preço: ").append(this.preco);
        sb.append("Dimensão: ").append(this.dimensao);
        sb.append("Estado: ").append(this.estado);
        sb.append("Data: ").append(this.data);
        sb.append("Lista de Artigos:").append(this.lista).append("}");
        return sb.toString();
    }

    public double calculaPreco(){
        int r = 0;
        for (Artigos a : this.lista){
            if(a.getEstado().equals(Artigos.Estado.Novo)){
                r += a.getPrecoDesconto() + 0.5; // + taxa da transportadora
            }
            else r += a.getPrecoDesconto() + 0.25; // + taxa da transportadora
        }
        return r;
    }
}

