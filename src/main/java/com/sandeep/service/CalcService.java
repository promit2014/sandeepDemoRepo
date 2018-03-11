package com.sandeep.service;

import com.sandeep.exception.NotFoundException;
import com.sandeep.model.Calc;
import com.sandeep.repository.CalcRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

/**
 * Created by abhishek on 4/3/18.
 */
@Service
public class CalcService {

    @Autowired
    private CalcRepo calcRepo;

    public Calc divAndStoreService( double a , double b){
        Calc result = new Calc();
        result.setFirst(a);
        result.setSecond(b);
        result.setResult(result.getFirst()/result.getSecond());
        calcRepo.save(result);
        return result;
    }

    public Calc divAndUpdateService(double a, double b, UUID calcId) throws Exception {

        Optional<Calc> resultObj = Optional.ofNullable(calcRepo.findOne(calcId));

        Calc result  = resultObj.orElseThrow(()->{
            return new NotFoundException("Calc Id "+calcId+" not found");
        });

        result.setFirst(a);
        result.setSecond(b);
        result.setResult(result.getFirst()/result.getSecond());
        calcRepo.save(result);

        return result;
    }

    public Page<Calc> getListofCalc(double a, Pageable page) throws Exception
    {
        Optional<Page<Calc>> resultObj = Optional.ofNullable(calcRepo.getCalcsByFirstGreaterThan(a,page));
        Page<Calc> result  = resultObj.orElseThrow(Exception::new);
        return result;
    }

}
