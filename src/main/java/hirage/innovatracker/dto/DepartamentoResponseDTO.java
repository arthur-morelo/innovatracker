package hirage.innovatracker.dto;

import hirage.innovatracker.model.TdDepartamento;

public record DepartamentoResponseDTO(
        Long idtDepartamento,
        String sglDepartamento,
        String nmeDepartamento
) {
    public static DepartamentoResponseDTO from(TdDepartamento departamento) {
        return new DepartamentoResponseDTO(
                departamento.getIdtDepartamento(),
                departamento.getSglDepartamento(),
                departamento.getNmeDepartamento()
        );
    }
}
