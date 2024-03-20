public class Armour {
    private String name;
    private int id;
    private int block;
    private  int price;

    public  Armour(String name, int id, int block, int price) {
        this.name = name;
        this.id = id;
        this.block = block;
        this.price = price;
    }
    public static Armour[] armours(){
        Armour[] armourList=new Armour[3];
        armourList[0]=new Armour("Hafif zırh ",1,1,15);
        armourList[1]=new Armour("Orta zırh  ",2,3,25);
        armourList[2]=new Armour("Ağır zırh  ",3,5,40);
        return armourList;
    }
    public static Armour getArmourObjId(int id){
        for (Armour a:Armour.armours()){
            if (a.getId()==id){
                return a;
            }
        }
        return null;
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

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
