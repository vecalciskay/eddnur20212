package arboles;

public class TestArbol {
    public static void main(String[] args) {
        Arbol<Animal> arbol = new Arbol<>();

        Animal perro1 = new Animal("F01","perro",4,true);
        arbol.insertar(perro1, null);

        Animal gato1 = new Animal("G02","gato",3,true);
        arbol.insertar(gato1, perro1.getId());

        Animal gato2 = new Animal("G62","22222",4,true);
        arbol.insertar(gato2, perro1.getId());

        System.out.println(arbol);
    }
}
