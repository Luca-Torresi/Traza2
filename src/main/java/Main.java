import entidades.*;
import repositorio.Repositorio;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class Main {
    public static void main(String[] args){

        //CATEGORÍAS
        Categoria pizza = Categoria.builder()
                .denominacion("Pizzas")
                .build();
        Categoria sanguches = Categoria.builder()
                .denominacion("Sanguches")
                .build();
        Categoria lomo = Categoria.builder()
                .denominacion("Lomos")
                .build();
        Categoria insumos = Categoria.builder()
                .denominacion("Insumos")
                .build();

        //UNIDADES DE MEDIDA
        UnidadDeMedida kilogramo = UnidadDeMedida.builder()
                .denominacion("Kilogramo")
                .build();
        UnidadDeMedida litro = UnidadDeMedida.builder()
                .denominacion("Litro")
                .build();
        UnidadDeMedida gramo = UnidadDeMedida.builder()
                .denominacion("gramo")
                .build();

        //INSUMOS
        ArticuloInsumo sal = ArticuloInsumo.builder()
                .denominacion("Sal")
                .unidadDeMedida(gramo)
                .precioCompra(300.0)
                .stockActual(2000)
                .stockMaximo(5000)
                .esParaElaborar(true)
                .build();
        ArticuloInsumo aceite = ArticuloInsumo.builder()
                .denominacion("Aceite")
                .unidadDeMedida(litro)
                .precioCompra(18000.0)
                .stockActual(5)
                .stockMaximo(10)
                .esParaElaborar(true)
                .build();
        ArticuloInsumo carne = ArticuloInsumo.builder()
                .denominacion("Carne")
                .unidadDeMedida(kilogramo)
                .precioCompra(4400.0)
                .stockActual(7)
                .stockMaximo(12)
                .esParaElaborar(true)
                .build();
        ArticuloInsumo harina = ArticuloInsumo.builder()
                .denominacion("Harina")
                .unidadDeMedida(kilogramo)
                .precioCompra(650.0)
                .stockActual(6)
                .stockMaximo(9)
                .esParaElaborar(true)
                .build();

        //IMÁGENES
        Imagen imagen1 = Imagen.builder()
                .denominacion("Pizza Hawaiana 1")
                .build();
        Imagen imagen2 = Imagen.builder()
                .denominacion("Pizza Hawaiana 2")
                .build();
        Imagen imagen3 = Imagen.builder()
                .denominacion("Pizza Hawaiana 3")
                .build();
        Imagen imagen4 = Imagen.builder()
                .denominacion("Lomo Completo 1")
                .build();
        Imagen imagen5 = Imagen.builder()
                .denominacion("lomo Completo 2")
                .build();
        Imagen imagen6 = Imagen.builder()
                .denominacion("Lomo Completo 3")
                .build();

        Set<Imagen> imagenesPizza = new HashSet<>();
        imagenesPizza.add(imagen1);
        imagenesPizza.add(imagen2);
        imagenesPizza.add(imagen3);

        Set<Imagen> imagenesLomo = new HashSet<>();
        imagenesLomo.add(imagen4);
        imagenesLomo.add(imagen5);
        imagenesLomo.add(imagen6);

        //DETALLES DE LOS ARTÍCULOS
        ArticuloManufacturadoDetalle detallePizzaHawaiana1 = ArticuloManufacturadoDetalle.builder()
                .insumo(sal)
                .cantidad(1)
                .build();
        ArticuloManufacturadoDetalle detallePizzaHawaiana2 = ArticuloManufacturadoDetalle.builder()
                .insumo(harina)
                .cantidad(2)
                .build();
        ArticuloManufacturadoDetalle detallePizzaHawaiana3 = ArticuloManufacturadoDetalle.builder()
                .insumo(aceite)
                .cantidad(1)
                .build();

        Set<ArticuloManufacturadoDetalle> detallesPizza = new HashSet<>();
        detallesPizza.add(detallePizzaHawaiana1);
        detallesPizza.add(detallePizzaHawaiana2);
        detallesPizza.add(detallePizzaHawaiana3);

        ArticuloManufacturadoDetalle detalleLomoCompleto1 = ArticuloManufacturadoDetalle.builder()
                .insumo(sal)
                .cantidad(1)
                .build();
        ArticuloManufacturadoDetalle detalleLomoCompleto2 = ArticuloManufacturadoDetalle.builder()
                .insumo(aceite)
                .cantidad(1)
                .build();
        ArticuloManufacturadoDetalle detalleLomoCompleto3 = ArticuloManufacturadoDetalle.builder()
                .insumo(carne)
                .cantidad(1)
                .build();

        Set<ArticuloManufacturadoDetalle> detallesLomo = new HashSet<>();
        detallesLomo.add(detalleLomoCompleto1);
        detallesLomo.add(detalleLomoCompleto2);
        detallesLomo.add(detalleLomoCompleto3);

        //ARTÍCULOS
        ArticuloManufacturado pizzaHawaina = ArticuloManufacturado.builder()
                .denominacion("Pizza Hawaiana")
                .precioVenta(9800.0)
                .imagenes(imagenesPizza)
                .descripcion("Pizza casera con ananá")
                .tiempoEstimadoMinutos(30)
                .detalles(detallesPizza)
                .build();

        ArticuloManufacturado lomoCompleto = ArticuloManufacturado.builder()
                .denominacion("Lomo Completo")
                .precioVenta(13500.0)
                .imagenes(imagenesLomo)
                .descripcion("Lomo completo con papas")
                .tiempoEstimadoMinutos(45)
                .detalles(detallesLomo)
                .build();

        //Establecemos el artículo correspondiente para cada una de las imágenes
        imagen1.setArticulo(pizzaHawaina);
        imagen2.setArticulo(pizzaHawaina);
        imagen3.setArticulo(pizzaHawaina);

        imagen4.setArticulo(lomoCompleto);
        imagen5.setArticulo(lomoCompleto);
        imagen6.setArticulo(lomoCompleto);

        //Así como también para cada uno de los detalles de artículos manufacturados
        for(ArticuloManufacturadoDetalle a:detallesPizza){
            a.setArticulo(pizzaHawaina);
        }

        for(ArticuloManufacturadoDetalle a:detallesLomo){
            a.setArticulo(lomoCompleto);
        }

        //Por último, creamos un repositorio para cada clase y guardamos los objetos correspondientes
        Repositorio<Categoria> repoCategoria = new Repositorio<Categoria>();
        repoCategoria.guardar(pizza);
        repoCategoria.guardar(sanguches);
        repoCategoria.guardar(insumos);
        repoCategoria.guardar(lomo);

        Repositorio<UnidadDeMedida> repoUnidadDeMedida = new Repositorio<>();
        repoUnidadDeMedida.guardar(kilogramo);
        repoUnidadDeMedida.guardar(litro);
        repoUnidadDeMedida.guardar(gramo);

        Repositorio<Imagen> repoImagen = new Repositorio<>();
        repoImagen.guardar(imagen1);
        repoImagen.guardar(imagen2);
        repoImagen.guardar(imagen3);
        repoImagen.guardar(imagen4);
        repoImagen.guardar(imagen5);
        repoImagen.guardar(imagen6);

        Repositorio<ArticuloInsumo> repoArticuloInsumo = new Repositorio<>();
        repoArticuloInsumo.guardar(sal);
        repoArticuloInsumo.guardar(aceite);
        repoArticuloInsumo.guardar(carne);
        repoArticuloInsumo.guardar(harina);

        Repositorio<ArticuloManufacturado> repoArticuloManufacturado = new Repositorio<>();
        repoArticuloManufacturado.guardar(pizzaHawaina);
        repoArticuloManufacturado.guardar(lomoCompleto);

        Repositorio<ArticuloManufacturadoDetalle> repoArticuloManufacturadoDetalle = new Repositorio<>();
        repoArticuloManufacturadoDetalle.guardar(detallePizzaHawaiana1);
        repoArticuloManufacturadoDetalle.guardar(detallePizzaHawaiana2);
        repoArticuloManufacturadoDetalle.guardar(detallePizzaHawaiana3);
        repoArticuloManufacturadoDetalle.guardar(detalleLomoCompleto1);
        repoArticuloManufacturadoDetalle.guardar(detalleLomoCompleto2);
        repoArticuloManufacturadoDetalle.guardar(detalleLomoCompleto3);

        //-------------------------------------------------------

        System.out.println("\n--------------- CATEGORÍAS ---------------");
        List<Categoria> categorias = repoCategoria.todosLosRegistros();
        categorias.forEach(System.out::println);

        System.out.println("\n--------------- INSUMOS ---------------");
        List<ArticuloInsumo> articulosInsumo = repoArticuloInsumo.todosLosRegistros();
        articulosInsumo.forEach(System.out::println);

        System.out.println("\n--------------- MANUFACTURADOS ---------------");
        List<ArticuloManufacturado> manufacturados = repoArticuloManufacturado.todosLosRegistros();
        manufacturados.forEach(System.out::println);

        System.out.println("\n--------------- BUSCAMOS UN ARTÍCULO MANUFACTURADO POR SU ID ---------------");
        Optional<ArticuloManufacturado> manufacturadoEncontrado = repoArticuloManufacturado.buscarPorId(1L);
        manufacturadoEncontrado.ifPresent(System.out::println);

        System.out.println("\n--------------- ACTUALIZAMOS UN ARTÍCULO MANUFACTURADO ---------------");
        ArticuloManufacturado lomoCompletoNuevo = ArticuloManufacturado.builder()
                .denominacion("Lomo Completo actualizado")
                .precioVenta(13500.0)
                .imagenes(imagenesLomo)
                .descripcion("Lomo completo con papas cheddar")
                .tiempoEstimadoMinutos(45)
                .detalles(detallesLomo)
                .build();
        Optional<ArticuloManufacturado> manufacturadoActualizado = repoArticuloManufacturado.actualizarRegistro(1L, lomoCompletoNuevo);
        manufacturadoActualizado.ifPresent(System.out::println);

        System.out.println("\n--------------- ELIMINAMOS UN ARTÍCULO MANUFACTURADO ---------------");
        Optional<ArticuloManufacturado> manufacturadoEliminado = repoArticuloManufacturado.eliminarRegistro(1L);
        manufacturadoEliminado.ifPresent(System.out::println);

    }
}
