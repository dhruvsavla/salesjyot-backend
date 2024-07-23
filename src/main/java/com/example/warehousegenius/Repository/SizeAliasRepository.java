package com.example.warehousegenius.Repository;

import com.example.warehousegenius.Entity.SizeAlias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SizeAliasRepository extends JpaRepository<SizeAlias, Long> {
}
