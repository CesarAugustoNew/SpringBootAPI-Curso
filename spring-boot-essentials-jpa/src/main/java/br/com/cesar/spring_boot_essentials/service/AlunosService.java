package br.com.cesar.spring_boot_essentials.service;


import br.com.cesar.spring_boot_essentials.database.model.AlunosEntity;
import br.com.cesar.spring_boot_essentials.database.repository.IAlunosRepository;
import br.com.cesar.spring_boot_essentials.dto.AlunoDto;
import br.com.cesar.spring_boot_essentials.exception.BadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlunosService {

    private final IAlunosRepository alunosRepository;

    public void criarAluno(AlunoDto alunoDto) throws BadRequestException {
        AlunosEntity aluno = alunosRepository.findByEmail(alunoDto.getEmail())
                .orElse(null);

        if (aluno != null) {
            throw new BadRequestException("Aluno já cadastrado com este email");
        }

        alunosRepository.save(AlunosEntity.builder()
                .nome(alunoDto.getNome())
                .email(alunoDto.getEmail())
                .build());


    }
}
