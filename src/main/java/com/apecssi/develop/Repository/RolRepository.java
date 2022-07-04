package com.apecssi.develop.Repository;

import com.apecssi.develop.Models.TblRol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface RolRepository extends JpaRepository<TblRol, Integer> {


}
