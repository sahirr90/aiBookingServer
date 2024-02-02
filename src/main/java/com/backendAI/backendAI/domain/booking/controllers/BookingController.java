package com.backendAI.backendAI.domain.booking.controllers;

import com.backendAI.backendAI.domain.booking.models.Booking;
import com.backendAI.backendAI.domain.booking.models.Customer;
import com.backendAI.backendAI.domain.booking.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


    @RestController
    @CrossOrigin("*")
    @RequestMapping("/api/v1/bookings")
    public class BookingController {

        private BookingService bookingService;

        @Autowired
        public BookingController(BookingService bookingService) {
            this.bookingService = bookingService;
        }

        @GetMapping
        public ResponseEntity<List<Booking>> getAll(){
            List<Booking> employees = bookingService.getAll();
            return new ResponseEntity<>(employees, HttpStatus.OK);
        }

        @PostMapping
        public ResponseEntity<Booking> create(@RequestBody Booking booking){
            booking = bookingService.create(booking);
            return new ResponseEntity<>(booking, HttpStatus.CREATED);
        }

        @GetMapping("{id}")
        public ResponseEntity<Booking> getById(@PathVariable("id") Long id){
            Booking booking = bookingService.getById(id);
            return new ResponseEntity<>(booking, HttpStatus.OK);
        }

//        @GetMapping("lookup")
//        public ResponseEntity<Customer> getByEmail(@RequestParam String email){
//            Customer customer = bookingService.getByEmail(email);
//            return new ResponseEntity<Booking>(customer, HttpStatus.OK);
//        }

        @PutMapping("{id}")
        public ResponseEntity<Booking> update(@PathVariable("id") Long id, @RequestBody Booking bookingDetail){
            bookingDetail = bookingService.update(id, bookingDetail);
            return new ResponseEntity<>(bookingDetail, HttpStatus.ACCEPTED);
        }

        @DeleteMapping("{id}")
        public ResponseEntity delete(@PathVariable("id") Long id){
            bookingService.delete(id);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }

