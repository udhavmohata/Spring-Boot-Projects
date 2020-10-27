package com.uv.trial.recommendation.Repository;

import com.uv.trial.recommendation.Model.BrandDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<BrandDTO,Integer>
{
    @Query("select brandId from BrandDTO b where b.brandName = ?1 and b.enable=1")
    Integer getBrandId(@Param("brandName") String brandName);
}
