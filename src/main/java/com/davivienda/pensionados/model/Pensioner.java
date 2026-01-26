package com.davivienda.pensionados.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name = "Pensioner")
public class Pensioner {
    @Id
    @Column(name = "NumeroIdPensionado")
    private Long numeroIdPensionado;

    @Column(name = "TipoId")
    private Long tipoId;
	
	@Column(name = "TipoCliente")
    private String tipoCliente;

    @Column(name = "PrimerNombre")
    private String primerNombre;
	
	@Column(name = "SegundoNombre")
    private String segundoNombre;
	
	@Column(name = "Nombres")
    private String nombres;

    @Column(name = "Apellido1")
    private String apellido1;

    @Column(name = "Apellido2")
    private String apellido2;

    @Column(name = "Sexo")
    private String sexo;
	
	@Column(name = "ActividadEconomica")
    private Long actividadEconomica;

    @Column(name = "FechaFallecimiento")
    private LocalDate fechaFallecimiento;
	
	@Column(name = "FechaFallecimientoPreRein")
    private LocalDate fechaFallecimientoPreRein;
	
	@Column(name = "DireccionEmail")
    private String direccionEmail;
	
	@Column(name = "Cod_Municipio")
    private String codMunicipio;
	
	@Column(name = "Telefono")
    private long telefono;
	
	@Column(name = "Declarante")
    private long declarante;
	
	@Column(name = "IndicadorNoDeseado")
    private String indicadorNoDeseado;
	
	@Column(name = "Usu_Crea_App")
    private String usu_Crea_App;
	
	@Column(name = "Fec_Creacion")
    private LocalDate fec_Creacion;
	
	@Column(name = "Usu_Mod_App")
    private String usu_Mod_App;
	
	@Column(name = "Fec_Mod_App")
    private LocalDate fec_Mod_App;

    @Column(name = "Payer_Nit")
    private String payerNit;

    // Getters and Setters
    public Long getNumeroIdPensionado() {
        return numeroIdPensionado;
    }
    public void setNumeroIdPensionado(Long numeroIdPensionado) {
        this.numeroIdPensionado = numeroIdPensionado;
    }

    public Long getTipoId() {
        return tipoId;
    }
    public void setTipoId(Long tipoId) {
        this.tipoId = tipoId;
    }
    public String getTipoCliente() {
        return tipoCliente;
    }       
    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }
    public String getPrimerNombre() {
        return primerNombre;
    }
    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }
    public String getSegundoNombre() {
        return segundoNombre;
    }
    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }
    public String getNombres() {
        return nombres;
    }
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    public String getApellido1() {
        return apellido1;
    }   
    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }
    public String getApellido2() {
        return apellido2;
    }
    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public void setPayerNit(String payerNit) {
        this.payerNit = payerNit;
    }

    public String getPayerNit() {
        return payerNit;
    }

}