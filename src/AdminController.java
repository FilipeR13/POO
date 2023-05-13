import com.sun.jdi.connect.Connector;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AdminController {
    Vintage v;

    public AdminController (Vintage v) {
        this.v = v;
    }

    public void verTransportadoras() {
        int index = 1;
        if(!v.getTransportadoras().isEmpty()){
            for (Map.Entry<String, Transportadora> a : v.getTransportadoras().entrySet()) {
                Transportadora t = a.getValue();
                System.out.println(index + " -> " + t.getTransportadora());
                index++;
            }
        }
        else System.out.println("Não existem transportadoras!");
    }

    public void alterarTransportadora () {
        Scanner sc = new Scanner(System.in);
        System.out.print("Transportadora a alterar (nome) :: ");
        Transportadora t = v.getTransportadoras().get(sc.nextLine());
        System.out.print("Novo nome :: ");
        t.setTransportadora(sc.nextLine());
        System.out.print("Novo valor base para encomendas pequenas :: ");
        t.setValorBasePeq(Read_Scanner.getInt(sc));
        System.out.print("Novo valor base para encomendas médias :: ");
        t.setValorBaseMed(Read_Scanner.getInt(sc));
        System.out.print("Novo valor base para encomendas grandes :: ");
        t.setValorBaseGra(Read_Scanner.getInt(sc));
        if(t instanceof TransportadoraPremium) System.out.println("Fórmula do preço de expedição :: (ValorBase - (ValorBase * Imposto)) * 0.2 + (margemlucrotransportadora * ValorBase)");
        else System.out.println("Fórmula do preço de expedição :: (ValorBase ∗ margemlucrotransportadora ∗ (1 + Imposto)) ∗ 0.9");
        System.out.print("Nova margem de lucro da transportadora :: ");
        t.setMargemLucro(Read_Scanner.getDouble(sc));
    }

    public Transportadora registerTransportadora () {
        int premium = -1;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Premium (sim -> 1 ou não -> 0) :: ");
            premium = Read_Scanner.getInt(sc);
            sc.nextLine();
        }while(premium != 1 && premium != 0);
        Transportadora t;
        if(premium == 1) t = new TransportadoraPremium();
        else t  = new Transportadora();
        System.out.print("Nome :: ");
        t.setTransportadora(sc.nextLine());
        System.out.print("Valor base para encomendas pequenas :: ");
        t.setValorBasePeq(Read_Scanner.getDouble(sc));
        System.out.print("Valor base para encomendas médias :: ");
        t.setValorBaseMed(Read_Scanner.getDouble(sc));
        System.out.print("Valor base para encomendas grandes :: ");
        t.setValorBaseGra(Read_Scanner.getDouble(sc));
        if(premium == 1) System.out.println("Fórmula do preço de expedição :: (ValorBase - (ValorBase * Imposto)) * 0.2 + (margemlucrotransportadora * ValorBase)");
        else System.out.println("Fórmula do preço de expedição :: (ValorBase ∗ margemlucrotransportadora ∗ (1 + Imposto)) ∗ 0.9");
        System.out.print("Margem de lucro da transportadora :: ");
        t.setMargemLucro(Read_Scanner.getDouble(sc));
        return t;
    }

    public void removeTransportadora () {
        if(!v.getTransportadoras().isEmpty()) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Transportadora a remover (nome) :: ");
            String nome = sc.nextLine();
            while (!v.getTransportadoras().containsKey(nome)) {
                System.out.println("Não existe uma transportadora com esse nome!");
                System.out.print("Transportadora a remover (nome) :: ");
                nome = sc.nextLine();
            }
            v.getTransportadoras().remove(nome);
        }
        else System.out.println("Não existem transportadoras para remover!");
    }

    public void avancaTempo () {
        Scanner sc = new Scanner(System.in);
        System.out.print("Insira o número de dias para avançar :: ");
        int dias = Read_Scanner.getInt(sc);
        v.addDays(v.getCurrentDate().plusDays(dias));
    }

    public void utilizadorMaisRendeu() {
        Scanner sc = new Scanner(System.in);
        String email = null;
        System.out.print("Deseja definir um intervalo de tempo (1 -> sim ou 0 -> não) :: ");
        if(Read_Scanner.getInt(sc) == 1) {
            sc.nextLine();
            System.out.print("Insira a data inicial: ");
            LocalDate dateI = Read_Scanner.getData(sc);
            System.out.print("Insira a data final: ");
            LocalDate dateF = Read_Scanner.getData(sc);
            email = v.utilizadorMaisRendeu(dateI, dateF);
        }
        else email = v.utilizadorMaisRendeu(null, null);
        System.out.println("O utilizador que mais rendeu foi :: " + email);
    }

    public void lucrouVintage() {
        System.out.println("A Vintage lucrou : " + v.lucrouVintage());
    }
}
