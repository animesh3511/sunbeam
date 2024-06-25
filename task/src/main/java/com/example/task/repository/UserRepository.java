package com.example.task.repository;

import com.example.task.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {


    boolean existsByEmail(String email);

  // @Query(value = "SELECT  * FROM `user` WHERE CONCAT(user_name,' ',email,' ',user_id) LIKE %:search%",nativeQuery = true)


    // both of below queries gives expected output when we send userId.The following query contains 'count query'
    //which returns number of records fetched by main @Query
//    @Query(value = "SELECT * FROM user u " +
//            "WHERE (:search IS NULL OR u.user_name LIKE %:search% OR u.email LIKE %:search%) " +
//            "AND (:userId IS NULL OR u.user_id = :userId)",
//            countQuery = "SELECT count(*) FROM user u " +
//                    "WHERE (:search IS NULL OR u.user_name LIKE %:search% OR u.email LIKE %:search%) " +
//                    "AND (:userId IS NULL OR u.user_id = :userId)",
//            nativeQuery = true)

    @Query(value = "SELECT * FROM user u " +
            "WHERE (:search IS NULL OR u.user_name LIKE %:search% OR u.email LIKE %:search%) " +
            "AND (:userId IS NULL OR u.user_id = :userId)",nativeQuery = true)
    Page<User> searchByEmailUserIdUserName(
            @Param("search") String search,
            @Param("userId") Long userId,
            Pageable pageable);


    @Query(value = "SELECT * FROM `user`",nativeQuery = true)
    Page<User> getAll(Pageable pageable);


}
