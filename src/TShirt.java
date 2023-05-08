import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class TShirt extends Artigos{

    public enum Tamanho {
        S,
        M,
        L,
        XL
    }

    public enum Padrao {
        Liso,
        Riscas,
        Palmeiras
    }

    private Tamanho tamanho;
    private Padrao padrao; //enum
    private LocalDate date;

    public TShirt() {
        super ();
        tamanho = null;
        padrao = null;
        date = null;
    }

    public TShirt(Tamanho tamanho, Padrao padrao, LocalDate date, String tipo, Estado estado, String danos, int nDonos, String descricao, String marca, String codigo, double preco, double preco_desconto) {
        super (estado, danos, nDonos, descricao, marca, codigo, preco, preco_desconto);
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

    public Tamanho getTamanho() {
        return tamanho;
    }

    public Padrao getPadrao() {
        return padrao;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setTamanho(Tamanho tamanho) {
        this.tamanho = tamanho;
    }

    public void setPadrao(Padrao padrao) {
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
        if(this.getPadrao() != Padrao.Liso && this.getEstado() == Estado.Usado) this.setPrecoDesconto(this.getPreco() * 0.5);
    }
}
