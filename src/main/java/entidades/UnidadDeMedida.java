package entidades;

import lombok.*;

@ToString
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UnidadDeMedida {
    private Long id;
    private String denominacion;
}
