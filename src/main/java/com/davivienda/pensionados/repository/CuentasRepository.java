package com.davivienda.pensionados.repository;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.davivienda.pensionados.domain.CuentasQuery;
import com.davivienda.pensionados.utils.PaginatedResult;
import com.davivienda.pensionados.dto.AperturaCuentaDto;
import com.davivienda.pensionados.dto.CuentaInactivaDto;

@Repository
public class CuentasRepository {
    private static final DateTimeFormatter SQL_DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private static final Set<String> APERTURAS_ALLOWED_SORTS = Set.of(
            "IdAfiliacion",
            "NumeroIdPensionado",
            "NombrePensionado",
            "NumeroCuentaPensionado",
            "FechaAperturaCuenta",
            "NombreEmpresa");

    private static final Set<String> INACTIVAS_ALLOWED_SORTS = Set.of(
            "IdAfiliacion",
            "NumeroIdPensionado",
            "NombrePensionado",
            "NumeroCuentaPensionado",
            "FechaAperturaCuenta",
            "FechaInactividad",
            "NombreEmpresa");

    private static final List<SqlParameter> APERTURAS_PARAMS = List.of(
            new SqlParameter("FechaInicio_Front", Types.VARCHAR),
            new SqlParameter("FechaFin_front", Types.VARCHAR),
            new SqlParameter("NumeroIdEmpresa", Types.NUMERIC),
            new SqlParameter("NumeroIdPensionado", Types.NUMERIC),
            new SqlParameter("TipoIdentificacion", Types.VARCHAR),
            new SqlParameter("NumeroCuentaPensionado", Types.NUMERIC),
            new SqlParameter("NumeroCuentaPagadora", Types.NUMERIC),
            new SqlParameter("IdAfiliacion", Types.NUMERIC),
            new SqlParameter("ASC", Types.BIT),
            new SqlParameter("CampoOrdenamiento", Types.NVARCHAR),
            new SqlParameter("Pagina", Types.INTEGER),
            new SqlParameter("Registros_X_Pagina", Types.INTEGER),
            new SqlOutParameter("Paginas", Types.BIGINT),
            new SqlOutParameter("Registros", Types.BIGINT));

    private static final List<SqlParameter> INACTIVAS_PARAMS = List.of(
            new SqlParameter("FechaInicio_Front", Types.VARCHAR),
            new SqlParameter("FechaFin_front", Types.VARCHAR),
            new SqlParameter("NumeroIdEmpresa", Types.NUMERIC),
            new SqlParameter("NumeroIdPensionado", Types.NUMERIC),
            new SqlParameter("TipoIdentificacion", Types.VARCHAR),
            new SqlParameter("NumeroCuentaPensionado", Types.NUMERIC),
            new SqlParameter("NumeroCuentaPagadora", Types.NUMERIC),
            new SqlParameter("ASC", Types.BIT),
            new SqlParameter("CampoOrdenamiento", Types.NVARCHAR),
            new SqlParameter("Pagina", Types.INTEGER),
            new SqlParameter("Registros_X_Pagina", Types.INTEGER),
            new SqlOutParameter("Paginas", Types.BIGINT),
            new SqlOutParameter("Registros", Types.BIGINT));

    private final JdbcTemplate jdbcTemplate;

    public CuentasRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate.getJdbcTemplate();
    }

    public PaginatedResult<AperturaCuentaDto> consultarAperturas(CuentasQuery query) {
        String sort = sanitizeSort(query.getCampoOrdenamiento(), APERTURAS_ALLOWED_SORTS, "IdAfiliacion");
        Map<String, Object> result = jdbcTemplate.call(con -> {
            CallableStatement cs = con.prepareCall("{call shppen.PR_REPORTE_APERTURA_CUENTAS_PENSIONADOS(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            setDate(cs, 1, query.getFechaInicio());
            setDate(cs, 2, query.getFechaFin());
            setNumeric(cs, 3, query.getNumeroIdEmpresa());
            setNumeric(cs, 4, query.getNumeroIdPensionado());
            setString(cs, 5, query.getTipoIdentificacion());
            setNumeric(cs, 6, query.getNumeroCuentaPensionado());
            setNumeric(cs, 7, query.getNumeroCuentaPagadora());
            setNumeric(cs, 8, query.getIdAfiliacion());
            cs.setBoolean(9, query.isAscending());
            setString(cs, 10, sort);
            cs.setInt(11, query.getPagina());
            cs.setInt(12, query.getRegistrosPorPagina());
            cs.registerOutParameter(13, Types.BIGINT);
            cs.registerOutParameter(14, Types.BIGINT);
            return cs;
        }, APERTURAS_PARAMS);

        List<AperturaCuentaDto> items = mapRows(result, this::mapAperturaCuenta);
        long totalRecords = extractLong(result, "Registros");
        long totalPages = extractLong(result, "Paginas");
        return new PaginatedResult<>(items, totalRecords, totalPages);
    }

    public PaginatedResult<CuentaInactivaDto> consultarInactivas(CuentasQuery query) {
        String sort = sanitizeSort(query.getCampoOrdenamiento(), INACTIVAS_ALLOWED_SORTS, "IdAfiliacion");
        Map<String, Object> result = jdbcTemplate.call(con -> {
            CallableStatement cs = con.prepareCall("{call shppen.PR_REPORTE_CUENTAS_INACTIVAS(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            setDate(cs, 1, query.getFechaInicio());
            setDate(cs, 2, query.getFechaFin());
            setNumeric(cs, 3, query.getNumeroIdEmpresa());
            setNumeric(cs, 4, query.getNumeroIdPensionado());
            setString(cs, 5, query.getTipoIdentificacion());
            setNumeric(cs, 6, query.getNumeroCuentaPensionado());
            setNumeric(cs, 7, query.getNumeroCuentaPagadora());
            cs.setBoolean(8, query.isAscending());
            setString(cs, 9, sort);
            cs.setInt(10, query.getPagina());
            cs.setInt(11, query.getRegistrosPorPagina());
            cs.registerOutParameter(12, Types.BIGINT);
            cs.registerOutParameter(13, Types.BIGINT);
            return cs;
        }, INACTIVAS_PARAMS);

        List<CuentaInactivaDto> items = mapRows(result, this::mapCuentaInactiva);
        long totalRecords = extractLong(result, "Registros");
        long totalPages = extractLong(result, "Paginas");
        return new PaginatedResult<>(items, totalRecords, totalPages);
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

    private AperturaCuentaDto mapAperturaCuenta(Map<String, Object> row) {
        return AperturaCuentaDto.builder()
                .idAfiliacion(toLong(row.get("IdAfiliacion")))
                .numeroIdPensionado(toLong(row.get("NumeroIdPensionado")))
                .desTipoIdentificacion(stringValue(row.get("DesTipoIdentificacion")))
                .nombrePensionado(stringValue(row.get("NombrePensionado")))
                .oficinaApertura(stringValue(row.get("OficinaApertura")))
                .numeroCuentaPensionado(toLong(row.get("NumeroCuentaPensionado")))
                .estadoCuenta(stringValue(row.get("EstadoCuenta")))
                .fechaAperturaCuenta(toLocalDate(row.get("FechaAperturaCuenta")))
                .desMedioTransacional(stringValue(row.get("DesMedioTransacional")))
                .desObjetivoCuenta(stringValue(row.get("DesObjetivoCuenta")))
                .cuentaEmpleador(toLong(row.get("CuentaEmpleador")))
                .numeroIdEmpresa(toLong(row.get("NumeroIdEmpresa")))
                .nombreEmpresa(stringValue(row.get("NombreEmpresa")))
                .build();
    }

    private CuentaInactivaDto mapCuentaInactiva(Map<String, Object> row) {
        return CuentaInactivaDto.builder()
                .idAfiliacion(toLong(row.get("IdAfiliacion")))
                .nombrePensionado(stringValue(row.get("NombrePensionado")))
                .numeroIdPensionado(toLong(row.get("NumeroIdPensionado")))
                .desTipoIdentificacion(stringValue(row.get("DesTipoIdentificacion")))
                .numeroCuentaPensionado(toLong(row.get("NumeroCuentaPensionado")))
                .fechaAperturaCuenta(toLocalDate(row.get("FechaAperturaCuenta")))
                .fechaUltimoRetiro(toLocalDate(row.get("FechaUltimoRetiro")))
                .fechaUltimoAbono(toLocalDate(row.get("FechaUltimoAbono")))
                .desObjetivoCuenta(stringValue(row.get("DesObjetivoCuenta")))
                .desMedioTransacional(stringValue(row.get("DesMedioTransacional")))
                .cuentaEmpleador(toLong(row.get("CuentaEmpleador")))
                .nombreEmpresa(stringValue(row.get("NombreEmpresa")))
                .numeroIdEmpresa(toLong(row.get("NumeroIdEmpresa")))
                .valorTotalMesadas(toBigDecimal(row.get("ValorTotalMesadas")))
                .fechaInactividad(toLocalDate(row.get("FechaInactividad")))
                .build();
    }

    private void setDate(CallableStatement cs, int index, LocalDate value) throws SQLException {
        Objects.requireNonNull(value, "La fecha es obligatoria para generar el reporte de cuentas");
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
        if (value instanceof Timestamp timestamp) {
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
    
}
