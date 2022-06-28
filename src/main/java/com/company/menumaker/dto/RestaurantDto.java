package com.company.menumaker.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RestaurantDto implements Serializable {
    private Integer id;
    private String name;
    private String image;
    private String email;
    private String phone;
    private String address;
    private Integer userId;
    private String qrCode;
    private Integer state;

}
