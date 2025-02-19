package it.dst.server.template.tools;

import it.dst.server.template.object.dto.OrderDTO;
import it.dst.server.template.object.dto.UserDTO;
import it.dst.server.template.object.model.Order;
import it.dst.server.template.object.model.User;
import org.springframework.util.ObjectUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DevTools {

    public static UserDTO convertToDTO(User user) {
        if (user == null) {
            return null;
        }

        List<OrderDTO> orderDTOs = new ArrayList<>();
        if (!ObjectUtils.isEmpty(user.getOrders())) {
            orderDTOs = user.getOrders().stream()
                    .map(o -> new OrderDTO(o.getId(), o.getProdotto(), o.getPrezzo()))
                    .toList();
        }

        return new UserDTO(user.getId(), user.getNome(), user.getEmail(), user.getPassword(), orderDTOs);  // 🔹 Inclusa la password
    }

    public static User convertToEntity(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        }

        User user = User.builder()
                .id(userDTO.getId())
                .nome(userDTO.getNome())
                .email(userDTO.getEmail())
                .password(userDTO.getPassword())  // 🔹 Ora la password viene passata dal DTO
                .build();

        if (userDTO.getOrders() != null) {
            List<Order> orders = userDTO.getOrders().stream()
                    .map(orderDTO -> Order.builder()
                            .id(orderDTO.getId())
                            .prodotto(orderDTO.getProdotto())
                            .prezzo(orderDTO.getPrezzo())
                            .user(user)
                            .build())
                    .collect(Collectors.toList());

            user.setOrders(orders);
        }

        return user;
    }
}
