package com.funstuff.dogTracker.model;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class Registration {
    @NotEmpty
    private String name;
    @NotEmpty
    private boolean tracked;
}
