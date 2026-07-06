package br.com.cesar.spring_boot_essentials.Dto;

import java.math.BigDecimal;

public interface AvaliacoesFisicasProjection {
    Integer getIdAluno();
    String getNomeAluno();
    Integer getIdAvaliacao();
    BigDecimal getPeso();
    BigDecimal getAltura();
    BigDecimal getPercentualGorduraCorporal();
}
