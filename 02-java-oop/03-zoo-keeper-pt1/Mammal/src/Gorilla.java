public class Gorilla extends Mammal{
    public Gorilla(int energy, String name){
        super(energy, name);
    }
    @Override
    public void eat() {
        System.out.printf("%s eats a banana.\n", this.name);
        this.regainEnergy("eat");
    }
    @Override
    public void expendEnergy(String action){
        if(action == "throw") this.energy-=5;
        else if(action == "climb") this.energy-=10;
        this.displayEnergy();
    }
    @Override
    public void regainEnergy(String action){
        if(action == "eat") this.energy+=10;
        else if(action == "sleep") this.energy+=20;
        this.displayEnergy();
    }
    public void throwThings(){
        System.out.printf("%s throws a rotten banana peel at you!\n", this.name);
        this.expendEnergy("throw");
    }
    public void climb(){
        System.out.printf("%s climbs a tree!\n", this.name);
        this.expendEnergy("climb");
    }
    public void displayEnergy(){
        System.out.printf("%s's current Energy : %d\n", this.name, this.energy);
    }
}
