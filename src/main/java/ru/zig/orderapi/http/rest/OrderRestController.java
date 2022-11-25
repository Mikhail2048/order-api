package ru.zig.orderapi.http.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.zig.orderapi.service.OrderService;

import java.util.Optional;

import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.notFound;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderRestController {

    private final OrderService orderService;

    @Transactional
    public UserReadDto create(UserCreateEditDto userDto) {
        return Optional.of(userDto)
                .map(dto -> {
                    uploadImage(dto.getImage());
                    return userCreateEditMapper.map(dto);
                })
                .map(userRepository::save)
                .map(userReadMapper::map)
                .orElseThrow();
    }

    // cancel - cancelling order by orderId, the body is orderId
    @DeleteMapping("/{id}")
    public ResponseEntity<?> cancel(@PathVariable("id") Long id) {
        return orderService.delete(id)
                ? noContent().build()
                : notFound().build();
    }

}
