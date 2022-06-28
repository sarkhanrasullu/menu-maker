package com.company.menumaker.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class BaseRestaurantRequest  {
    private String name;
    private String image;
    private String email;
    private String phone;
    private String address;
    private Integer userId;
    private String qrCode;
    private Integer state;

}
