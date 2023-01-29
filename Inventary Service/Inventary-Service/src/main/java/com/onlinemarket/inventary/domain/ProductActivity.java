package com.onlinemarket.inventary.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public abstract class ProductActivity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "activity_date", nullable = false, updatable = false)
    private Date date;

    @Column(name = "description", nullable = false, updatable = false)
    private String description;

    @PrePersist
    private void prePersistProduct(){
        this.date = new Date();
    }
}
