package com.vineeth.mystore.repository;

import com.vineeth.mystore.entities.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyStoreRepository extends JpaRepository<Vendor, Integer> {

}
