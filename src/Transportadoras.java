public class Transportadoras  {
    private double valorBasePeq, valorBaseMed, valorBaseGra;
    private int id;
    private String transportadora;

    public Transportadoras() {
        valorBaseGra = -1;
        valorBasePeq = -1;
        valorBaseMed = -1;
        id = -1;
        transportadora = null;
    }

    public Transportadoras (double valorBaseGra1, double valorBaseMed1, double valorBasePeq1, int id, String transportadora1) {
        this.id = id;
        this.valorBaseMed = valorBaseMed1;
        this.valorBaseGra = valorBaseGra1;
        this.valorBasePeq = valorBasePeq1;
        this.transportadora = transportadora1;
    }

    public Transportadoras(Transportadoras t) {
        this.id = t.getId();
        this.valorBaseMed = t.getValorBaseMed();
        this.valorBaseGra = t.getValorBaseGra();
        this.valorBasePeq = t.getValorBasePeq();
        this.transportadora = t.getTransportadora();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTransportadora(String transportadora) {
        this.transportadora = transportadora;
    }

    public void setValorBaseGra(double valorBaseGra) {
        this.valorBaseGra = valorBaseGra;
    }

    public void setValorBaseMed(double valorBaseMed) {
        this.valorBaseMed = valorBaseMed;
    }

    public void setValorBasePeq(double valorBasePeq) {
        this.valorBasePeq = valorBasePeq;
    }

    public double getValorBaseMed() {
        return valorBaseMed;
    }

    public double getValorBaseGra() {
        return valorBaseGra;
    }

    public double getValorBasePeq() {
        return valorBasePeq;
    }

    public int getId() {
        return id;
    }

    public String getTransportadora() {
        return transportadora;
    }

    public Transportadoras clone() {
        return new Transportadoras(this);
    }

    public boolean equals(Object obj) {
        if(obj==this)
            return true;
        if(obj==null || obj.getClass() != this.getClass())
            return false;
        Transportadoras x = (Transportadoras) obj;
        return  x.getId() == this.id &&
                x.getValorBaseGra() == this.valorBaseGra &&
                x.getValorBaseMed() == this.valorBaseMed &&
                x.getValorBasePeq() == this.valorBasePeq &&
                x.getTransportadora().equals(this.transportadora);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Transportadora:: {");
        sb.append("Id: ").append(this.id);
        sb.append("Nome da Transportadora: ").append(this.transportadora);
        sb.append("Preço Base Encomenda Pequena: ").append(this.valorBasePeq);
        sb.append("Preço Base Encomenda Media: ").append(this.valorBaseMed);
        sb.append("Preço Base Encomenda Grande: ").append(this.valorBaseGra).append("}");
        return sb.toString();
    }
}
