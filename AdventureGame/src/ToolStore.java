public class ToolStore extends NormalLoc{
    public ToolStore(Player player, String name) {
        super(player, name);
    }

    @Override
   public boolean onLocation() {
        System.out.println("mağazaya hoşgeldiniz");
        System.out.println("1.silhalar");
        System.out.println("2.zırhlar");
        System.out.println("3. çıkış yap");
        System.out.print("seçiminiz: ");
        int selectionCase = scanner.nextInt();
        while (selectionCase < 1 || selectionCase > 3) {
            System.out.println("geçersiz değer tekrar değer giriniz:  ");
            selectionCase = scanner.nextInt();
        }
        switch (selectionCase) {
            case 1:
                printVepon();
                buyWepon();
                break;
            case 2:
                printArmour();
                buyArmour();
                break;
            case 3:
                System.out.println("çıkış yapılıyor");
                break;
            default:
                System.out.println("yanlış değer girilid. tekrar girin");

        }


        return true;
    }

    public void printVepon() {
        //silahları yazdırma
        System.out.println("silahlar  ");
        for (Weapon w : Weapon.weapons()) {
            System.out.println("ID: " + w.getId() + " - " + w.getName() + "para " + w.getPrice() + " hasar " + w.getDamage());
        }
        System.out.println("4 - çıkış yap");


    }

    public void buyWepon() {
        // silah satın alma
        boolean choice = true;
        while (choice) {
            System.out.println("Lütfen bir silah seçiniz: ");
            int selectWeapon = scanner.nextInt();
            if (selectWeapon != 4) {
                //çıkış değerin eşit değilse satın alma devam eder
                while (selectWeapon < 1 || selectWeapon > Weapon.weapons().length) {
                    System.out.println("geçersiz değer tekrar girin:");
                    selectWeapon = scanner.nextInt();
                }
                Weapon selectedWeapon = Weapon.getWeponObjById(selectWeapon);
                if (selectedWeapon != null) {
                    if (selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
                        System.out.println("yeterli paranız bulunmamaktadır.");
                    } else {
                        System.out.println(selectedWeapon.getName() + " Silahını satın aldınız.");// satın almanın gerçekleştiği yer
                        int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                        this.getPlayer().setMoney(balance);
                        System.out.println("kalan paranız:  " + this.getPlayer().getMoney());

                        System.out.println("önceki silahınız: " + this.getPlayer().getInventory().getWeapon().getName());
                        this.getPlayer().getInventory().setWeapon(selectedWeapon);
                        System.out.println("yeni silhaınız: " + getPlayer().getInventory().getWeapon().getName());
                        choice=false;


                    }
                }
            }
        }


    }

    public void printArmour() {
        //zıthları yazdıma
        System.out.println("zırhlar ");
        for (Armour a : Armour.armours()) {
            System.out.println("ID: " + a.getId() + " - " + a.getName() + "para: " + a.getPrice() + " blok:  " + a.getBlock());

        }
        System.out.println("4 - çıkış yap");
    }

    public void buyArmour() {
        // zırh satın alma
        boolean chocie = true;
        while (chocie) {
            System.out.println("lütfen bir Zırh seçin:");
            int selectArmour = scanner.nextInt();
            if (selectArmour != 4) {
                //çıkış değerin eşit değilse satın alma devam eder
                while (selectArmour < 1 || selectArmour > Armour.armours().length) {
                    System.out.println("yanlış Değer girdinşz lütfen tekrar değer giriniz");
                    selectArmour = scanner.nextInt();
                }
                Armour selectedArmour = Armour.getArmourObjId(selectArmour);
                if (selectedArmour != null) {
                    System.out.println("seçiminiz: " + Armour.getArmourObjId(selectArmour).getName());
                    if (selectedArmour.getPrice() > this.getPlayer().getMoney()) {
                        System.out.println("yetrli paranız bulunmamaktadır.");
                    } else {
                        int balance = this.getPlayer().getMoney() - selectedArmour.getPrice();
                        this.getPlayer().setMoney(balance);
                        System.out.println("kalan parnız: " + getPlayer().getMoney());
                        System.out.println("önceki Zırhınız: " + getPlayer().getInventory().getArmour().getName());
                        this.getPlayer().getInventory().setArmour(selectedArmour);
                        System.out.println("yeni zırhınız: " + getPlayer().getInventory().getArmour().getName());
                        chocie=false;

                    }
                }
            }
        }

    }
}
