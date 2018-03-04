package com.sandeep.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.SQLDeleteAll;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

/**
 * Created by abhishek on 4/3/18.
 */
@Entity
@Table(name = "sandeep_calc")
public class Calc {

    @Id
    @Column(name = "calc_id")
    @NotNull
    private UUID id;
    @NotNull
    private Double first;
    @NotNull
    private Double second;
    @NotNull
    private Double result;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Double getFirst() {
        return first;
    }

    public void setFirst(Double first) {
        this.first = first;
    }

    public Double getSecond() {
        return second;
    }

    public void setSecond(Double second) {
        this.second = second;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }

    public Calc() {
        this.id = UUID.randomUUID();
    }
}
