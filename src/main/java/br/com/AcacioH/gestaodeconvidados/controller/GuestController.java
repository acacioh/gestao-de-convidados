package br.com.AcacioH.gestaodeconvidados.controller;

import br.com.AcacioH.gestaodeconvidados.model.Guest;
import br.com.AcacioH.gestaodeconvidados.service.GuestService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping("guests")
public class GuestController {

    @Autowired
    private GuestService guestService;

    @GetMapping
    @ApiOperation(value = "Retorna a lista de convidados paginada", authorizations = {@Authorization(value = "jwtToken")})
    public Page<Guest> findAll(@ApiParam("Número da página iniciado em 0") @RequestParam(defaultValue = "0") @Min(0) Integer page,
                               @ApiParam("Tamanho da página") @RequestParam(defaultValue = "10") @Min(1) @Max(100) Integer size) {
        return guestService.findAll(page, size);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Cadastra um novo convidado", authorizations = {@Authorization(value = "jwtToken")})
    public Guest create(@ApiParam("Nome do convidado") @RequestBody @NotBlank String name) {
        return guestService.create(name);
    }

    @GetMapping("{id}")
    @ApiOperation(value = "Retorna as informações de um convidado específico", authorizations = {@Authorization(value = "jwtToken")})
    public Guest findById(@ApiParam("Identificador de um convidado") @PathVariable Integer id) {
        return guestService.findById(id);
    }

    @PutMapping
    @ApiOperation(value = "Atualiza as informações de um convidado", authorizations = {@Authorization(value = "jwtToken")})
    public Guest update(@RequestBody Guest guest) {
        return guestService.update(guest);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Remove um convidado da lista de convidados", authorizations = {@Authorization(value = "jwtToken")})
    public void delete(@ApiParam("Identificador de um convidado") @PathVariable Integer id) {
        guestService.delete(id);
    }
}
