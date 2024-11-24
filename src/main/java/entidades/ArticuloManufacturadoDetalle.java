package entidades;

import lombok.*;

@ToString (exclude = {"articulo","insumo"})
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticuloManufacturadoDetalle {
    private Long id;
    private Integer cantidad;
    private ArticuloManufacturado articulo;
    private ArticuloInsumo insumo;
}
