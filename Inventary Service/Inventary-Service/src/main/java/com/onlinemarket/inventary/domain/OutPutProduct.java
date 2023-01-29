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
public class OutPutProduct extends ProductActivity implements Serializable {
    private int amountToSell;

    public OutPutProduct(Long id, Date date, String description, int amountToSell) {
        super(id, date, description);
        this.amountToSell = amountToSell;
    }
}
