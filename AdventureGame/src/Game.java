import java.util.Scanner;

public class Game {
    Scanner scanner=new Scanner(System.in);


    public void start(){
        System.out.println("Macera oyununa hoşgeldiniz.\n" +
                "lütfen isminizi giriniz : ");
        String playerName= scanner.nextLine();
        Player player=new Player(playerName);
        System.out.println("merhaba "+player.getName()+" macera oyununa hoşgeldiniz ");
        player.selectChar();
        player.selectLoc();


    }

}
