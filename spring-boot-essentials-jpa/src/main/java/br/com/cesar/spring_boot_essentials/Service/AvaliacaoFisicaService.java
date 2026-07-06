package br.com.cesar.spring_boot_essentials.Service;

import br.com.cesar.spring_boot_essentials.Controller.AvaliacoesFisicasController;
import br.com.cesar.spring_boot_essentials.Database.Model.AlunosEntity;
import br.com.cesar.spring_boot_essentials.Database.Model.AvaliacoesFisicasEntity;
import br.com.cesar.spring_boot_essentials.Database.Repository.IAlunosRepository;
import br.com.cesar.spring_boot_essentials.Database.Repository.IAvaliacoesFisicasRepository;
import br.com.cesar.spring_boot_essentials.Dto.AvaliacaoFisicaDto;
import br.com.cesar.spring_boot_essentials.Dto.AvaliacoesFisicasProjection;
import br.com.cesar.spring_boot_essentials.Exception.BadRequestException;
import br.com.cesar.spring_boot_essentials.Exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class AvaliacaoFisicaService {

    private final IAlunosRepository alunosRepository;
    private final IAvaliacoesFisicasRepository avaliacoesFisicasRepository;

    public void criarAvaliacaoFisica(AvaliacaoFisicaDto avaliacaoFisicaDto) throws NotFoundException, BadRequestException{
        AlunosEntity aluno = alunosRepository.findById(avaliacaoFisicaDto.getAlunoId())
                .orElseThrow(() -> new NotFoundException("Aluno não encontrado"));

        AvaliacoesFisicasEntity avaliacoesFisicas = aluno.getAvaliacoesFisicas();
        if (avaliacoesFisicas != null) {
            throw new BadRequestException("Avaliação fisica já cadastrada para este aluno");
        }

        avaliacoesFisicas = AvaliacoesFisicasEntity.builder()
                .peso(avaliacaoFisicaDto.getPeso())
                .altura(avaliacaoFisicaDto.getAltura())
                .porcentagemGorduraCorporal(avaliacaoFisicaDto.getPorcentagemGorduraCorporal())
                .build();

        aluno.setAvaliacoesFisicas(avaliacoesFisicas);
        alunosRepository.save(aluno);
    }

    public List<AvaliacoesFisicasProjection> getAllAvaliacoes() {
        return avaliacoesFisicasRepository.getAllAvaliacoes();
    }

    public Page<AvaliacoesFisicasProjection> getAllAvalaiacoesPageable(Integer page, Integer size) {
        return  avaliacoesFisicasRepository.getAllAvaliacoesPage(PageRequest.of(page, size));
    }
}
