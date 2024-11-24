package entidades;

import lombok.*;

@ToString
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Categoria {
    private Long id;
    private String denominacion;
}
