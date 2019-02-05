package com.nothing.test;

public class Booker {
    private String name;
    private String desc;
    private int nightsBooked;
    private boolean checkedIn;

    public Booker(String nameBook, String descBook, int nights, boolean checked) {
        name = nameBook;
        desc = descBook;
        nightsBooked = nights;
        checkedIn = checked;
    }
}
