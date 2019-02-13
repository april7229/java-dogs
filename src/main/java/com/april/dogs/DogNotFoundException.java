package com.april.dogs;

public class DogNotFoundException {

    public DogNotFoundException(Long id)
    {
        super ("Could not find employee " + id);
    }
}
