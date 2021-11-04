package com.example.periodictableapi.repository;

import com.example.periodictableapi.model.Discoverer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscovererRepository extends JpaRepository<Discoverer, Long> {
}
