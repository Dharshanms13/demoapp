package com.dash.mockitoapp.demoapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dash.mockitoapp.demoapp.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{

    @Query("from User where address=:address")
	List<User> getUsersByaddress(@Param("address") String address);

}
