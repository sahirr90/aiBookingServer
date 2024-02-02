package com.backendAI.backendAI.domain.booking.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Data


public class Customer  {
    @Id
    private Long id;

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @NonNull
    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "customer") // Assuming a "customer" field in Booking
    private List<Booking> bookings = new ArrayList<>();


    public String toString(){
        return String.format("%d %s %s %s ",id, firstName,lastName,email);
    }
}


