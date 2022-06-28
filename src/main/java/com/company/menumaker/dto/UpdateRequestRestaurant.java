package com.company.menumaker.dto;

import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateRequestRestaurant extends BaseRestaurantRequest{
    private Integer id;

}
