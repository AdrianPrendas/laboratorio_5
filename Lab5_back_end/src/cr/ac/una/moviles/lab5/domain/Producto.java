package cr.ac.una.moviles.lab5.domain;

/**
 *
 * @author _Adrián_Prendas_
 */
public class Producto implements Jsonable {
    int id;
    String nombre;
    String imageUri;
    float precio;
    int cantidad;

    public Producto(){}
    
    public Producto(int id, String nombre, String imageUri, float precio, int cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.imageUri = imageUri;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
}
