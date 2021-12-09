package com.Vivek.Insights;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;


@Repository
public interface UserRepository extends CrudRepository<User, Long>{

}
