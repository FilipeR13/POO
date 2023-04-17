import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Sapatilhas extends Artigos{
    private int tamanho;
    private int atacador;  //enum
    private String cor;
    private LocalDate date;

    public Sapatilhas() {
        super ();
        tamanho = 0;
        atacador = 0;
        cor = null;
        date = null;
    }

    public Sapatilhas(int tamanho, int atacador, String cor, LocalDate date, String tipo, int estado, String danos, String descricao, String marca, int codigo, double preco, int nDonos) {
        super (tipo, estado, danos, descricao, marca, codigo,preco, nDonos);
        this.tamanho = tamanho;
        this.atacador = atacador;
        this.cor = cor;
        this.date = date;
    }

    public Sapatilhas(Sapatilhas s) {
        super (s);
        this.tamanho = s.getTamanho();
        this.atacador = s.getAtacador();
        this.cor = s.getCor();
        this.date = s.getDate();
    }

    public int getTamanho() {
        return tamanho;
    }

    public int getAtacador() {
        return atacador;
    }

    public String getCor() {
        return cor;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public void setAtacador(int atacador) {
        this.atacador = atacador;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Sapatilhas clone() {
        return new Sapatilhas(this);
    }

    public boolean equals(Object obj) {
        if(obj==this)
            return true;
        if(obj==null || obj.getClass() != this.getClass())
            return false;
        Sapatilhas le = (Sapatilhas) obj;
        return  super.equals(le) &&
                le.getTamanho() == this.tamanho &&
                le.getAtacador() == this.atacador &&
                le.getCor().equals(this.cor) &&
                le.getDate().equals(this.date);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Sapatilhas:: {");
        sb.append("Tamanho: ").append(this.tamanho);
        sb.append("Atacador: ").append(this.atacador);
        sb.append("Cor: ").append(this.cor);
        sb.append("Date: ").append(this.date).append("}");
        return super.toString() + sb.toString();
    }

    public void calculaDesconto (){
        long days = ChronoUnit.DAYS.between(this.date, LocalDate.now());
        if(days >= 365 || this.getTamanho() > 45 || this.getnDonos() > 0) this.setPrecoDesconto( this.getPreco() / this.getnDonos() * this.getEstado());
    }
}