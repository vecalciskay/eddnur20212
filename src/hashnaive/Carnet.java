package hashnaive;

import java.util.Objects;

public class Carnet {
    private long numero;
    private String extension;

    public Carnet(long numero, String extension){
        this.numero = numero;
        this.extension = extension;
    }

    @Override
    public String toString() {
        return numero + extension;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carnet carnet = (Carnet) o;
        return numero == carnet.numero && Objects.equals(extension, carnet.extension);
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }
}
