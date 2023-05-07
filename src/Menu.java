import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private List<String> options;
    private int choice;

    public Menu(String[] options) {
        this.options = Arrays.asList(options);
        this.choice = 0;
    }

    public int getChoice() {
        return choice;
    }

    public void executeMenu() {
        do {
            showMenu();
            this.choice = readChoice();
        } while(this.choice == -1);
    }

    public void showMenu() {
        System.out.println("-----MENU-----");
        for(int i = 0; i < this.options.size(); i++) {
            System.out.println(i+1 + " - " + this.options.get(i));
        }
        System.out.println("0 - EXIT");
    }

    public int readChoice() {
        int choice;
        Scanner sc = new Scanner(System.in);
        System.out.print("Choice: ");
        try{
            choice = sc.nextInt();
        } catch(Exception e) {
            choice = -1;
        }
        if(choice < 0 || choice > this.options.size()){
            choice = -1;
            System.out.println("INVALID CHOICE!");
        }
        return choice;
    }

    public void run() {
        do {
            executeMenu();
            switch (getChoice()) {
                case 1:
                    System.out.println("Escolheu adicionar!");
                    break;
                case 2:
                    System.out.println("Escolheu remover!");
                    break;
            }
        } while (choice != 0);
    }

}
