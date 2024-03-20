public class Inventory {
    private Weapon weapon;
    private Armour armour;
    private boolean food,water,wood;

    public Inventory() {
        this.weapon = new Weapon("yumruk",0,1,0) ;
        this.armour=new Armour("Atlet ",0,0,0);
        this.food=false;
        this.water=false;
        this.wood=false;
    }

    public boolean isFood() {
        return food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public boolean isWater() {
        return water;
    }

    public void setWater(boolean water) {
        this.water = water;
    }

    public boolean isWood() {
        return wood;
    }

    public void setWood(boolean wood) {
        this.wood = wood;
    }

    public Armour getArmour() {
        return armour;
    }

    public void setArmour(Armour armour) {
        this.armour = armour;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
}

