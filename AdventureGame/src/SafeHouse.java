public class SafeHouse extends  NormalLoc{
    public SafeHouse(Player player,String name) {
        super(player,name);

    }

    @Override
   public boolean onLocation() {
        System.out.println("güvenli evdesiniz");
        System.out.println("canının yenileniyor.");
        this.getPlayer().setHelthy(this.getPlayer().getOrginhelth());
        return true;
    }
}
