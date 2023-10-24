package com.api.rest.models.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
@Entity
public class Phone implements Serializable {
    private String number;
    private String cityCode;
    private String contryCode;
    @Id
    @GeneratedValue
    private Long id;

}
