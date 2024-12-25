package com.sapient.test.SapientTest.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Company {

    private String department;
    private String name;
    private String title;
    private Address address;

}
