package com.sandeep.repository;

import com.sandeep.model.Calc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * Created by abhishek on 4/3/18.
 */
@Repository
public interface CalcRepo extends PagingAndSortingRepository<Calc, UUID> {
    public Page<Calc> getCalcsByFirstGreaterThan(double first,Pageable page);
}
