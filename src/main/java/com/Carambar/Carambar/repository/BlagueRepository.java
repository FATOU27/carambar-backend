package com.Carambar.Carambar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Carambar.Carambar.entity.Blague;

public interface BlagueRepository extends JpaRepository<Blague, Long> {
    @Query(value = "SELECT * FROM blague ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Blague findRandom();
}
