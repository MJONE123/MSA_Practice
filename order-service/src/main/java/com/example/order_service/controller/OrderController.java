package com.example.order_service.controller;

import com.example.order_service.domain.entity.Order;
import com.example.order_service.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
@Tag(name = "Order Controller", description = "주문 관련 API")

public class OrderController {

    private final OrderService orderService;

    @GetMapping
    @Operation(summary = "모든 주문 조회")

    public List<Order> getOrders() {
        return orderService.getOrders();
    }

    @PostMapping
    @Operation(summary = "주문 저장")

    public Order saveOrder(@RequestBody Order order) {
        return orderService.save(order);
    }
}
