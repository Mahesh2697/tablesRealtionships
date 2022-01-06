package com.oneToOneandMany.tablesRealtionships.repository;

import com.oneToOneandMany.tablesRealtionships.entity.DealersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DealersRepository extends JpaRepository<DealersEntity, Long> {

    Optional<DealersEntity> getByNameAndId(String name, Long id);
}
