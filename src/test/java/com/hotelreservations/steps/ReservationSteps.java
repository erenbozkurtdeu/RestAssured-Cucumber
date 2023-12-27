package com.hotelreservations.steps;

import com.hotelreservations.models.BookingResponse;
import com.hotelreservations.services.ReservationService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class ReservationSteps {

    ReservationService reservationService;
    String authKey;
    BookingResponse bookingResponse;

    @Given("Kullanici yeni bir rezervasyon olusturur")
    public void cagriBaslangici(){
        reservationService = new ReservationService();
    }

    @Given("Kullanici rezervasyon icin gereken bilgileri girer")
    public void createAuth(){
        authKey = reservationService.generateToken();
    }

    @When("Kullanici otel rezervasyonunu tamamlar")
    public void createReservation(){
        bookingResponse = reservationService.createBooking();
    }

    @Then("Rezervasyon basarili bir sekilde olusturuldu")
    public void reservationAssertions(){
        Assertions.assertEquals("Fatma", bookingResponse.getBooking().getFirstname());
        Assertions.assertEquals("Hayriye", bookingResponse.getBooking().getLastname());
        Assertions.assertEquals(750, bookingResponse.getBooking().getTotalprice());
        Assertions.assertTrue(bookingResponse.getBooking().isDepositpaid());
        Assertions.assertEquals("Extra bed", bookingResponse.getBooking().getAdditionalneeds());
    }

    @And("Kullanici olusturulan rezervasyonu iptal eder")
    public void cancelReservation(){
        reservationService.deleteReservation(authKey, bookingResponse.getBookingid());
    }
}