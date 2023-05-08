public class Transportadora {
    private double valorBasePeq, valorBaseMed, valorBaseGra;
    private String id;
    private String transportadora;

    public Transportadora() {
        valorBaseGra = -1;
        valorBasePeq = -1;
        valorBaseMed = -1;
        id = "";
        transportadora = null;
    }

    public Transportadora(double valorBaseGra1, double valorBaseMed1, double valorBasePeq1, String id, String transportadora1) {
        this.id = id;
        this.valorBaseMed = valorBaseMed1;
        this.valorBaseGra = valorBaseGra1;
        this.valorBasePeq = valorBasePeq1;
        this.transportadora = transportadora1;
    }

    public Transportadora(Transportadora t) {
        this.id = t.getId();
        this.valorBaseMed = t.getValorBaseMed();
        this.valorBaseGra = t.getValorBaseGra();
        this.valorBasePeq = t.getValorBasePeq();
        this.transportadora = t.getTransportadora();
    }

    public void setId(String id) {
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

    public String getId() {
        return id;
    }

    public String getTransportadora() {
        return transportadora;
    }

    public Transportadora clone() {
        return new Transportadora(this);
    }

    public boolean equals(Object obj) {
        if(obj==this)
            return true;
        if(obj==null || obj.getClass() != this.getClass())
            return false;
        Transportadora x = (Transportadora) obj;
        return  x.getId().equals(this.id) &&
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
