package ru.zig.orderapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.zig.orderapi.database.repository.OrderRepository;
import ru.zig.orderapi.dto.OrderCreateDto;
import ru.zig.orderapi.dto.OrderReadBaseDto;
import ru.zig.orderapi.mapper.OrderCreateMapper;
import ru.zig.orderapi.mapper.OrderReadBaseMapper;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderService {

    private final OrderRepository orderRepository;

    private final OrderReadBaseMapper orderReadBaseMapper;
    private final OrderCreateMapper orderCreateMapper;

    @Transactional
    public Long create(OrderCreateDto orderCreateDto){
        return Optional.of(orderCreateDto)
                .map(orderDto -> orderCreateMapper.map(orderDto))
                .map(orderRepository::save)
                .orElseThrow().getId();
    }

    @Transactional
    public boolean delete(Long id) {
        return orderRepository.findById(id)
                .map(entity -> {
                    orderRepository.delete(entity);
                    orderRepository.flush();
                    return true;
                })
                .orElse(false);
    }

    public Optional<OrderReadBaseDto> findById(Long id) {
        return orderRepository.findById(id)
                .map(orderReadBaseMapper::map);
    }

    public boolean existsById(Long id) {
        return orderRepository.existsById(id);
    }
}
