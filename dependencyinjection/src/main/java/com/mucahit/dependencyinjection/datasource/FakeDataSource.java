package com.mucahit.dependencyinjection.datasource;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FakeDataSource {

    private String username;
    private String password;
    private String jdbcurl;
}
