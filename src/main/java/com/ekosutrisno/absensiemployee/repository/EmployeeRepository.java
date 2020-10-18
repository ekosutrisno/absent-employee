package com.ekosutrisno.absensiemployee.repository;

import com.ekosutrisno.absensiemployee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author Eko Sutrisno
 * @Create 18/10/2020 11:02
 * @email ekosutrisno801@gmail.com
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {

}

