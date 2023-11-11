package com.rafael.pizzeria;

import com.rafael.pizzeria.model.dto.OrderDTO;
import com.rafael.pizzeria.model.dto.RamdonOrderDTO;
import com.rafael.pizzeria.model.entity.Customer;
import com.rafael.pizzeria.model.entity.Order;
import com.rafael.pizzeria.model.mapper.IOrderMapper;
import com.rafael.pizzeria.repository.IOrderRepository;
import com.rafael.pizzeria.service.impl.OrderService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class OrderServiceTest {
    @Mock
    private IOrderRepository orderRepository;
    @Mock
    private IOrderMapper orderMapper;
    @InjectMocks
    private OrderService orderService;

    public OrderServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAll() {
        // Arrange
        Order order = new Order();
        order.setCustomer(Customer.builder().name("John Doe").build());
        when(orderRepository.findAll()).thenReturn(List.of(order));
        when(orderMapper.toDTO(order)).thenReturn(new OrderDTO());

        // Act
        List<OrderDTO> result = orderService.getAll();

        // Assert
        verify(orderRepository).findAll();
        verify(orderMapper).toDTO(order);
        assert(result.size() == 1);
        assert(result.get(0).getCustomer().getName().equals("John Doe"));
    }

    @Test
    public void testGetAllOrderDateAfter() {
        // Arrange
        LocalDateTime fecha = LocalDateTime.now();
        Order order = new Order();
        when(orderRepository.findAllByDateAfter(fecha)).thenReturn(List.of(order));
        when(orderMapper.toDTO(order)).thenReturn(new OrderDTO());

        // Act
        List<OrderDTO> result = orderService.getAllOrderDateAfter(fecha);

        // Assert
        verify(orderRepository).findAllByDateAfter(fecha);
        verify(orderMapper).toDTO(order);
        assert(result.size() == 1);
    }

    @Test
    public void testGetAllMethodByMethods() {
        // Arrange
        List<String> methods = Arrays.asList("credit card", "paypal");
        Order order = new Order();
        when(orderRepository.findAllByMethodIn(methods)).thenReturn(List.of(order));
        when(orderMapper.toDTO(order)).thenReturn(new OrderDTO());

        // Act
        List<OrderDTO> result = orderService.getAllMethodByMethods(methods);

        // Assert
        verify(orderRepository).findAllByMethodIn(methods);
        verify(orderMapper).toDTO(order);
        assert(result.size() == 1);
    }

    @Test
    public void testSaveRandomOrder() {
        // Arrange
        RamdonOrderDTO orderDTO = new RamdonOrderDTO();
        when(orderRepository.saveRandomOrder(orderDTO.getIdCustomer(), orderDTO.getMethod())).thenReturn(true);

        // Act
        boolean result = orderService.saveRandomOrder(orderDTO);

        // Assert
        verify(orderRepository).saveRandomOrder(orderDTO.getIdCustomer(), orderDTO.getMethod());
        assert(result);
    }
}