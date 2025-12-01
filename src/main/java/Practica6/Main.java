package Practica6;


import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProductoDAO dao = new ProductoDAO();

//        // Crear producto
//        Producto p = new Producto();
//        p.setNombre("Laptop");
//        p.setPrecio(1200.0);
//        dao.create(p);
//
//        // Leer producto
//        Producto producto = dao.find(p.getId());
//        System.out.println("Producto: " + producto.getNombre());
//
//        // Actualizar producto
//        producto.setPrecio(1300.0);
//        dao.update(producto);
//
//        // Eliminar producto
//        dao.delete(producto.getId());

        System.out.println("Buscando productos con 'Laptop':");
        List<Producto> resultados = dao.findByName("Laptop");
        resultados.forEach(prod -> System.out.println(prod.getId() + " - " + prod.getNombre() + " - " + prod.getPrecio()));

    }
}

