import java.time.LocalDate;

public class TShirt {

    private int tamanho;
    private int padrao; //enum

    public TShirt() {
        tamanho = 0;
        padrao = 0;
    }

    public TShirt(int tamanho, int padrao) {
        this.tamanho = tamanho;
        this.padrao = padrao;
    }

    public int getTamanho() {
        return tamanho;
    }

    public int getPadrao() {
        return padrao;
    }

    public TShirt(TShirt t) {
        this.tamanho = t.getTamanho();
        this.padrao = t.getPadrao();
    }


    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public void setPadrao(int padrao) {
        this.padrao = padrao;
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
                le.getPadrao() == this.padrao;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("T-Shirt:: {");
        sb.append("Tamanho: ").append(this.tamanho);
        sb.append("Padrão: ").append(this.padrao).append("}");
        return sb.toString();
    }
}
