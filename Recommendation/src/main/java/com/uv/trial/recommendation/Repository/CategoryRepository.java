package com.uv.trial.recommendation.Repository;

import com.uv.trial.recommendation.Model.CategoryDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryDTO,Integer>
{
    @Query("select categoryId from CategoryDTO c where CategoryName = ?1")
    Integer getCategoryId(@Param("CategoryName") String CategoryName);

}
