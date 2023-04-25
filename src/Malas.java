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
    private Year ano;

    public Malas () {
        super();
        dimensao = Dimensao.Grande;
        material = null;
        ano = Year.now();
    }

    public Malas (Dimensao dimensao, String materia1, Year ano1, Estado estado, String danos, int nDonos, String descricao, String marca, int codigo, double preco, double preco_desconto) {
        super (estado, danos, nDonos, descricao, marca, codigo, preco, preco_desconto);
        dimensao = dimensao;
        material = materia1;
        ano = Year.of (ano1.getValue());
    }

    public Malas (Malas a) {
        super (a);
        dimensao = a.getDimensao();
        material = a.getMaterial();
        ano = a.getAno();
    }

    public Year getAno() {
        return ano;
    }

    public Dimensao getDimensao() {
        return dimensao;
    }

    public String getMaterial() {
        return material;
    }

    public void setAno(Year ano) {
        this.ano = ano;
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
                le.getAno() == this.getAno();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Mala:: {");
        sb.append("Dimensao: ").append(this.dimensao);
        sb.append("Material: ").append(this.material);
        sb.append("Ano:").append(this.ano).append("}");
        return super.toString() + sb.toString();
    }

    public Malas clone () {
        return new Malas (this);
    }

    public void calculaDesconto () {
        if(this.dimensao == Dimensao.Pequena) this.setPrecoDesconto(this.getPreco() * (0.3 + 0.05 * (ChronoUnit.YEARS.between(this.ano, LocalDate.now()))));
        if(this.dimensao == Dimensao.Media) this.setPrecoDesconto(this.getPreco() * (0.2 + 0.05 * (ChronoUnit.YEARS.between(this.ano, LocalDate.now()))));
        if(this.dimensao == Dimensao.Grande) this.setPrecoDesconto(this.getPreco() * (0.1 + 0.05 * (ChronoUnit.YEARS.between(this.ano, LocalDate.now()))));
    }
}
