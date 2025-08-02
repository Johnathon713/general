package org.john.general.auth.client.controller;

import lombok.RequiredArgsConstructor;
import org.john.general.auth.client.entity.ClientBO;
import org.john.general.auth.client.service.ClientService;
import org.john.general.base.Result;
import org.john.general.base.exception.GeneralDbException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author llxx
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth_service/client")
public class ClientController {
    private final ClientService clientService;

    @PostMapping("init")
    public Result<String> init(@RequestBody ClientBO clientBO) {
        if (true) {
            throw new GeneralDbException("dfa");
        }
        return Result.success(clientService.init(clientBO));
    }
}
