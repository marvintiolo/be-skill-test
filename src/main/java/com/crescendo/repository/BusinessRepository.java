package com.crescendo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crescendo.model.Business;

@Repository
public interface BusinessRepository extends JpaRepository<Business, Integer>{

}
