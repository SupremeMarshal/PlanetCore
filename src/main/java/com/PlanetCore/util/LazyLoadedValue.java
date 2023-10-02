package com.PlanetCore.util;

import com.google.common.base.Suppliers;

import java.util.function.Supplier;

@Deprecated//remove this class in 1.16+, vanilla adds it
public class LazyLoadedValue<T> {
    private final Supplier<T> supplier;
    private final Supplier<T> factory;


    public LazyLoadedValue(Supplier<T> supplier) {
        this.supplier = supplier;
        factory = Suppliers.memoize(supplier::get);
    }

    public T get() {
        return this.factory.get();
    }
}