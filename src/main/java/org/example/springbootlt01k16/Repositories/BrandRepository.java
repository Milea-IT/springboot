package org.example.springbootlt01k16.Repositories;

import org.example.springbootlt01k16.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Đánh dấu Repository
@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
}