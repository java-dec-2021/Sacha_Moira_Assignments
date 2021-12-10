public abstract class Mammal {

    public int energy;
    public String name;

    public Mammal(int energy, String name){
        this.energy=energy;
        this.name=name;
    }
    public void sleep(){
      System.out.printf("%s goes to sleep.\n", this.name);
      this.regainEnergy("sleep");
    }
    public void displayEnergy(){
        System.out.printf("%s's current Energy : %d\n", this.name, this.energy);
    }
    public abstract void eat();
    public abstract void expendEnergy(String action);
    public abstract void regainEnergy(String action);
}
