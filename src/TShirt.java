import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class TShirt {

    private int tamanho;
    private int padrao; //enum
    private LocalDate date;

    public TShirt() {
        tamanho = 0;
        padrao = 0;
        date = null;
    }

    public TShirt(int tamanho, int padrao, LocalDate date) {
        this.tamanho = tamanho;
        this.padrao = padrao;
        this.date = date;
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

    public TShirt(TShirt t) {
        this.tamanho = t.getTamanho();
        this.padrao = t.getPadrao();
        this.date = t.getDate();
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
        return  le.getTamanho() == this.tamanho &&
                le.getPadrao() == this.padrao &&
                le.getDate().equals(this.date);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("T-Shirt:: {");
        sb.append("Tamanho: ").append(this.tamanho);
        sb.append("Padrão: ").append(this.padrao);
        sb.append("Date: ").append(this.date).append("}");
        return sb.toString();
    }

    public boolean discountAvailable(TShirt t){
        long days = ChronoUnit.DAYS.between(t.getDate(), LocalDate.now());
        if(t.getPadrao() != 1 /*(PADRAO LISO)*/ && days >= 365) return true;
        return false;
    }
}
