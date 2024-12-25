package com.sapient.test.SapientTest.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Crypto {
    private String coin;
    private String wallet;
    private String network;


}
