package com.crescendo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crescendo.model.Business;

public interface BusinessRepository extends JpaRepository<Business, Integer>{
}
