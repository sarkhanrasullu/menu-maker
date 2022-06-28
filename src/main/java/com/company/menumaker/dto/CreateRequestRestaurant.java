package com.company.menumaker.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateRequestRestaurant extends BaseRestaurantRequest {
    private Integer id;
}
