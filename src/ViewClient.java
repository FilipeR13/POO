import jdk.jshell.execution.Util;

public class ViewClient {
    private VintageController v;

    public ViewClient(VintageController v) {
        this.v = v;
    }

    public void run() {
        Menu menuPrincipal = new Menu(new String[]{
                "Registar",
                "Login"
        });
        menuPrincipal.setHandler(1,v :: registerUtilizador);
        menuPrincipal.run();
    }
}
