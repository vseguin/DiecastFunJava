package com.personal.diecastfun.controllers.models;

public class ValueModel
{
    private String value;

    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }

    public ValueModel withValue(String value)
    {
        setValue(value);
        return this;
    }
}
