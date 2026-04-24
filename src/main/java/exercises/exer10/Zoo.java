package exercises.exer10;

public class Zoo {
    private Animal[] jaulas = new Animal[10];
    public Zoo(){
        for(int i = 0; i<3;i++){
            jaulas[i] = new Lion("Lion-"+i+1);
            jaulas[i+3] = new Owl("Owl-"+i+1);
            jaulas[i+6] = new Wolf("Wolf-"+i+1);
        }
        jaulas[9]= new Lion("Lion-4");
    }

    public void percorre_jaula(){
        for(Animal current : jaulas){
            current.makeSound();
            if(current instanceof Lion currentLion){
                currentLion.run();
            }
            if(current instanceof Wolf currentWolf){
                currentWolf.run();
            }
        }
    }

}
