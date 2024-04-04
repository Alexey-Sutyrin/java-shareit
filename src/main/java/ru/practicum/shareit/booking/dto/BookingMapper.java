package ru.practicum.shareit.booking.dto;

import ru.practicum.shareit.booking.Booking;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class BookingMapper {

    public static BookingOutDto toBookingDto(Booking booking) {
        return BookingOutDto.builder()
                .id(booking.getId())
                .start(booking.getStart())
                .end(booking.getEnd())
                .item(booking.getItem())
                .booker(booking.getBooker())
                .status(booking.getStatus())
                .build();
    }

    public static List<BookingOutDto> mapToBookingDto(Collection<Booking> bookings) {
        return bookings.stream()
                .map(BookingMapper::toBookingDto)
                .collect(Collectors.toList());
    }
    /*старый способ убран, использованы поток stream, метод map и собран результат с помощью Collectors toList
    public static List<BookingOutDto> mapToBookingDto(Collection<Booking> bookings) {
        List<BookingOutDto> dtos = new ArrayList<>();
        for (Booking booking : bookings) {
            dtos.add(toBookingDto(booking));
        }
        return dtos;
    }*/

    public static Booking toBooking(BookingDto bookingDto) {
        Booking booking = new Booking();
        booking.setId(bookingDto.getId());
        booking.setStart(bookingDto.getStart());
        booking.setEnd(bookingDto.getEnd());
        return booking;
    }

    public static BookingViewDto toBookingViewDto(Booking booking) {
        return BookingViewDto.builder()
                .id(booking.getId())
                .start(booking.getStart())
                .end(booking.getEnd())
                .bookerId(booking.getBooker().getId())
                .itemId(booking.getItem().getId())
                .build();
    }
}
