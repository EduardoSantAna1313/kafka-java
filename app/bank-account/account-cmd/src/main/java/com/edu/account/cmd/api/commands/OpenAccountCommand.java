package com.edu.account.cmd.api.commands;

import com.edu.account.common.dto.AccountType;
import com.edu.cqrs.core.commands.BaseCommand;
import lombok.Data;

@Data
public class OpenAccountCommand extends BaseCommand {

    private String accountHolder;

    private AccountType accountType;

    private double openingBalance;

}
