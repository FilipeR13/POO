public class VintageController {
    private Vintage v;
    private UtilizadorController user;
    private AdminController admin;

    public VintageController(Vintage v, UtilizadorController user, AdminController admin) {
        this.v = v;
        this.user = user;
        this.admin = admin;
    }

    public UtilizadorController getUtilizadorController() {
        return user;
    }
    public AdminController getAdminController() {
        return admin;
    }

    public Vintage getVintage() {
        return v;
    }

    public void registerUtilizador() {
        try {
            v.addUtilizador(user.registerUtilizador());
        } catch (VintageException e){
            System.out.println(e.getMessage());
        }
    }

    public void registerTransportadora () {
        v.addTransportadora(admin.registerTransportadora());
    }
}
