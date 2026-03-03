package com.davivienda.pensionados.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.davivienda.pensionados.dto.ReportColumnDto;
import com.davivienda.pensionados.dto.ReportConfigDto;
import com.davivienda.pensionados.dto.ReportFilterDto;
import com.davivienda.pensionados.model.transRepConsulta;
import com.davivienda.pensionados.model.transRepDetconsulta;
import com.davivienda.pensionados.model.transRepFiltrocons;
import com.davivienda.pensionados.repository.TransRepConsultaRepository;
import com.davivienda.pensionados.repository.TransRepDetconsultaRepository;
import com.davivienda.pensionados.repository.TransRepFiltroconsRepository;

@Service
@Transactional
public class ReportConfigService {

    private final TransRepConsultaRepository consultaRepository;
    private final TransRepDetconsultaRepository detconsultaRepository;
    private final TransRepFiltroconsRepository filtroconsRepository;

    public ReportConfigService(
            TransRepConsultaRepository consultaRepository,
            TransRepDetconsultaRepository detconsultaRepository,
            TransRepFiltroconsRepository filtroconsRepository) {
        this.consultaRepository = consultaRepository;
        this.detconsultaRepository = detconsultaRepository;
        this.filtroconsRepository = filtroconsRepository;
    }

    @Transactional(readOnly = true)
    public List<ReportConfigDto> listarReportes() {
        return consultaRepository.findAll().stream()
                .map(this::toReportConfigDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ReportConfigDto obtenerReporte(BigDecimal idconsulta) {
        transRepConsulta consulta = consultaRepository.findByIdconsulta(idconsulta)
                .orElseThrow(() -> new IllegalArgumentException("Reporte no encontrado: " + idconsulta));
        
        return toReportConfigDtoWithDetails(consulta);
    }

    public ReportConfigDto crearReporte(ReportConfigDto dto) {
        // Generate new ID (in a real scenario, this should be handled by a sequence or auto-increment)
        BigDecimal newId = consultaRepository.findAll().stream()
                .map(transRepConsulta::getIdconsulta)
                .max(BigDecimal::compareTo)
                .map(max -> max.add(BigDecimal.ONE))
                .orElse(BigDecimal.ONE);

        transRepConsulta consulta = transRepConsulta.builder()
                .idconsulta(newId)
                .idFuncionalidad(dto.getIdFuncionalidad())
                .idvista(dto.getIdvista())
                .nomconsulta(dto.getNomconsulta())
                .descconsulta(dto.getDescconsulta())
                .encab(dto.getEncab())
                .conteo(dto.getConteo())
                .regcontrol(dto.getRegcontrol())
                .usuCreaApp(dto.getUsuCreaApp())
                .fecCreacion(LocalDateTime.now())
                .build();

        consulta = consultaRepository.save(consulta);

        // Save columns
        if (dto.getColumns() != null) {
            saveColumns(newId, dto.getColumns());
        }

        // Save filters
        if (dto.getFilters() != null) {
            saveFilters(newId, dto.getFilters());
        }

        return toReportConfigDtoWithDetails(consulta);
    }

    public ReportConfigDto actualizarReporte(BigDecimal idconsulta, ReportConfigDto dto) {
        transRepConsulta consulta = consultaRepository.findByIdconsulta(idconsulta)
                .orElseThrow(() -> new IllegalArgumentException("Reporte no encontrado: " + idconsulta));

        consulta.setIdFuncionalidad(dto.getIdFuncionalidad());
        consulta.setIdvista(dto.getIdvista());
        consulta.setNomconsulta(dto.getNomconsulta());
        consulta.setDescconsulta(dto.getDescconsulta());
        consulta.setEncab(dto.getEncab());
        consulta.setConteo(dto.getConteo());
        consulta.setRegcontrol(dto.getRegcontrol());
        consulta.setUsuModApp(dto.getUsuModApp());
        consulta.setFecModApp(LocalDateTime.now());

        consulta = consultaRepository.save(consulta);

        // Delete and recreate columns
        detconsultaRepository.deleteByIdconsulta(idconsulta);
        if (dto.getColumns() != null) {
            saveColumns(idconsulta, dto.getColumns());
        }

        // Delete and recreate filters
        filtroconsRepository.deleteByIdconsulta(idconsulta);
        if (dto.getFilters() != null) {
            saveFilters(idconsulta, dto.getFilters());
        }

        return toReportConfigDtoWithDetails(consulta);
    }

    public void eliminarReporte(BigDecimal idconsulta) {
        if (!consultaRepository.findByIdconsulta(idconsulta).isPresent()) {
            throw new IllegalArgumentException("Reporte no encontrado: " + idconsulta);
        }

        filtroconsRepository.deleteByIdconsulta(idconsulta);
        detconsultaRepository.deleteByIdconsulta(idconsulta);
        consultaRepository.deleteById(idconsulta.longValue());
    }

    private void saveColumns(BigDecimal idconsulta, List<ReportColumnDto> columns) {
        BigDecimal nextId = detconsultaRepository.findAll().stream()
                .map(transRepDetconsulta::getIdDetconsulta)
                .max(BigDecimal::compareTo)
                .map(max -> max.add(BigDecimal.ONE))
                .orElse(BigDecimal.ONE);

        for (ReportColumnDto columnDto : columns) {
            transRepDetconsulta detconsulta = transRepDetconsulta.builder()
                    .idDetconsulta(nextId)
                    .idconsulta(idconsulta)
                    .idDetvista(columnDto.getIdDetvista())
                    .nomcampo(columnDto.getNomcampo())
                    .sumcolumna(columnDto.getSumcolumna())
                    .tiporelleno(columnDto.getTiporelleno())
                    .tipojust(columnDto.getTipojust())
                    .longitud(columnDto.getLongitud())
                    .build();
            detconsultaRepository.save(detconsulta);
            nextId = nextId.add(BigDecimal.ONE);
        }
    }

    private void saveFilters(BigDecimal idconsulta, List<ReportFilterDto> filters) {
        BigDecimal nextId = filtroconsRepository.findAll().stream()
                .map(transRepFiltrocons::getIdFiltro)
                .max(BigDecimal::compareTo)
                .map(max -> max.add(BigDecimal.ONE))
                .orElse(BigDecimal.ONE);

        for (ReportFilterDto filterDto : filters) {
            transRepFiltrocons filtrocons = transRepFiltrocons.builder()
                    .idFiltro(nextId)
                    .idconsulta(idconsulta)
                    .idDetvista(filterDto.getIdDetvista())
                    .orden(filterDto.getOrden())
                    .incluyente(filterDto.getIncluyente())
                    .tipoFiltro(filterDto.getTipoFiltro())
                    .valFiltro(filterDto.getValFiltro())
                    .idDetconsulta2(filterDto.getIdDetconsulta2())
                    .build();
            
            // Set date range values if present
            if (filterDto.getFechaInicio() != null) {
                filtrocons.setValFiltro(filterDto.getFechaInicio().toString());
            }
            if (filterDto.getFechaFin() != null) {
                // Store end date in a separate field or append to valFiltro
                // For simplicity, we'll append it to valFiltro with a separator
                if (filtrocons.getValFiltro() != null) {
                    filtrocons.setValFiltro(filtrocons.getValFiltro() + "|" + filterDto.getFechaFin().toString());
                } else {
                    filtrocons.setValFiltro(filterDto.getFechaFin().toString());
                }
            }
            
            filtroconsRepository.save(filtrocons);
            nextId = nextId.add(BigDecimal.ONE);
        }
    }

    private ReportConfigDto toReportConfigDto(transRepConsulta entity) {
        return ReportConfigDto.builder()
                .idconsulta(entity.getIdconsulta())
                .idFuncionalidad(entity.getIdFuncionalidad())
                .idvista(entity.getIdvista())
                .nomconsulta(entity.getNomconsulta())
                .descconsulta(entity.getDescconsulta())
                .encab(entity.getEncab())
                .conteo(entity.getConteo())
                .regcontrol(entity.getRegcontrol())
                .usuCreaApp(entity.getUsuCreaApp())
                .fecCreacion(entity.getFecCreacion())
                .usuModApp(entity.getUsuModApp())
                .fecModApp(entity.getFecModApp())
                .build();
    }

    private ReportConfigDto toReportConfigDtoWithDetails(transRepConsulta entity) {
        List<ReportColumnDto> columns = detconsultaRepository.findByIdconsulta(entity.getIdconsulta()).stream()
                .map(this::toReportColumnDto)
                .collect(Collectors.toList());

        List<ReportFilterDto> filters = filtroconsRepository.findByIdconsultaOrderByOrdenAsc(entity.getIdconsulta()).stream()
                .map(this::toReportFilterDto)
                .collect(Collectors.toList());

        return ReportConfigDto.builder()
                .idconsulta(entity.getIdconsulta())
                .idFuncionalidad(entity.getIdFuncionalidad())
                .idvista(entity.getIdvista())
                .nomconsulta(entity.getNomconsulta())
                .descconsulta(entity.getDescconsulta())
                .encab(entity.getEncab())
                .conteo(entity.getConteo())
                .regcontrol(entity.getRegcontrol())
                .usuCreaApp(entity.getUsuCreaApp())
                .fecCreacion(entity.getFecCreacion())
                .usuModApp(entity.getUsuModApp())
                .fecModApp(entity.getFecModApp())
                .columns(columns)
                .filters(filters)
                .build();
    }

    public List<Object> generarReporte(ReportConfigDto reportConfig) {
        // This method would contain the logic to generate the report based on the configuration
        // For now, we'll return a dummy list
        return new ArrayList<>();
    }

    private ReportFilterDto toReportFilterDto(transRepFiltrocons entity) {
        ReportFilterDto filterDto = ReportFilterDto.builder()
                .idFiltro(entity.getIdFiltro())
                .idDetvista(entity.getIdDetvista())
                .orden(entity.getOrden())
                .incluyente(entity.getIncluyente())
                .tipoFiltro(entity.getTipoFiltro())
                .valFiltro(entity.getValFiltro())
                .idDetconsulta2(entity.getIdDetconsulta2())
                .build();
        
        // Parse date range from valFiltro if it contains date information
        if (entity.getValFiltro() != null) {
            String[] parts = entity.getValFiltro().split("\\|");
            if (parts.length > 0) {
                try {
                    filterDto.setFechaInicio(LocalDateTime.parse(parts[0]));
                } catch (Exception e) {
                    // Not a valid date format
                }
            }
            if (parts.length > 1) {
                try {
                    filterDto.setFechaFin(LocalDateTime.parse(parts[1]));
                } catch (Exception e) {
                    // Not a valid date format
                }
            }
        }
        
        return filterDto;
    }

    private ReportColumnDto toReportColumnDto(transRepDetconsulta entity) {
        return ReportColumnDto.builder()
                .idDetconsulta(entity.getIdDetconsulta())
                .idDetvista(entity.getIdDetvista())
                .nomcampo(entity.getNomcampo())
                .sumcolumna(entity.getSumcolumna())
                .tiporelleno(entity.getTiporelleno())
                .tipojust(entity.getTipojust())
                .longitud(entity.getLongitud())
                .build();
    }
}
