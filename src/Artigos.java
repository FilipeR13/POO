public class Artigos {
    private String tipo;
    private String estado;
    private String danos;
    private String descricao;
    private String marca;
    private int codigo;
    private double preco;
    private double preco_desconto;

    public Artigos() {
        tipo = null;
        estado = null;
        danos = null;
        descricao = null;
        marca = null;
        codigo = 0;
        preco = 0;
        preco_desconto = 0;
    }

    public Artigos(String tipo, String estado, String danos, String descricao, String marca, int codigo, double preco, double preco_desconto) {
        this.tipo = tipo;
        this.estado = estado;
        this.danos = danos;
        this.descricao = descricao;
        this.marca = marca;
        this.codigo = codigo;
        this.preco = preco;
        this.preco_desconto = preco_desconto;
    }

    public String getTipo() {
        return tipo;
    }

    public String getEstado() {
        return estado;
    }

    public String getDanos() {
        return danos;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getMarca() {
        return marca;
    }

    public int getCodigo() {
        return codigo;
    }

    public double getPreco() {
        return preco;
    }

    public double getPrecoDesconto() {
        return preco_desconto;
    }

    public Artigos( Artigos a) {
        this.tipo = a.getTipo();
        this.estado = a.getEstado();
        this.danos = a.getDanos();
        this.descricao = a.getDescricao();
        this.marca = a.getMarca();
        this.codigo = a.getCodigo();
        this.preco = a.getPreco();
        this.preco_desconto = a.getPrecoDesconto();
    }


    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    public void setDanos(String danos) {
        this.danos = danos;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setPrecoDesconto(double preco_desconto) {
        this.preco_desconto = preco_desconto;
    }

    public Artigos clone() {
        return new Artigos(this);
    }

    public boolean equals(Object obj) {
        if(obj==this)
            return true;
        if(obj==null || obj.getClass() != this.getClass())
            return false;
        Artigos le = (Artigos) obj;
        return le.getTipo().equals(this.tipo) &&
                le.getEstado().equals(this.estado) &&
                le.getDanos().equals(this.danos) &&
                le.getDescricao().equals(this.descricao) &&
                le.getMarca().equals(this.marca) &&
                le.getCodigo() == this.codigo &&
                le.getPreco() == this.preco &&
                le.getPrecoDesconto() == this.preco_desconto;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Artigo:: {");
        sb.append("Tipo: ").append(this.tipo);
        sb.append("Estado: ").append(this.estado);
        sb.append("Danos: ").append(this.danos);
        sb.append("Descrição: ").append(this.descricao);
        sb.append("Marca: ").append(this.marca);
        sb.append("Código: ").append(this.codigo);
        sb.append("Preço: ").append(this.preco);
        sb.append("Preço com Desconto: ").append(this.preco_desconto).append("}");
        return sb.toString();
    }
}