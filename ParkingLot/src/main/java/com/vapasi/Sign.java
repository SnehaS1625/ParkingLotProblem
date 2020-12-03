package com.vapasi;

import java.util.Objects;

public class Sign {

    private boolean isFull;
    private static final Sign fullSign = new Sign(true);
    private static final Sign notFullSign = new Sign(false);

    private Sign(boolean isFull){
        this.isFull = isFull;
    }

    public static Sign generateFullSign(){
        return fullSign;
    }
    public static Sign generateNotFullSign(){
        return notFullSign;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || getClass() != that.getClass()) return false;
        Sign sign = (Sign) that;
        return isFull == sign.isFull;
    }

    @Override
    public String toString() {
        return "Parking Status :" +isFull;
    }
}
