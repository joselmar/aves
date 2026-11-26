package com.example.aves.repository;
import com.example.aves.entity.Ave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AveRepository extends JpaRepository<Ave, Long> {
}

