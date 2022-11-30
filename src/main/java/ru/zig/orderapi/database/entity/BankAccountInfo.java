package ru.zig.orderapi.database.entity;


import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class BankAccountInfo {

    private Long bankcardNumber;
    private Long balanceBankcard;

}
