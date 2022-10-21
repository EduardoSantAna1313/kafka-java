package com.edu.account.common.events;

import com.edu.account.common.dto.AccountType;
import com.edu.cqrs.core.events.BaseEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class AccountOpenedEvent extends BaseEvent {
    private String accountHolder;

    private AccountType accountType;

    private Date created;

    private double openingBalance;
}
