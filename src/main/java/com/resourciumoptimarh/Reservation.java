package com.resourciumoptimarh;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reservation {
    private Date dateReservation ;
    private User user;

    public Reservation(String dateString,User user)throws ParseException {
//        this.dateReservation = dateReservation;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.dateReservation = dateFormat.parse(dateString);
        this.user=user;
    }

    public Date getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(Date dateReservation) {
        this.dateReservation = dateReservation;
    }



    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    @Override
    public String toString() {
        return "Reservation{" +
                "dateReservation=" + dateReservation +
                ", user=" + user +
                '}';
    }
}
