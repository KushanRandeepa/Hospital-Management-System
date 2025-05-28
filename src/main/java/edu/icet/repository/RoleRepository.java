package edu.icet.repository;

import edu.icet.dto.Role;
import edu.icet.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<RoleEntity,Integer> {
    Optional<RoleEntity>findByName(Role name);
}
