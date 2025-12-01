package Practica6;


public class Main {
    public static void main(String[] args) {
        ProductoDAO dao = new ProductoDAO();

        // Crear producto
        Producto p = new Producto();
        p.setNombre("Laptop");
        p.setPrecio(1200.0);
        dao.create(p);

        // Leer producto
        Producto producto = dao.find(p.getId());
        System.out.println("Producto: " + producto.getNombre());

        // Actualizar producto
        producto.setPrecio(1300.0);
        dao.update(producto);

        // Eliminar producto
        dao.delete(producto.getId());
    }
}

