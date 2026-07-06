package br.com.cesar.spring_boot_essentials.Controller;

import br.com.cesar.spring_boot_essentials.Dto.AvaliacaoFisicaDto;
import br.com.cesar.spring_boot_essentials.Dto.AvaliacoesFisicasProjection;
import br.com.cesar.spring_boot_essentials.Exception.BadRequestException;
import br.com.cesar.spring_boot_essentials.Exception.NotFoundException;
import br.com.cesar.spring_boot_essentials.Service.AvaliacaoFisicaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AvaliacoesFisicasProjection> getAllAvaliacoes() {
        return  avaliacaoFisicaService.getAllAvaliacoes();
    }

    @GetMapping("/page/{page}/size/{size}")
    @ResponseStatus(HttpStatus.OK)
    public Page<AvaliacoesFisicasProjection> getAllAvaliacoesPageable(@PathVariable Integer page,
                                                                      @PathVariable Integer size){
        return  avaliacaoFisicaService.getAllAvalaiacoesPageable(page, size);
    }
}
