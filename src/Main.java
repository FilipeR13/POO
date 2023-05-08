import java.time.LocalDate;
import java.time.Month;

public class Main {
    public static void main(String args[]) {
        LocalDate date = LocalDate.of(2010, Month.DECEMBER,12);
        Artigos a = new Malas(Malas.Dimensao.Grande,"Couro",date,Artigos.Estado.Novo,"Nao tem danos",0,"Mala preta de couro","Gucci","000001",109.90,80);
        a.calculaDesconto();
        String[] options = {"Adicionar um Utilizador!", "Remover um Utilizador!"};
        Menu mainMenu = new Menu(options);
        mainMenu.run();

    }
}

