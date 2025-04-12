package ProgettoEsercizio.start;
import ProgettoEsercizio.model.Dog;
import ProgettoEsercizio.model.Owner;

public class Startup {
    public static void main(String[] args) {
        Owner eugenio= new Owner();
        eugenio.setName("Eugenio");
        eugenio.setSurname("Manganelli");
        eugenio.setAge(27);

        Dog chico = new Dog();
        chico.setName("Chico");
        chico.setBreed("Maltese");
        chico.setAge(15);
        chico.setOwner(eugenio);

        System.out.println(chico);
        System.out.println(chico+" "+chico.getOwner());
        chico.bark();
        chico.sleep();
    }

}
