package com.mucahit.rest.webservices.restfulwebservices.filtering;


import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties(value = "field2")  boylede yapılabilir   --static filtering
@JsonFilter("SomeBeanFilter") // dynamic filtering
public class SomeBean {

    private String field1;
    private String field2;

    //@JsonIgnore --static filtering
    private String field3;

    public SomeBean(String value1, String value2, String value3) {
        this.field1 = value1;
        this.field2 = value2;
        this.field3 = value3;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String value1) {
        this.field1 = value1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String value2) {
        this.field2 = value2;
    }

    public String getField3() {
        return field3;
    }

    public void setField3(String value3) {
        this.field3 = value3;
    }
}
