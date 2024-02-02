package com.backendAI.backendAI.domain.booking.repos;

import com.backendAI.backendAI.domain.booking.models.Booking;
import com.backendAI.backendAI.domain.booking.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    Optional<Booking> findById (Long id);
    Optional<Customer> findByCustomerEmail (String email);

}
