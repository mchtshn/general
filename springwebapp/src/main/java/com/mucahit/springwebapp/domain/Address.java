package com.mucahit.springwebapp.domain;

import lombok.*;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Address {


    private String line;
    private String state;
    private String city;
    private String zip;
}
