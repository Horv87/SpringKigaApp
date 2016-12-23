package com.martin.repository;

import com.martin.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by martin on 23.12.16.
 */
@Repository
public interface GroupRepository extends JpaRepository<Group,Integer> {


}
