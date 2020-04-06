package Items;

public class Servicio implements Item {

    private Long precio;

    public Servicio(Long precio) {
        this.precio = precio;
    }

    @Override
    public Long getPrecio() {
        return precio;
    }
}
