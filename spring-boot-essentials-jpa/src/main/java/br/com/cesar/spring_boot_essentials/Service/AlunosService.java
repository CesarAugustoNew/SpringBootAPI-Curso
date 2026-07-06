package br.com.cesar.spring_boot_essentials.Service;


import br.com.cesar.spring_boot_essentials.Database.Model.AlunosEntity;
import br.com.cesar.spring_boot_essentials.Database.Model.AvaliacoesFisicasEntity;
import br.com.cesar.spring_boot_essentials.Database.Model.TreinosEntity;
import br.com.cesar.spring_boot_essentials.Database.Repository.IAlunosRepository;
import br.com.cesar.spring_boot_essentials.Database.Repository.IAvaliacoesFisicasRepository;
import br.com.cesar.spring_boot_essentials.Database.Repository.ITreinosRepository;
import br.com.cesar.spring_boot_essentials.Dto.AlunoDto;
import br.com.cesar.spring_boot_essentials.Dto.AvaliacaoFisicaDto;
import br.com.cesar.spring_boot_essentials.Exception.BadRequestException;
import br.com.cesar.spring_boot_essentials.Exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlunosService {

    private final IAvaliacoesFisicasRepository avaliacoesFisicasRepository;
    private final ITreinosRepository treinosRepository;
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

    public AvaliacoesFisicasEntity getAlunoAvaliacao(Integer alunoId) throws NotFoundException{
        AlunosEntity aluno = alunosRepository.findByIdFetch(alunoId)
                .orElseThrow(() -> new NotFoundException("Alunos não encontrado"));

        AvaliacoesFisicasEntity avaliacao = aluno.getAvaliacoesFisicas();
        if (avaliacao == null) {
            throw new NotFoundException("Avaliação física não encontrada para este aluno");
        }

        return avaliacao;
    }

    public void deletarAluno (Integer alunosId) throws NotFoundException{

        AlunosEntity aluno = alunosRepository.findById(alunosId)
                .orElseThrow(() -> new NotFoundException("Aluno não encontrado"));

        List<Integer> treinosAlunoIds = aluno.getTreinos().stream()
                .map(TreinosEntity::getId)
                .toList();

        treinosRepository.deleteAllById(treinosAlunoIds);

        alunosRepository.deleteById(alunosId);

        avaliacoesFisicasRepository.deleteById(aluno.getAvaliacoesFisicas().getId());
    }

}




















