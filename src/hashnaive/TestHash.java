package hashnaive;

import java.util.HashMap;

public class TestHash {
    public static void main(String[] args) {
        HashMap<Carnet,Persona> lista = new HashMap<Carnet, Persona>();

        Carnet c1 = new Carnet(3565551,"LP");
        Persona p1 = new Persona("Juan Perez", c1);

        lista.put(c1, p1);

        c1 = new Carnet(2255489,"SC");
        p1 = new Persona("Daniel Martinez", c1);

        lista.put(c1, p1);

        Carnet b1 = new Carnet(3565551,"LP");
        Persona p2 = lista.get(b1);
        System.out.println(p2);
    }
}
