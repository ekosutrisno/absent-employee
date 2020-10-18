package com.ekosutrisno.absensiemployee.repository;

import com.ekosutrisno.absensiemployee.entity.EmployeeInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Eko Sutrisno
 * @Create 18/10/2020 11:37
 * @email ekosutrisno801@gmail.com
 */
@Repository
public interface EmployeeInfoRepository extends JpaRepository<EmployeeInfo, String> {

    List<EmployeeInfo> findByEmployeeId(String employeeId);

}
