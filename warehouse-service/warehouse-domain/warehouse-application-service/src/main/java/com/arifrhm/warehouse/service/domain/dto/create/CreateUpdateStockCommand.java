package com.arifrhm.warehouse.service.domain.dto.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Builder
public class CreateUpdateStockCommand {

    @NotNull
    private final UUID warehouseId;

    @NotNull
    private final UUID productId;

    @NotNull
    private final int quantity;


}
