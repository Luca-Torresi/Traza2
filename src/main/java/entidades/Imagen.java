package entidades;

import lombok.*;

@ToString (exclude = "articulo")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Imagen {
    private Long id;
    private String denominacion;
    private Articulo articulo;
}
