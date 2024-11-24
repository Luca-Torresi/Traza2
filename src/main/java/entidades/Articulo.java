package entidades;

import java.util.Set;
import java.util.HashSet;
import lombok.*;
import lombok.experimental.SuperBuilder;

@ToString (exclude = "imagenes")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Articulo {
    protected Long id;
    protected String denominacion;
    protected Double precioVenta;
    @Builder.Default
    protected Set<Imagen> imagenes = new HashSet<>();
    protected Categoria categoria;

}
