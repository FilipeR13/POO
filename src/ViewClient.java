import jdk.jshell.execution.Util;

import java.util.Map;

public class ViewClient {
    private VintageController v;

    public ViewClient(VintageController v) {
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
        menuUtilizador.run();
    }

    public void ViewAdmin () {
        Menu menuAdmin = new Menu(new String[] {
                "Adicionar Transportadora",
                "Remover Transportadora",
                "Avançar Tempo"
        });
        menuAdmin.setHandler(1, v ::registerTransportadora);
        menuAdmin.run();
    }

}
