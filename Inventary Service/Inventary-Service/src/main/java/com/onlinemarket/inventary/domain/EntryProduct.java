package com.onlinemarket.inventary.domain;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class EntryProduct extends ProductActivity implements Serializable {

    private int amountArrived;

    public EntryProduct(Long id, Date date, String description, int amountArrived) {
        super(id, date, description);
        this.amountArrived = amountArrived;
    }
}
