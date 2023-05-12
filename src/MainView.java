public class MainView {
    private VintageController v;

    public MainView(VintageController v) {
        this.v = v;
    }

    public void run() {
        Menu menuPrincipal = new Menu(new String[]{
                "Utilizador",
                "Admin"
        });
        menuPrincipal.setHandler(1,this :: ViewUtilizador);
        menuPrincipal.setHandler(2,this :: ViewAdmin);
        menuPrincipal.run();
    }

    public void ViewUtilizador () {
        Menu menuUtilizador = new Menu (new String[] {
                "Register",
                "Login"
        });
        menuUtilizador.setHandler(1, v :: registerUtilizador);
        menuUtilizador.setHandler(2, v :: login);
        menuUtilizador.run();
    }

    public void ViewAdmin () {
        Menu menuAdmin = new Menu(new String[] {
                "Adicionar Transportadora",
                "Remover Transportadora",
                "Gerir Transportadoras",
                "Avançar Tempo"
        });
        menuAdmin.setHandler(1, v ::registerTransportadora);
        menuAdmin.setHandler(2, v ::removeTransportadora);
        menuAdmin.setHandler(3, this ::menuTransportadoras);
        menuAdmin.setHandler(4, v ::avancarTempo);
        menuAdmin.run();
    }

    public void menuTransportadoras() {
        Menu menuTransportadoras = new Menu(new String[] {
                "Ver transportadoras",
                "Alterar transportadora"
        });
        menuTransportadoras.setHandler(1, v ::verTransportadoras);
        menuTransportadoras.setHandler(2, v ::alterarTransportadora);
        menuTransportadoras.run();
    }
}
