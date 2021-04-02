package ru.mirea.trpp_lab2_var8.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/** Ответ на healthCheck. */
@Getter
@Setter
@AllArgsConstructor
public class HealthResponse {

    /** Статус работы. */
    private String status;
}
