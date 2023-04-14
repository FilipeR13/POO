import java.time.Year;

public class Malas {
    private double dimensao;
    private String material;
    private Year ano;

    public Malas () {
        dimensao = -1;
        material = null;
        ano = Year.now();
    }

    public Malas (double dimensao1, String materia1, Year ano1) {
        dimensao = dimensao1;
        material = materia1;
        ano = Year.of (ano1.getValue());
    }

    public Malas (Malas a) {
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
        return  le.getDimensao() == this.dimensao &&
                le.getMaterial().equals(this.material) &&
                le.getAno() == this.getAno();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Mala:: {");
        sb.append("Dimensao: ").append(this.dimensao);
        sb.append("Material: ").append(this.material);
        sb.append("Ano:").append(this.ano).append("}");
        return sb.toString();
    }
}
