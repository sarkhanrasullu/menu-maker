package com.company.menumaker.repository;

import com.company.menumaker.entity.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PageRepository extends JpaRepository<Page, Integer>, JpaSpecificationExecutor<Page> {


}