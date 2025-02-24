package it.dst.server.template.service.user;


import it.dst.server.template.object.dto.OrderDTO;
import it.dst.server.template.object.dto.UserDTO;
import it.dst.server.template.object.model.Order;
import it.dst.server.template.object.model.User;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public interface UserService  {


    List<UserDTO> getAllUsers();

    Optional<UserDTO> getUserByEmail(String email);

    UserDTO saveUser(UserDTO user);

    UserDTO updateUser(Long id, UserDTO user);

    void deleteUser(Long id);

    // ORDERS
    OrderDTO createOrder(Long userId, OrderDTO order);

    UserDTO findUserById(Long id);
}
