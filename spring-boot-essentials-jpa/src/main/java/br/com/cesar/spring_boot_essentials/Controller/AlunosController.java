package br.com.cesar.spring_boot_essentials.Controller;

import br.com.cesar.spring_boot_essentials.Dto.AlunoDto;
import br.com.cesar.spring_boot_essentials.Exception.BadRequestException;
import br.com.cesar.spring_boot_essentials.Service.AlunosService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/alunos")
@RequiredArgsConstructor
@Validated
public class AlunosController {
    private final AlunosService alunosService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarAluno(@Valid @RequestBody AlunoDto alunoDto) throws BadRequestException {
        alunosService.criarAluno(alunoDto);
    }
}
