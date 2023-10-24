package com.api.rest.models.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(
                            name = "uuid_gen_strategy_class",
                            value = "org.hibernate.id.CustomVersionOneStrategy"
                    )
            }
    )
    @Column(name="id")
    private UUID id;

    @NotEmpty(message = "debe ser agregado el nombre")
    @Column(nullable = false)
    private String name;

    @NotEmpty(message = "debe ser agregado el email")
    @Email(message = "Email invalido", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    @Column(nullable = false, unique = true)
    private String email;

    @NotEmpty(message = "debe ser agregado el password")
    @Column(nullable = false)
    @Length(min = 4, max = 60, message = "password debe tener 4 caracteres minimo")
    private String password;

    private boolean isActive;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="create_date")
    private LocalDateTime creationDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="last_update")
    private LocalDateTime lastUpdate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="last_login")
    private LocalDateTime lastLogin;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Phone> phones;

}
