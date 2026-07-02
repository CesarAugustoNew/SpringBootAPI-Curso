package br.com.cesar.spring_boot_essentials.Controller;

import br.com.cesar.spring_boot_essentials.Dto.AvaliacaoFisicaDto;
import br.com.cesar.spring_boot_essentials.Exception.BadRequestException;
import br.com.cesar.spring_boot_essentials.Exception.NotFoundException;
import br.com.cesar.spring_boot_essentials.Service.AvaliacaoFisicaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/avaliacoes")
@RequiredArgsConstructor
public class AvaliacoesFisicasController {

    private final AvaliacaoFisicaService avaliacaoFisicaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarAvaliacaoFisica(@Valid @RequestBody AvaliacaoFisicaDto avaliacaoFisicaDto) throws NotFoundException, BadRequestException {
        avaliacaoFisicaService.criarAvaliacaoFisica(avaliacaoFisicaDto);
    }
}
