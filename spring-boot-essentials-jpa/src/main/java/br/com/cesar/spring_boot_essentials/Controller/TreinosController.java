package br.com.cesar.spring_boot_essentials.Controller;


import br.com.cesar.spring_boot_essentials.Dto.TreinoDto;
import br.com.cesar.spring_boot_essentials.Exception.BadRequestException;
import br.com.cesar.spring_boot_essentials.Exception.NotFoundException;
import br.com.cesar.spring_boot_essentials.Service.TreinoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/treinos")
@RequiredArgsConstructor
@Validated
public class TreinosController {

    private final TreinoService treinoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarTreino(@Valid @RequestBody TreinoDto treinoDto) throws NotFoundException, BadRequestException {
        treinoService.criarTreino(treinoDto);
    }
}
