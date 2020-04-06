package Items;

public class Articulo implements Item {

    private Long precio;

    public Articulo(Long precio) {
        this.precio = precio;
    }

    @Override
    public Long getPrecio() {
        return precio;
    }

    public void setPrecio(Long precio) {
        this.precio = precio;
    }
}
