package org.example.kiemtranangluc2.repository;

import org.example.kiemtranangluc2.model.Rarity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RarityRepository extends JpaRepository<Rarity, Long> {
}
