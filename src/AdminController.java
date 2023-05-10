import com.sun.jdi.connect.Connector;

import java.util.Map;
import java.util.Scanner;

public class AdminController {
    Map<String, Transportadora> transportadoras;

    public AdminController (Map <String,Transportadora> transportadoras) {
        this.transportadoras = transportadoras;
    }

    public Transportadora registerTransportadora () {
        Transportadora t = new Transportadora();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nome :: ");
        t.setTransportadora(sc.nextLine());
        System.out.print("Valor base para encomendas pequenas :: ");
        t.setValorBasePeq(sc.nextDouble());
        System.out.print("Valor base para encomendas médias :: ");
        t.setValorBaseMed(sc.nextDouble());
        System.out.print("Valor base para encomendas grandes:: ");
        t.setValorBaseGra(sc.nextDouble());
        return t;
    }

    public void removeTransportadora (String id) {
        transportadoras.remove(id);
    }
}
