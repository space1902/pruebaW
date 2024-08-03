package com.prueba.prueba.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode()
@EntityListeners(AuditingEntityListener.class)
@Table(name = "tikets", schema = "pruebaw")
public class TiketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tiket", nullable = false)
    private Long idTiket;

    @Column(name = "id_user", nullable = false)
    private Long idUser;

    @Column(name = "create_date", nullable = false)
    private String createDate;

    @Column(name = "update_date")
    private String updateDate;

    @Column(name = "status", nullable = false)
    private String status;
}
