package com.backendAI.backendAI.domain.booking.services;

import com.backendAI.backendAI.domain.booking.models.Booking;
import com.backendAI.backendAI.domain.booking.models.Customer;
import com.backendAI.backendAI.domain.booking.repos.BookingRepository;
import com.backendAI.backendAI.domain.core.exception.ResourceCreationException;
import com.backendAI.backendAI.domain.core.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

    @Service
    public class BookingServiceImpl implements BookingService{
        private BookingRepository bookingRepository;

        @Autowired
        public BookingServiceImpl(BookingRepository bookingRepository) {
            this.bookingRepository = bookingRepository;
        }

        @Override
        public Booking create(Booking booking) throws ResourceCreationException {
            Optional<Booking> optional = bookingRepository.findById(booking.getId());
            if(optional.isPresent())
                throw new ResourceCreationException("Booking with booking ID exists: " + booking.getId());
            booking = bookingRepository.save(booking);
            return booking;
        }


        @Override
        public Booking getById(Long id) throws ResourceNotFoundException {
            Booking booking = bookingRepository.findById(id)
                    .orElseThrow(()->new ResourceNotFoundException("No Booking with id: " + id));
            return booking;
        }

        @Override
        public Customer getByEmail (String email) throws ResourceNotFoundException {
            Customer customer = bookingRepository.findByCustomerEmail(email)
                    .orElseThrow(()->new ResourceNotFoundException("No Booking with email: " + email));
            return customer;
        }

        @Override
        public List<Booking> getAll() {
            return bookingRepository.findAll();
        }


        @Override
        public Booking update(Long id, Booking bookingDetail) throws ResourceNotFoundException {
            Booking booking = getById(id);
            booking.setBookingFrom(bookingDetail.getBookingFrom());
            booking.setBookingTo(bookingDetail.getBookingTo());
            booking.setBookingStatus(bookingDetail.getBookingStatus());
            booking.setDestinationFrom(bookingDetail.getDestinationFrom());
            booking.setDestinationTo(bookingDetail.getDestinationTo());

            booking = bookingRepository.save(booking);
            return booking;
        }

        @Override
        public void delete(Long id) {
            Booking booking = getById(id);
            bookingRepository.delete(booking);
        }
    }



