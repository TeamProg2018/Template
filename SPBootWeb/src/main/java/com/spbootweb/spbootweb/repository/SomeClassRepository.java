package com.spbootweb.spbootweb.repository;

import com.spbootweb.spbootweb.entity.SomeClassModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SomeClassRepository extends JpaRepository<SomeClassModel,Long> {
 SomeClassModel  findBySome_name(String name);
}
