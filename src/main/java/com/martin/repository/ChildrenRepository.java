package com.martin.repository;

import com.martin.entity.Child;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by martin on 23.12.16.
 */
@Repository
public interface ChildrenRepository extends JpaRepository<Child,Integer> {
    List<Child> findByGroup_Id(int id);
}
