package com.davivienda.pensionados.repository;

import java.math.BigDecimal;
// import java.security.Timestamp; // Removed because it's not needed
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.davivienda.pensionados.domain.MesadasQuery;
import com.davivienda.pensionados.dto.PagoMesadaDto;
import com.davivienda.pensionados.dto.RechazoMesadaDto;
import com.davivienda.pensionados.dto.CertificadoMesadaDto;
import com.davivienda.pensionados.utils.PaginatedResult;

@Repository
public class MesadasRepository {

private static final DateTimeFormatter SQL_DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final DateTimeFormatter CERTIFICATE_DATE_FORMAT = DateTimeFormatter.BASIC_ISO_DATE;

    private static final Set<String> PAGOS_ALLOWED_SORTS = Set.of(
            "IdAfiliacion",
            "IdentificadorDetalle",
            "NumeroIdPensionado",
            "NombrePensionado",
            "NombreEmpresa",
            "FechaAbonoMesada");

    private static final Set<String> RECHAZOS_ALLOWED_SORTS = Set.of(
            "IdAfiliacion",
            "IdentificadorDetalle",
            "NumeroIdPensionado",
            "NombrePensionado",
            "NombreEmpresa");

    private static final List<SqlParameter> PAGO_MESADAS_PARAMS = List.of(
            new SqlParameter("FechaInicio_Front", Types.VARCHAR),
            new SqlParameter("FechaFin_front", Types.VARCHAR),
            new SqlParameter("NumeroIdEmpresa", Types.NUMERIC),
            new SqlParameter("NumeroAfiliacion", Types.NUMERIC),
            new SqlParameter("NumeroCuentaPensionado", Types.NUMERIC),
            new SqlParameter("NumeroIdPensionado", Types.NUMERIC),
            new SqlParameter("TipoIdentificacion", Types.VARCHAR),
            new SqlParameter("NumeroCuentaPagadora", Types.NUMERIC),
            new SqlParameter("ASC", Types.BIT),
            new SqlParameter("CampoOrdenamiento", Types.NVARCHAR),
            new SqlParameter("Pagina", Types.INTEGER),
            new SqlParameter("Registros_X_Pagina", Types.INTEGER),
            new SqlOutParameter("Paginas", Types.BIGINT),
            new SqlOutParameter("Registros", Types.BIGINT));

    private static final List<SqlParameter> RECHAZO_PARAMS = List.of(
            new SqlParameter("FechaInicio_Front", Types.VARCHAR),
            new SqlParameter("FechaFin_front", Types.VARCHAR),
            new SqlParameter("NumeroIdEmpresa", Types.NUMERIC),
            new SqlParameter("NumeroCuentaPensionado", Types.NUMERIC),
            new SqlParameter("NumeroIdPensionado", Types.NUMERIC),
            new SqlParameter("TipoIdentificacion", Types.VARCHAR),
            new SqlParameter("NumeroCuentaPagadora", Types.NUMERIC),
            new SqlParameter("NumeroAfiliacion", Types.NUMERIC),
            new SqlParameter("ASC", Types.BIT),
            new SqlParameter("CampoOrdenamiento", Types.NVARCHAR),
            new SqlParameter("Pagina", Types.INTEGER),
            new SqlParameter("Registros_X_Pagina", Types.INTEGER),
            new SqlOutParameter("Paginas", Types.BIGINT),
            new SqlOutParameter("Registros", Types.BIGINT));

    private static final List<SqlParameter> CERTIFICADO_PARAMS = List.of(
            new SqlParameter("Fecha_Pago_Init", Types.VARCHAR),
            new SqlParameter("Fecha_Pago_End", Types.VARCHAR),
            new SqlOutParameter("FlagSalida", Types.NUMERIC),
            new SqlOutParameter("msgSalida", Types.NVARCHAR));

    private final JdbcTemplate jdbcTemplate;

    public MesadasRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate.getJdbcTemplate();
    }

    public PaginatedResult consultarPagos(MesadasQuery query) {
        String sort = sanitizeSort(query.getCampoOrdenamiento(), PAGOS_ALLOWED_SORTS, "NumeroIdPensionado");
        Map<String, Object> result = jdbcTemplate.call(con -> {
            CallableStatement cs = con.prepareCall("{call shppen.PR_REPORTE_PAGO_MESADAS_PENSIONALES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            setDate(cs, 1, query.getFechaInicio());
            setDate(cs, 2, query.getFechaFin());
            setNumeric(cs, 3, query.getNumeroIdEmpresa());
            setNumeric(cs, 4, query.getNumeroAfiliacion());
            setNumeric(cs, 5, query.getNumeroCuentaPensionado());
            setNumeric(cs, 6, query.getNumeroIdPensionado());
            setString(cs, 7, query.getTipoIdentificacion());
            setNumeric(cs, 8, query.getNumeroCuentaPagadora());
            cs.setBoolean(9, query.isAscending());
            setString(cs, 10, sort);
            cs.setInt(11, query.getPagina());
            cs.setInt(12, query.getRegistrosPorPagina());
            cs.registerOutParameter(13, Types.BIGINT);
            cs.registerOutParameter(14, Types.BIGINT);
            return cs;
        }, PAGO_MESADAS_PARAMS);

        List<PagoMesadaDto> items = mapRows(result, this::mapPagoMesada);
        long totalRecords = extractLong(result, "Registros");
        long totalPages = extractLong(result, "Paginas");
        return new PaginatedResult(items, totalRecords, totalPages);
    }

    public PaginatedResult consultarRechazos(MesadasQuery query) {
        String sort = sanitizeSort(query.getCampoOrdenamiento(), RECHAZOS_ALLOWED_SORTS, "NumeroIdPensionado");
        Map<String, Object> result = jdbcTemplate.call(con -> {
            CallableStatement cs = con.prepareCall("{call shppen.PR_REPORTE_RECHAZO_PAGO_MESADAS(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            setDate(cs, 1, query.getFechaInicio());
            setDate(cs, 2, query.getFechaFin());
            setNumeric(cs, 3, query.getNumeroIdEmpresa());
            setNumeric(cs, 4, query.getNumeroCuentaPensionado());
            setNumeric(cs, 5, query.getNumeroIdPensionado());
            setString(cs, 6, query.getTipoIdentificacion());
            setNumeric(cs, 7, query.getNumeroCuentaPagadora());
            setNumeric(cs, 8, query.getNumeroAfiliacion());
            cs.setBoolean(9, query.isAscending());
            setString(cs, 10, sort);
            cs.setInt(11, query.getPagina());
            cs.setInt(12, query.getRegistrosPorPagina());
            cs.registerOutParameter(13, Types.BIGINT);
            cs.registerOutParameter(14, Types.BIGINT);
            return cs;
        }, RECHAZO_PARAMS);

        List<RechazoMesadaDto> items = mapRows(result, this::mapRechazoMesada);
        long totalRecords = extractLong(result, "Registros");
        long totalPages = extractLong(result, "Paginas");
        return new PaginatedResult(items, totalRecords, totalPages);
    }

    public List<CertificadoMesadaDto> consultarCertificados(LocalDate fechaInicio, LocalDate fechaFin) {
        Map<String, Object> result = jdbcTemplate.call(con -> {
            CallableStatement cs = con.prepareCall("{call shppen.PR_CERTIFICADOS_MESADAS(?,?,?,?)}");
            cs.setString(1, formatCertificateDate(fechaInicio));
            cs.setString(2, formatCertificateDate(fechaFin));
            cs.registerOutParameter(3, Types.NUMERIC);
            cs.registerOutParameter(4, Types.NVARCHAR);
            return cs;
        }, CERTIFICADO_PARAMS);

        Number flag = (Number) result.get("FlagSalida");
        if (flag != null && flag.intValue() != 0) {
            String message = Objects.toString(result.get("msgSalida"), "Error desconocido generando certificados de mesadas");
            throw new DataAccessException(message) {
                private static final long serialVersionUID = 1L;
            };
        }

        return mapRows(result, this::mapCertificadoMesada);
    }

    private <T> List<T> mapRows(Map<String, Object> result, Function<Map<String, Object>, T> mapper) {
        return result.entrySet().stream()
                .filter(entry -> entry.getKey().startsWith("#result-set"))
                .findFirst()
                .map(entry -> castResult(entry.getValue()).stream().map(mapper).collect(Collectors.toList()))
                .orElseGet(List::of);
    }

    @SuppressWarnings("unchecked")
    private List<Map<String, Object>> castResult(Object value) {
        return (List<Map<String, Object>>) value;
    }

    private PagoMesadaDto mapPagoMesada(Map<String, Object> row) {
        return PagoMesadaDto.builder()
                .identificadorDetalle(toLong(row.get("IdentificadorDetalle")))
                .numeroAfiliacionPago(toLong(row.get("NoAfiliacionPago")))
                .oficinaApertura(toPlainString(row.get("OficinaApertura")))
                .numeroCuentaPensionado(toPlainString(row.get("NumeroCuentaPensionado")))
                .fechaAbonoMesada(toLocalDate(row.get("FechaAbonoMesada")))
                .numeroIdPensionado(toLong(row.get("NumeroIdPensionado")))
                .tipoId(stringValue(row.get("TipoId")))
                .tipoIdentificacion(stringValue(row.get("TipoIdentificacion")))
                .tipoIdColpensiones(stringValue(row.get("TipoId_ColP")))
                .nombrePensionado(stringValue(row.get("NombrePensionado")))
                .numeroCuentaPagadora(toPlainString(row.get("NumeroCuentaPagadora")))
                .valorMesada(toBigDecimal(row.get("ValorMesada")))
                .estadoPago(stringValue(row.get("EstadoPago")))
                .numeroIdEmpresa(toLong(row.get("NumeroIdEmpresa")))
                .nombreEmpresa(stringValue(row.get("NombreEmpresa")))
                .build();
    }

    private RechazoMesadaDto mapRechazoMesada(Map<String, Object> row) {
        return RechazoMesadaDto.builder()
                .identificadorDetalle(toLong(row.get("IdentificadorDetalle")))
                .numeroAfiliacionPago(toLong(row.get("NoAfiliacionPago")))
                .oficinaApertura(toPlainString(row.get("OficinaApertura")))
                .numeroCuentaPensionado(toPlainString(row.get("NumeroCuentaPensionado")))
                .fechaAbonoMesada(toLocalDate(row.get("FechaAbonoMesada")))
                .numeroIdPensionado(toLong(row.get("NumeroIdPensionado")))
                .tipoId(stringValue(row.get("TipoId")))
                .tipoIdentificacion(stringValue(row.get("TipoIdentificacion")))
                .tipoIdColpensiones(stringValue(row.get("TipoId_ColP")))
                .nombrePensionado(stringValue(row.get("NombrePensionado")))
                .numeroCuentaPagadora(toPlainString(row.get("NumeroCuentaPagadora")))
                .valorMesada(toBigDecimal(row.get("ValorMesada")))
                .motivoRechazo(stringValue(row.get("MotivoRechazo")))
                .numeroIdEmpresa(toLong(row.get("NumeroIdEmpresa")))
                .nombreEmpresa(stringValue(row.get("NombreEmpresa")))
                .build();
    }

    private CertificadoMesadaDto mapCertificadoMesada(Map<String, Object> row) {
        return CertificadoMesadaDto.builder()
                .tipoDocumento(stringValue(row.get("TipoDocumento")))
                .numeroDocumento(stringValue(row.get("NumeroDocumento")))
                .primerApellido(stringValue(row.get("PrimerApellido")))
                .segundoApellido(stringValue(row.get("SegundoApellido")))
                .primerNombre(stringValue(row.get("PrimerNombre")))
                .segundoNombre(stringValue(row.get("SegundoNombre")))
                .periodoNomina(stringValue(row.get("PeriodoNomina")))
                .referencia(stringValue(row.get("Referencia")))
                .banco(stringValue(row.get("Banco")))
                .sucursal(stringValue(row.get("Sucursal")))
                .cuenta(stringValue(row.get("Cuenta")))
                .tipoCuenta(stringValue(row.get("TipodeCuenta")))
                .valorNeto(toBigDecimal(row.get("ValorNeto")))
                .estadoPago(stringValue(row.get("EstadoPago")))
                .fechaPago(parseCertificateDate(row.get("FechaPago")))
                .descripcionCausalNoPago(stringValue(row.get("DescripcionCausalNoPago")))
                .causalNoPago(stringValue(row.get("CausalNoPago")))
                .build();
    }

    private void setDate(CallableStatement cs, int index, LocalDate value) throws SQLException {
        Objects.requireNonNull(value, "La fecha es obligatoria para generar el reporte de mesadas");
        cs.setString(index, value.format(SQL_DATE_FORMAT));
    }

    private void setNumeric(CallableStatement cs, int index, Long value) throws SQLException {
        if (value == null) {
            cs.setNull(index, Types.NUMERIC);
        } else {
            cs.setLong(index, value);
        }
    }

    private void setString(CallableStatement cs, int index, String value) throws SQLException {
        if (value == null || value.isBlank()) {
            cs.setNull(index, Types.VARCHAR);
        } else {
            cs.setString(index, value.trim());
        }
    }

    private String sanitizeSort(String requested, Set<String> allowed, String defaultColumn) {
        if (requested == null || requested.isBlank()) {
            return defaultColumn;
        }
        String trimmed = requested.trim();
        return allowed.stream()
                .filter(candidate -> candidate.equalsIgnoreCase(trimmed))
                .findFirst()
                .orElse(defaultColumn);
    }

    private long extractLong(Map<String, Object> result, String key) {
        Object value = result.get(key);
        if (value instanceof Number number) {
            return number.longValue();
        }
        return 0L;
    }

    private String toPlainString(Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof BigDecimal bigDecimal) {
            return bigDecimal.toPlainString();
        }
        if (value instanceof Number number) {
            return new BigDecimal(number.toString()).toPlainString();
        }
        return value.toString();
    }

    private Long toLong(Object value) {
        if (value instanceof Number number) {
            return number.longValue();
        }
        if (value instanceof String str && !str.isBlank()) {
            try {
                return Long.parseLong(str.replace(":", "").trim());
            } catch (NumberFormatException ignored) {
                return null;
            }
        }
        return null;
    }

    private String stringValue(Object value) {
        return value != null ? value.toString().trim() : null;
    }

    private BigDecimal toBigDecimal(Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof BigDecimal bigDecimal) {
            return bigDecimal;
        }
        if (value instanceof Number number) {
            return new BigDecimal(number.toString());
        }
        try {
            return new BigDecimal(value.toString());
        } catch (NumberFormatException ex) {
            return null;
        }
    }

    private LocalDate toLocalDate(Object value) {
        if (value instanceof LocalDate localDate) {
            return localDate;
        }
        if (value instanceof java.sql.Timestamp timestamp) {
            return timestamp.toLocalDateTime().toLocalDate();
        }
        if (value instanceof java.sql.Date date) {
            return date.toLocalDate();
        }
        if (value instanceof String str && !str.isBlank()) {
            try {
                return LocalDate.parse(str.substring(0, 10));
            } catch (Exception ignored) {
                // fall through
            }
        }
        return null;
    }

    private String formatCertificateDate(LocalDate value) {
        Objects.requireNonNull(value, "Las fechas de certificados son obligatorias");
        return value.format(CERTIFICATE_DATE_FORMAT);
    }

    private LocalDate parseCertificateDate(Object value) {
        if (value instanceof String str && !str.isBlank()) {
            try {
                return LocalDate.parse(str.trim(), CERTIFICATE_DATE_FORMAT);
            } catch (Exception ignored) {
                return null;
            }
        }
        return toLocalDate(value);
    }
    
}
