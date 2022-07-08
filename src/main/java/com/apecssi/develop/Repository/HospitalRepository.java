package com.apecssi.develop.Repository;

import com.apecssi.develop.Models.TblHospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<TblHospital, Integer> {


}
