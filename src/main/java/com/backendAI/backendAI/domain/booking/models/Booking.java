package com.backendAI.backendAI.domain.booking.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Entity
@Table
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Booking {

        @Id
        @GeneratedValue(
                strategy = GenerationType.IDENTITY,
                generator = "booking_sequence"
        )
        @SequenceGenerator(

                name = "booking_sequence",
                sequenceName = "booking_sequence",
                allocationSize = 1
        )


        private Long id;

        @ManyToOne
        @JoinColumn(name = "customer_id", nullable = false)
        private Customer customer;

        @NonNull
        private BookingStatus bookingStatus;

        @NonNull
        private String destinationFrom;

        @NonNull
        private String destinationTo;

        @NonNull
        private LocalDate bookingFrom;

        @NonNull
        private LocalDate bookingTo;



        public String toString(){
            return String.format("%d %s %s %s %s %s %s %s %s ", id, bookingStatus, destinationFrom, destinationTo, bookingFrom, bookingTo);
        }

    }

