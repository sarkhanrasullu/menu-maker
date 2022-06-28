package com.company.menumaker.repositories;

import com.company.menumaker.entities.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PageRepository extends JpaRepository<Page, Integer>, JpaSpecificationExecutor<Page> {


}