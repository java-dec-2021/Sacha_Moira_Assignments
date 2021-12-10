public abstract class Mammal {

    public int energy;
    public String name;

    public Mammal(int energy, String name){
        this.energy=energy;
        this.name=name;
    }
    public void sleep(){
      System.out.printf("%s goes to sleep.", this.name);
      this.regainEnergy("sleep");
    }
    public abstract void eat();
    public abstract void expendEnergy(String action);
    public abstract void regainEnergy(String action);
}
