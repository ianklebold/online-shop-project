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
@Table(name = "histories")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class History implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "creation_date", nullable = false, updatable = false)
    private Date creationDate;

    @Column(name = "modification_date", nullable = false, updatable = false)
    private Date modificationDate;


    @OneToMany(cascade={CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.REFRESH})
    private List<OutPutProduct> amountToSell;

    @OneToMany(cascade={CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.REFRESH})
    private List<EntryProduct> amountArrived;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @PrePersist
    private void prePersistProduct(){
        this.creationDate = new Date();
    }

    @PreUpdate
    private void preUpdateProduct(){
        this.modificationDate = new Date();
    }

}
