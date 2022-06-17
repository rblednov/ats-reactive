package ru.rblednov.atsreactive.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class TicketsResponseDTO {
    private List<TicketsDTO> tickets;
    private Integer page;
    private Integer size;
}
