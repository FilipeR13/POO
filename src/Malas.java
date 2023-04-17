import java.time.LocalDate;
import java.time.Year;
import java.time.temporal.ChronoUnit;

public class Malas extends Artigos{
    private double dimensao;
    private String material;
    private Year ano;

    public Malas () {
        super();
        dimensao = -1;
        material = null;
        ano = Year.now();
    }

    public Malas (double dimensao1, String materia1, Year ano1,String tipo, int estado, String danos, String descricao, String marca, int codigo, double preco, int nDonos) {
        super (tipo, estado, danos, descricao, marca, codigo,preco, nDonos);
        dimensao = dimensao1;
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

    public double getDimensao() {
        return dimensao;
    }

    public String getMaterial() {
        return material;
    }

    public void setAno(Year ano) {
        this.ano = ano;
    }

    public void setDimensao(double dimensao) {
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
        long days = ChronoUnit.DAYS.between(this.ano, LocalDate.now());
        if(days >= 365 || this.getnDonos() > 0) this.setPrecoDesconto(1/this.dimensao + 1 / ChronoUnit.YEARS.between(this.ano, LocalDate.now()));
    }
}
