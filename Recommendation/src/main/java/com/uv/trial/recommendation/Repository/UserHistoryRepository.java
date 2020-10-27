package com.uv.trial.recommendation.Repository;

import com.uv.trial.recommendation.Model.UserHistoryDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserHistoryRepository extends JpaRepository<UserHistoryDTO,Integer>
{
    @Query("select uh.sizeId from UserHistoryDTO uh where uh.userId = ?1 and uh.categoryId=?2")
    Integer getHistory(@Param("userId") int userId,@Param("categoryId")int categoryId);

    @Query("select uh.sizeId from UserHistoryDTO uh where uh.userId = ?1")
    List<Integer> getHistory(@Param("userId") int userId);

}
