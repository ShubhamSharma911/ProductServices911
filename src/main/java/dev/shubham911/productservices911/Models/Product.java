package dev.shubham911.productservices911.Models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity

public class Product extends BaseModel{
    // spring annotations

    // adding these dependencies will add all getter and
    // setter methods in for all the attributes and we dont have to write them


    private String title;

    private String description;

    private double price;

    @ManyToOne(cascade = {CascadeType.PERSIST} )
    private Category category;

    private String imageUrl;



    // we can over write the getters and setters method


}
