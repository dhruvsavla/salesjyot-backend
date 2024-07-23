package com.example.warehousegenius.Repository;

import com.example.warehousegenius.Entity.UserScreenRights;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserScreenRightsRepository extends JpaRepository<UserScreenRights, Long> {
}

