package entidades;

import lombok.*;
import lombok.experimental.SuperBuilder;

@ToString
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class ArticuloInsumo extends Articulo{
    private Double precioCompra;
    private Integer stockActual;
    private Integer stockMaximo;
    private Boolean esParaElaborar;
    private UnidadDeMedida unidadDeMedida;
}
