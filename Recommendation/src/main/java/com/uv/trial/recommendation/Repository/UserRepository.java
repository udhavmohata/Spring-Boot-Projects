package com.uv.trial.recommendation.Repository;

import com.uv.trial.recommendation.Model.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserDTO,Integer>
{
    @Query("select new com.uv.trial.recommendation.Model.UserDTO(u.userId,u.mobileNumber,u.password,u.name,u.gender) from UserDTO u where u.mobileNumber = ?1 and u.password = ?2")
    UserDTO verifyUser(@Param("mobileNumber") String mobileNumber, @Param("password") String password);

    @Query("select u.userId from UserDTO u where u.mobileNumber = ?1")
    Integer getUserId(@Param("mobileNumber") String mobileNumber);
}