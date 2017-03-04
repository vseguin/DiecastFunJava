package com.personal.diecastfun.controllers.models;

public class SingleStatisticModel
{
    private Long count;
    private String value;

    public Long getCount()
    {
        return count;
    }

    public void setCount(Long count)
    {
        this.count = count;
    }

    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }

    public SingleStatisticModel withCount(Long count)
    {
        setCount(count);
        return this;
    }

    public SingleStatisticModel withValue(String value)
    {
        setValue(value);
        return this;
    }
}
