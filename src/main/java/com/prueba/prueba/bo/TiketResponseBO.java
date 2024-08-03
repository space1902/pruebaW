package com.prueba.prueba.bo;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Builder
@Getter
@Setter
public class TiketResponseBO implements Serializable {

    @Serial
    private static final long serialVersionUID = -4447341372096008719L;

    private int idTiket;
    private int idUser;
    private String createDate;
    private String updateDate;
    private String status;
}
