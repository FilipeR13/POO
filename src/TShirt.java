import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class TShirt extends Artigos{

    private int tamanho;
    private int padrao; //enum
    private LocalDate date;

    public TShirt() {
        super ();
        tamanho = 0;
        padrao = 0;
        date = null;
    }

    public TShirt(int tamanho, int padrao, LocalDate date, String tipo, int estado, String danos, String descricao, String marca, int codigo, double preco, int nDonos) {
        super (tipo, estado, danos, descricao, marca, codigo,preco, nDonos);
        this.tamanho = tamanho;
        this.padrao = padrao;
        this.date = date;
    }

    public TShirt(TShirt t) {
        super (t);
        this.tamanho = t.getTamanho();
        this.padrao = t.getPadrao();
        this.date = t.getDate();
    }

    public int getTamanho() {
        return tamanho;
    }

    public int getPadrao() {
        return padrao;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public void setPadrao(int padrao) {
        this.padrao = padrao;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }


    public TShirt clone() {
        return new TShirt(this);
    }

    public boolean equals(Object obj) {
        if(obj==this)
            return true;
        if(obj==null || obj.getClass() != this.getClass())
            return false;
        TShirt le = (TShirt) obj;
        return  super.equals(le) &&
                le.getTamanho() == this.tamanho &&
                le.getPadrao() == this.padrao &&
                le.getDate().equals(this.date);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("T-Shirt:: {");
        sb.append("Tamanho: ").append(this.tamanho);
        sb.append("Padrão: ").append(this.padrao);
        sb.append("Date: ").append(this.date).append("}");
        return super.toString() + sb.toString();
    }

    public void calculaDesconto (){
        long days = ChronoUnit.DAYS.between(this.date, LocalDate.now());
        if(this.getPadrao() != 1 /*(PADRAO LISO)*/ && (days >= 365 || this.getnDonos() > 0)) this.setPrecoDesconto(this.getPreco() * 0.5);
    }
}
