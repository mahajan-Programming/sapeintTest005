package com.sapient.test.SapientTest.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Coordinates {
    private double lat;
    private double lng;
}
