public class Bat extends Mammal{
    public Bat(int energy, String name) {
        super(energy, name);
    }
    @Override
    public void eat() {
        System.out.printf("%s eats a human!!!\n", this.name);
        this.regainEnergy("eat");
    }
    @Override
    public void expendEnergy(String action) {
        if(action == "flies") this.energy-=50;
        else if(action == "attack") this.energy-=100;
        this.displayEnergy();
    }
    @Override
    public void regainEnergy(String action) {
        if(action == "eat") this.energy+=25;
        else if(action == "sleep") this.energy+=100;
        this.displayEnergy();
    }
    public void fly(){
        System.out.printf("%s takes to the sky and flies!\n", this.name);
        this.expendEnergy("flies");
    }
    public void attackTown(){
        System.out.printf("%s is attacking the town!!!\n", this.name);
        this.expendEnergy("attack");
    }
}
