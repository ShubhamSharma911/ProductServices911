package dev.shubham911.productservices911.repositories.projections;

import lombok.Getter;
import lombok.Setter;


// something like like dtos but to get the data from db and out app

public interface ProductWithTitleAndId {

    Long getId();

    String getTitle();

}
