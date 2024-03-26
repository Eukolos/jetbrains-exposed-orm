package com.eukolos.jetbrainsexposedorm.dto;

import java.util.List;

public record CustomerDto(
        String name,
        String city,
        List<String> orders
) {
}


