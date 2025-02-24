package it.dst.server.template.service.user;

import it.dst.server.template.object.dto.OrderDTO;
import it.dst.server.template.object.dto.UserDTO;
import it.dst.server.template.object.model.Order;
import it.dst.server.template.object.model.User;
import it.dst.server.template.repository.OrderRepository;
import it.dst.server.template.repository.UserRepository;
import it.dst.server.template.tools.DevTools;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;

    public UserServiceImpl(UserRepository userRepository, OrderRepository orderRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream().map(DevTools::convertToDTO).toList();
    }

    @Override
    public Optional<UserDTO> getUserByEmail(String email) {
        return userRepository.findByEmail(email).map(DevTools::convertToDTO);
    }

    @Override
    @Transactional
    public UserDTO saveUser(UserDTO userDto) {
        User existingUser = userDto.getId() != null ? userRepository.findById(userDto.getId()).orElse(null) : null;
        User user = DevTools.convertToEntity(userDto);

        // 🔹 Se l'utente esiste già, manteniamo la password
        if (existingUser != null) {
            user.setPassword(existingUser.getPassword());
        }

        user = userRepository.save(user);
        return DevTools.convertToDTO(user);
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO newUser) {
        newUser.setId(id);
        return saveUser(newUser);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDTO findUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return DevTools.convertToDTO(user);
    }

    @Override
    public OrderDTO createOrder(Long userId, OrderDTO orderDto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Order order = new Order(null, orderDto.getProdotto(), orderDto.getPrezzo(), user);
        Order savedOrder = orderRepository.save(order);
        return new OrderDTO(savedOrder.getId(), savedOrder.getProdotto(), savedOrder.getPrezzo());
    }
}
