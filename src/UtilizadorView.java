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
        conta.setHandler(2,user :: adicionaArtigo);

        conta.run();
    }
}
