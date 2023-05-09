import java.time.LocalDate;
import java.time.Year;
import java.time.temporal.ChronoUnit;

public class Malas extends Artigos{

    public enum Dimensao {
        Pequena,
        Media,
        Grande
    }
    private Dimensao dimensao;
    private String material;
    private LocalDate date;

    public Malas () {
        super();
        dimensao = null;
        material = null;
        date = null;
    }

    public Malas (Dimensao dimensao, String material, LocalDate date, Estado estado, String danos, int nDonos, String descricao, String marca, String codigo,String user_Id, Transportadora transportadora, double preco, double preco_desconto) {
        super (estado, danos, nDonos, descricao, marca, codigo,user_Id,transportadora,preco, preco_desconto);
        this.dimensao = dimensao;
        this.material = material;
        this.date = date;
    }

    public Malas (Malas a) {
        super (a);
        dimensao = a.getDimensao();
        material = a.getMaterial();
        date = a.getDate();
    }

    public LocalDate getDate() {
        return date;
    }

    public Dimensao getDimensao() {
        return dimensao;
    }

    public String getMaterial() {
        return material;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setDimensao(Dimensao dimensao) {
        this.dimensao = dimensao;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public boolean equals(Object obj) {
        if(obj==this)
            return true;
        if(obj==null || obj.getClass() != this.getClass())
            return false;
        Malas le = (Malas) obj;
        return  super.equals(le) &&
                le.getDimensao() == this.dimensao &&
                le.getMaterial().equals(this.material) &&
                le.getDate().equals(this.getDate());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Mala:: {");
        sb.append("Dimensao: ").append(this.dimensao);
        sb.append("Material: ").append(this.material);
        sb.append("Ano:").append(this.date).append("}");
        return super.toString() + sb.toString();
    }

    public Malas clone () {
        return new Malas (this);
    }

    public void calculaDesconto () {
        if(this.dimensao == Dimensao.Pequena) this.setPrecoDesconto(this.getPreco() - this.getPreco() * (0.3 + 0.05 * (ChronoUnit.YEARS.between(this.date, LocalDate.now()))));
        if(this.dimensao == Dimensao.Media) this.setPrecoDesconto(this.getPreco() - this.getPreco() * (0.2 + 0.05 * (ChronoUnit.YEARS.between(this.date, LocalDate.now()))));
        if(this.dimensao == Dimensao.Grande) this.setPrecoDesconto(this.getPreco() - this.getPreco() * (0.1 + 0.05 * (ChronoUnit.YEARS.between(this.date, LocalDate.now()))));
    }
}
