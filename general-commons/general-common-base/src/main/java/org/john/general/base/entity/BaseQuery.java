package org.john.general.base.entity;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author llxx
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseQuery implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @NotNull
    @Min(1L)
    @Max(100000000L)
    private Long current = 1L;

    @NotNull
    @Min(1L)
    @Max(1000L)
    private Long size = 10L;
}
