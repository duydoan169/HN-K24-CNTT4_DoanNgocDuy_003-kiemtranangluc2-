package org.example.kiemtranangluc2.repository;

import org.example.kiemtranangluc2.model.GameItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GameItemRepository extends JpaRepository<GameItem, Long> {

    @Query("""
        select gi from GameItem gi where
        (lower(gi.itemName) like lower(concat('%', :search, '%')) and
        (:filter is null or gi.rarity.id = :filter)
    """)
    Page<GameItem> search(@Param("search") String search, @Param("filter") Long filter, Pageable pageable);
}
