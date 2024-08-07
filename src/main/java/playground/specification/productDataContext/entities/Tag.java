package playground.specification.productDataContext.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Tag extends ProductContextBaseEntity {
    private String name;
}
