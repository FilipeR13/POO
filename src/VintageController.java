import java.util.HashMap;
import java.util.Map;
public class VintageController {
    private Vintage v;
    private UtilizadorController user;

    public VintageController(Vintage v, UtilizadorController user) {
        this.v = v;
        this.user = user;
    }

    public UtilizadorController getUtilizadorController() {
        return user;
    }

    public Vintage getVintage() {
        return v;
    }

    public void registerUtilizador() {
        v.addUtilizador(user.registerUtilizador());
    }
}
