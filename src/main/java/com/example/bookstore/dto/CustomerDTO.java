package com.example.bookstore.dto;
import java.util.List;

import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDTO {
        private int customerId;
        private String name;
        private List<OrderDTO> orders;
    }

