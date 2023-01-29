package com.onlinemarket.inventary.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "products")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, updatable = true)
    private String name;

    @Column(name = "description", nullable = false, updatable = true)
    private String description;

    @Column(name = "stock", nullable = false, updatable = true)
    private int stock;

    @Column(name = "price", nullable = false, updatable = true)
    private double price;

    @Column(name = "localization", nullable = false, updatable = true)
    private String localization;

    @Column(name = "creation_date", nullable = false, updatable = false)
    private Date creationDate;

    @Column(name = "modification_date", nullable = false, updatable = false)
    private Date modificationDate;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<History> historyList;

    @OneToOne
    @JoinColumn(name = "bar_code_id")
    private BarCode barCode;

    @PrePersist
    private void prePersistProduct(){
        this.creationDate = new Date();
    }

    @PreUpdate
    private void preUpdateProduct(){
        this.modificationDate = new Date();
    }

}
