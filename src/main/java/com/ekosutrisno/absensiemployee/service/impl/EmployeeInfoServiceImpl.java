package com.ekosutrisno.absensiemployee.service.impl;

import com.ekosutrisno.absensiemployee.entity.EmployeeInfo;
import com.ekosutrisno.absensiemployee.model.CreateAbsentRequest;
import com.ekosutrisno.absensiemployee.repository.EmployeeInfoRepository;
import com.ekosutrisno.absensiemployee.service.EmployeeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
        EmployeeInfo employeeInfo = new EmployeeInfo();
        employeeInfo.setEmployeeId(absentRequest.getEmployeeId());
        employeeInfo.setPlanning(absentRequest.getPlanning());
        employeeInfo.setLocation(absentRequest.getLocation());
        employeeInfo.setAbsentMorning(absentRequest.getAbsentMorning());
        employeeInfo.setAbsentAfternoon(absentRequest.getAbsentAfternoon());
        employeeInfo.setAbsentEvening(absentRequest.getAbsentEvening());
        employeeInfo.setCreatedAt(new Date());

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
            EmployeeInfo employeeInfo = optionalEmployeeInfo.get(0);

            employeeInfo.setAbsentMorning(absentRequest.getAbsentMorning());
            employeeInfo.setAbsentAfternoon(absentRequest.getAbsentAfternoon());
            employeeInfo.setAbsentEvening(absentRequest.getAbsentEvening());
            employeeInfo.setModifiedAt(new Date());

            int isPresentConditions = absentRequest.getAbsentAfternoon() + absentRequest.getAbsentMorning() + absentRequest.getAbsentEvening();

            employeeInfo.setIsPresent(isPresentConditions == 3);

            return employeeInfoRepository.save(employeeInfo);
        }

        return null;
    }
}
