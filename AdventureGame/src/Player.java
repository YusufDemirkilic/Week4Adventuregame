import java.util.Scanner;

public class Player {

    private int damage;
    private int helthy;
    private int orginhelth;
    private int money;
    private String name;
    private String charName;
    private Inventory inventory;
    Scanner scanner = new Scanner(System.in);

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public void selectChar() {
        // sırası ile karakterleri yazdırma
        GameCharacter[] charList = {new Samurai(), new Knight(), new Archer()};
        for (GameCharacter gameCharacters : charList) {//oyun karakterleri sırası ile yazdırma
            System.out.println("ID:      " + gameCharacters.getId() + "\n" +
                    "Karakter:   " + gameCharacters.getName() + "\n" +
                    "Hasar:     " + gameCharacters.getDamage() + "\n" +
                    "Sağlık:    " + gameCharacters.getHealth() + "\n" +
                    "Para:      " + gameCharacters.getMoney() + "\n");

        }
        System.out.println("=====================================\n" +
                "lütfen bir karakter seçiniz: ");
        int selectChar = scanner.nextInt();

        switch (selectChar) {
            case 1:
                initPlayer(new Samurai());
                printInfo();
                break;
            case 2:
                initPlayer(new Knight());
                printInfo();
                break;
            case 3:
                initPlayer(new Archer());
                printInfo();
                break;
            default:
                initPlayer(new Samurai());


        }



    }

    public void selectLoc(){
        //locasyon seçe
        Location location = null;
        boolean showMenu=true;
        while (showMenu) {
            System.out.println("Bolgeler");
            System.out.println("1 - Güvenli Ev");
            System.out.println("2 - Magaza");
            System.out.println("3 - Çıkış yap ");
            System.out.println("4 - Mağara");
            System.out.println("5 - Orman");
            System.out.println("& - Nehir");
            System.out.print("Lütfen gitmek istediginiz bölgeyi seginiz : ");
            int selectLoc = scanner.nextInt();

            switch (selectLoc) {
                case 1:
                    location = new SafeHouse(this,name);
                    break;
                case 2:
                    location = new ToolStore(this,name);
                    break;
                case 3:
                    System.out.println("bir daha bekleriz");
                    showMenu=false;
                    break;
                case 4:
                    System.out.println(" Mağaraya ");
                    location=new Cave(this);
                    break;
                case 5:
                    System.out.println(" Orman ");
                    location=new Forest(this);
                    break;
                case 6:
                    System.out.println(" Nehir ");
                    location=new River(this);
                    break;
                default:
                    location = new SafeHouse(this,name);

            }
            if (!location.onLocation()) {
                System.out.println("game over !");
                break;
            }

        }
    }
    public void initPlayer(GameCharacter gameCharacter) {
        //seçilen karakteri atama
        this.setDamage(gameCharacter.getDamage());
        this.setHelthy(gameCharacter.getHealth());
        this.setMoney(gameCharacter.getHealth());
        this.setName(gameCharacter.getName());
        this.setOrginhelth(gameCharacter.getHealth());
        System.out.println("Seçilen karakter: " + gameCharacter.getName());
    }
    public int getTotalDamage() {
        return this.getDamage() + this.getInventory().getWeapon().getDamage();
    }


    public void printInfo() {
        // seçilen karakter bilgileri yazdırma
        System.out.println("Silahiniz: " + this.getInventory().getWeapon().getName() +
                " Zırh: " + this.getInventory().getArmour().getName() +
                " Bloklama: " + this.getInventory().getArmour().getBlock() +
                " Hasaraniz: " + this.getDamage() +
                " Saglik : " + this.getHelthy() +
                " Para : " + this.getMoney());
    }

    public int getOrginhelth() {
        return orginhelth;
    }

    public void setOrginhelth(int orginhelth) {
        this.orginhelth = orginhelth;
    }

    public int getDamage() {
        return damage + this.getInventory().getWeapon().getDamage();
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHelthy() {
        return helthy + this.getInventory().getArmour().getBlock();
    }

    public void setHelthy(int helthy) {
        this.helthy = helthy;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }
    public Weapon getWepon(){
        return this.getInventory().getWeapon();
    }
}
