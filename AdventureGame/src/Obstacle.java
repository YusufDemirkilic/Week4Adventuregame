import java.util.Random;

public class Obstacle {
    private int id;
    private String name;
    private int damge;
    private int health;
    private int award;
    private int maxNumber;

    public Obstacle(int id, String  name, int damge, int health,int award,int maxNumber) {
        this.id = id;
        this.name = name;
        this.damge = damge;
        this.health = health;
        this.award=award;
        this.maxNumber=maxNumber;
    }
    public int count() {
        Random r = new Random();
        return r.nextInt(this.getMaxNumber()) + 1;
    }

    public int getMaxNumber() {
        return maxNumber;
    }

    public void setMaxNumber(int maxNumber) {
        this.maxNumber = maxNumber;
    }

    public int getAward() {
        return award;
    }

    public void setAward(int award) {
        this.award = award;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDamge() {
        return damge;
    }

    public void setDamge(int damge) {
        this.damge = damge;
    }

    public int getHealth() {
        return health - this.getDamge();
    }

    public void setHealth(int health) {
        this.health = health;
    }


}
