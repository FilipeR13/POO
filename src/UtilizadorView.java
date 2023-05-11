public class UtilizadorView {
    private UtilizadorController user;

    public UtilizadorView (UtilizadorController user) {
        this.user = user;
    }

    public void run () {
        Menu conta = new Menu(new String[] {
                "Comprar Artigos",
                "Vender Artigos",
                "Ver Carrinho",
                "Ver Encomendas"
        });

        conta.setHandler(1,user :: compraArtigo);
        conta.setHandler(2,this :: adicionaArtigo);
        conta.run();
    }

    public void adicionaArtigo () {
        Menu tipoArtigo = new Menu(new String[] {
                "Sapatilha",
                "Mala",
                "TShirt"
        });
        tipoArtigo.setHandler(1,user :: adicionaSapatilha);
        tipoArtigo.setHandler(2,user :: adicionaMala);
        tipoArtigo.setHandler(3,user :: adicionaTshirt);
        tipoArtigo.run();
    }

    public void verCarrinho () {
        Menu efetuaCompra = new Menu (new String[] {
                "Validar Carrinho"
        });
        user.printCarrinho();
        efetuaCompra.setHandler(1,user :: validaCarrinho);
    }
}
