package com.ekosutrisno.absensiemployee.service.impl;

import com.ekosutrisno.absensiemployee.entity.EmployeeInfo;
import com.ekosutrisno.absensiemployee.model.CreateAbsentRequest;
import com.ekosutrisno.absensiemployee.repository.EmployeeInfoRepository;
import com.ekosutrisno.absensiemployee.service.EmployeeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author Eko Sutrisno
 * @Create 18/10/2020 13:06
 * @email ekosutrisno801@gmail.com
 */
@Service
public class EmployeeInfoServiceImpl implements EmployeeInfoService {

    @Autowired
    private EmployeeInfoRepository employeeInfoRepository;

    @Override
    public EmployeeInfo createEmployeeInfo(CreateAbsentRequest absentRequest) {
        var employeeInfo = new EmployeeInfo();
        employeeInfo.setEmployeeId(absentRequest.getEmployeeId());
        employeeInfo.setPlanning(absentRequest.getPlanning());
        employeeInfo.setLocation(absentRequest.getLocation());
        employeeInfo.setAbsentMorning(absentRequest.getAbsentMorning());
        employeeInfo.setAbsentAfternoon(absentRequest.getAbsentAfternoon());
        employeeInfo.setAbsentEvening(absentRequest.getAbsentEvening());
        employeeInfo.setCreatedAt(LocalDateTime.now());

        return employeeInfoRepository.save(employeeInfo);
    }

    @Override
    public List<EmployeeInfo> getEmployeeInfoByEmployeeId(String employeeId) {
        return employeeInfoRepository.findByEmployeeIdOrderByCreatedAtDesc(employeeId);
    }

    @Override
    public EmployeeInfo updateEmployeeInfo(String employeeId, CreateAbsentRequest absentRequest) {

        List<EmployeeInfo> optionalEmployeeInfo = employeeInfoRepository.findByEmployeeIdOrderByCreatedAtDesc(employeeId);
        if (!optionalEmployeeInfo.isEmpty()) {
            var employeeInfo = optionalEmployeeInfo.get(0);

            employeeInfo.setAbsentMorning(absentRequest.getAbsentMorning());
            employeeInfo.setAbsentAfternoon(absentRequest.getAbsentAfternoon());
            employeeInfo.setAbsentEvening(absentRequest.getAbsentEvening());
            employeeInfo.setModifiedAt(LocalDateTime.now());

            EmployeeInfo empUpdated = employeeInfoRepository.save(employeeInfo);

            int isPresentConditions = empUpdated.getAbsentAfternoon() + empUpdated.getAbsentMorning() + empUpdated.getAbsentEvening();

            empUpdated.setIsPresent(isPresentConditions == 3);
            employeeInfoRepository.save(empUpdated);

            return empUpdated;
        }

        return null;
    }
}
