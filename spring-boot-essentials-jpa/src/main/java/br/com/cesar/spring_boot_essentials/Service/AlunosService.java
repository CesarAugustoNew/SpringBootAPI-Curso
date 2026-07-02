package br.com.cesar.spring_boot_essentials.Service;


import br.com.cesar.spring_boot_essentials.Database.Model.AlunosEntity;
import br.com.cesar.spring_boot_essentials.Database.Repository.IAlunosRepository;
import br.com.cesar.spring_boot_essentials.Dto.AlunoDto;
import br.com.cesar.spring_boot_essentials.Exception.BadRequestException;
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
