package com.company.menumaker.service;

import com.company.menumaker.dto.*;
import com.company.menumaker.entity.Restaurant;
import com.company.menumaker.exception.RestaurantNotFoundException;
import com.company.menumaker.exception.UserNotFoundException;
import com.company.menumaker.mapper.RestaurantMapper;
import com.company.menumaker.repository.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RestaurantService {
    private final UserService userService;
    private final RestaurantRepository restaurantRepository;

    private final RestaurantMapper restaurantMapper;

    public RestaurantService(UserService userService,
                             RestaurantRepository restaurantRepository,
                             RestaurantMapper restaurantMapper) {
        this.userService = userService;
        this.restaurantRepository = restaurantRepository;
        this.restaurantMapper = restaurantMapper;
    }

    public RestaurantDto createRestaurant(CreateRequestRestaurant createRequestRestaurant) {

        Restaurant restaurant = Restaurant.builder()

                .name(createRequestRestaurant.getName())
                .email(createRequestRestaurant.getEmail())
                .address(createRequestRestaurant.getAddress())
                .image(createRequestRestaurant.getImage())
                .phone(createRequestRestaurant.getPhone())
                .userId(createRequestRestaurant.getUserId())
                .qrCode(createRequestRestaurant.getQrCode())
                .state(createRequestRestaurant.getState())

                .build();
        return restaurantMapper.restaurantEntityToDto(restaurant);

    }

    public RestaurantDto updateRestaurant(Integer id, UpdateRequestRestaurant updateRequestRestaurant) {

        Optional<Restaurant> restaurantOptional = restaurantRepository.findById(id);
        restaurantOptional.ifPresent(restaurant -> {
            restaurant.setName(updateRequestRestaurant.getName());
            restaurant.setEmail(updateRequestRestaurant.getEmail());
            restaurant.setPhone(updateRequestRestaurant.getPhone());
            restaurant.setImage(updateRequestRestaurant.getImage());
            restaurant.setAddress(updateRequestRestaurant.getAddress());
            restaurant.setQrCode(updateRequestRestaurant.getQrCode());
            restaurant.setUserId(restaurant.getUserId());
            restaurant.setState(updateRequestRestaurant.getState());
            restaurantRepository.save(restaurant);
        });
        return restaurantOptional.map(restaurantMapper::restaurantEntityToDto).orElse(new RestaurantDto());

    }


    public List<RestaurantDto> getAllRestaurants() {
        List<Restaurant> restaurantList = restaurantRepository.findAll();
        return restaurantMapper.toDtoList(restaurantList);
    }

    public RestaurantDto getRestaurantById(Integer id) {
        return restaurantRepository.findById(id).map(restaurantMapper::restaurantEntityToDto).orElse(new RestaurantDto());

    }


    public RestaurantDto getByRestaurantEmail(String email) {
        Restaurant restaurant = findByEmail(email);
        return restaurantMapper.restaurantEntityToDto(restaurant);
    }


    public RestaurantDto getByRestaurantPhone(String phone) {
        Restaurant restaurant = findByPhone(phone);
        return restaurantMapper.restaurantEntityToDto(restaurant);
    }

    public RestaurantDto getByRestaurantName(String name) {
        Restaurant restaurant = findByName(name);
        return restaurantMapper.restaurantEntityToDto(restaurant);
    }


    public void deleteRestaurantById(Integer id) {
        restaurantRepository.deleteById(id);
    }


    private Restaurant findByEmail(String email) {
        return restaurantRepository.findByEmail(email)
                .orElseThrow(() -> new RestaurantNotFoundException("Restaurant not found"));

    }


    private Restaurant findByPhone(String phone) {
        return restaurantRepository.findByEmail(phone)
                .orElseThrow(() -> new RestaurantNotFoundException("Restaurant not found"));
    }

    private Restaurant findByName(String name) {
        return restaurantRepository.findByName(name)
                .orElseThrow(() -> new RestaurantNotFoundException("Restaurant not found"));
    }


}
