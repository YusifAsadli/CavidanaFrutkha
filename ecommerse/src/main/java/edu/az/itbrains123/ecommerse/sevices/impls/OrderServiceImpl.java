package edu.az.itbrains123.ecommerse.sevices.impls;

import edu.az.itbrains123.ecommerse.dtos.order.OrderDashboardDto;
import edu.az.itbrains123.ecommerse.dtos.order.OrderDetailDto;
import edu.az.itbrains123.ecommerse.dtos.order.OrderDto;
import edu.az.itbrains123.ecommerse.dtos.order.OrderPlaceDto;
import edu.az.itbrains123.ecommerse.models.*;
import edu.az.itbrains123.ecommerse.repositories.BasketRepository;
import edu.az.itbrains123.ecommerse.repositories.OrderItemRepository;
import edu.az.itbrains123.ecommerse.repositories.OrderRepository;
import edu.az.itbrains123.ecommerse.repositories.UserRepository;
import edu.az.itbrains123.ecommerse.sevices.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final BasketRepository basketRepository;
    private final OrderItemRepository orderItemRepository;

    public OrderServiceImpl(OrderRepository orderRepository, ModelMapper modelMapper, UserRepository userRepository, BasketRepository basketRepository, OrderItemRepository orderItemRepository) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.basketRepository = basketRepository;
        this.orderItemRepository = orderItemRepository;
    }

    @Override
    public boolean placeOrder(OrderPlaceDto orderplaceDto, String userEmail) {
        UserEntity user = userRepository.findByEmail(userEmail);
        Order order = modelMapper.map(orderplaceDto, Order.class);
        List<Basket> findBasket = basketRepository.findByUserId(user.getId());
        for (Basket basket : findBasket) {
            OrderItems orderItems = new OrderItems();
            orderItems.setQuantity(basket.getQuantity());
            orderItems.setProduct(basket.getProduct());
        }
        order.setUser(user);
        orderRepository.save(order);
        return true;
    }

    @Override
    public List<OrderDashboardDto> getDashboardOrder() {
        List<Order> getOrders = orderRepository.findAll();
        List<OrderDashboardDto> orderDashboardDtos =getOrders.stream().map(order->modelMapper.map(order, OrderDashboardDto.class)).collect(Collectors.toUnmodifiableList());
        return orderDashboardDtos;
    }

    @Override
    public List<OrderDetailDto> getOrderById(Long id) {
        List<OrderItems> orderItems=orderItemRepository.findByOrderId(id);
        List<OrderDetailDto> orderDetailDto=orderItems.stream().map(item->modelMapper.map(item, OrderDetailDto.class)).collect(Collectors.toList());
        return orderDetailDto;
    }


}