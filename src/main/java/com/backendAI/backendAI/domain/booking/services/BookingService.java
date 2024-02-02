package com.backendAI.backendAI.domain.booking.services;

import com.backendAI.backendAI.domain.booking.models.Booking;
import com.backendAI.backendAI.domain.booking.models.Customer;
import com.backendAI.backendAI.domain.booking.repos.BookingRepository;
import com.backendAI.backendAI.domain.core.exception.ResourceCreationException;
import com.backendAI.backendAI.domain.core.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;


public interface BookingService {
        Booking create(Booking booking) throws ResourceCreationException;
        Booking getById(Long id) throws ResourceNotFoundException;
        Customer getByEmail(String email) throws ResourceNotFoundException;
        List<Booking> getAll();
        Booking update(Long id, Booking bookingDetail) throws ResourceNotFoundException;
            void delete(Long id);
    }

