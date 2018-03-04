package com.sandeep.dto;

import javax.validation.constraints.NotNull;

/**
 * Created by abhishek on 4/3/18.
 */
public class DivDto {

    @NotNull
    private float a;
    @NotNull
    private float b;

    private float result;

    public float getA() {
        return a;
    }

    public void setA(float a) {
        this.a = a;
    }

    public float getB() {
        return b;
    }

    public void setB(float b) {
        this.b = b;
    }

    public float getResult() {
        return result;
    }

    public void setResult(float result) {
        this.result = result;
    }
}
