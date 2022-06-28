package com.company.menumaker.repositories;

import com.company.menumaker.entities.Menu;
import com.company.menumaker.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface MenuRepository extends JpaRepository<Menu, Integer>, JpaSpecificationExecutor<Menu> {
    Optional<Menu> findByTitle(String  title);
    Optional<Menu> findByPrice(Double price);
}