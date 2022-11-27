package ru.zig.orderapi.http.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.zig.orderapi.dto.OrderCreateDto;
import ru.zig.orderapi.dto.OrderReadBaseDto;
import ru.zig.orderapi.service.OrderService;

import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.notFound;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderRestController {

    private final OrderService orderService;

//    /exists Checking whether the order exists or not

    @GetMapping("/test/{id}")
    public boolean exists(@PathVariable("id") Long id) {
        return orderService.existsById(id);
    }

//    /state - Getting the current state of the order, such as loaction, status and e.t.c.
    @GetMapping("/{id}")
//    @ResponseStatus(HttpStatus.NOT_FOUND)
    public OrderReadBaseDto state(@PathVariable("id") Long id) {
        return orderService.findById(id).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Long create(@RequestBody OrderCreateDto user) {
        return orderService.create(user);
    }

    // cancel - cancelling order by orderId, the body is orderId
    @DeleteMapping("/{id}")
    public ResponseEntity<?> cancel(@PathVariable("id") Long id) {
        return orderService.delete(id)
                ? noContent().build()
                : notFound().build();
    }

}
