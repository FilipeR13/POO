import com.sun.jdi.connect.Connector;

import java.util.Map;
import java.util.Scanner;

public class AdminController {
    Vintage v;

    public AdminController (Vintage v) {
        this.v = v;
    }

    public void verTransportadoras  () {
        int index = 1;
        for (Map.Entry<String, Transportadora> a : v.getTransportadoras().entrySet()) {
            Transportadora t = a.getValue();
            System.out.println(index + " -> " + t.getTransportadora());
            index++;
        }
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
        System.out.print("Valor base para encomendas grandes :: ");
        t.setValorBaseGra(sc.nextDouble());
        System.out.println("Fórmula do preço de expedição :: (ValorBase ∗ margemlucrotransportadora ∗ (1 + Imposto)) ∗ 0.9");
        System.out.print("Margem de lucro da transportadora :: ");
        t.setMargemLucro(sc.nextDouble());
        return t;
    }

    public void removeTransportadora () {
        this.verTransportadoras();
        Scanner sc = new Scanner(System.in);
        System.out.print("Transportadora a remover (ID): ");
        String codigo = sc.nextLine();
        while (!v.getTransportadoras().containsKey(codigo)) {
            System.out.println("Codigo não existe");
            System.out.println("Transportadora a remover (ID): ");
            codigo = sc.nextLine();
        }

        v.getTransportadoras().remove(codigo);
    }

    public void avancaTempo () {
        Scanner sc = new Scanner(System.in);
        System.out.print("Insira o número de dias para avançar");
        int dias = sc.nextInt();
        v.setCurrentDate(v.getCurrentDate().plusDays(dias));
    }
}
