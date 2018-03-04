package com.sandeep.controller;

import com.sandeep.dto.CalcDto;
import com.sandeep.dto.DivDto;
import com.sandeep.model.Calc;
import com.sandeep.service.CalcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Created by abhishek on 4/3/18.
 */
@RestController
public class calcController {

    @Autowired
    CalcService calcService;

    @RequestMapping(path = "/add", method = RequestMethod.GET)
    public Integer add(@RequestParam("first") int a , @RequestParam("second") int b){
        return a+b;
    }

    @RequestMapping(path = "/sub/{first}/{second}", method = RequestMethod.GET)
    public Integer sub(@PathVariable("first") int a , @PathVariable("second") int b){
        return a-b;
    }

    @RequestMapping(path = "/mul", method = RequestMethod.POST)
    public CalcDto mul(@RequestBody CalcDto req){
        req.setResult(req.getA()*req.getB());
        return req;
    }

    @RequestMapping(path = "/div", method = RequestMethod.POST)
    public Calc divandstore(@RequestBody DivDto req){
        return calcService.divAndStoreService(req.getA(),req.getB());
    }

    @RequestMapping(path = "/div/{id}", method = RequestMethod.POST)
    public Calc divandupdate(@RequestBody DivDto req, @PathVariable("id") UUID calcId) throws Exception {
        return calcService.divAndUpdateService(req.getA(),req.getB(), calcId);
    }

    @RequestMapping(path = "/getCalcList", method = RequestMethod.GET)
    public Page<Calc> getCalcList(@RequestParam("first") double a , Pageable page) throws Exception {
        return calcService.getListofCalc(a,page);
    }
}
