package com.davivienda.pensionados.controller;


import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.davivienda.pensionados.dto.MenuResponse;
//GG Role AMP_Des_Admin
//GG Role AMP_Des_Analista
//GG Role AMP_Des_Reintegros
//GG Role AMP_Des_Autorizacion
//GG Role AMP_Des_GestionPerfiles
@RestController
public class MenuController {

    @GetMapping("/api/menu")
    public MenuResponse getMenu(Authentication authentication) {
        Set<String> roles = new HashSet<>();
        for (GrantedAuthority authority : authentication.getAuthorities()) {
            roles.add(authority.getAuthority());
        }

        // Map roles to menu
        if (roles.contains("ROLE_AMP_Prod_Admin")) {
            return new MenuResponse("AMP_Prod_Admin", getAdminMenu());
        } else if (roles.contains("ROLE_AMP_Prod_Analista")) {
            return new MenuResponse("AMP_Prod_Analista", getAnalystMenu());
        } else if (roles.contains("ROLE_AMP_Prod_Reintegros")) {
            return new MenuResponse("AMP_Prod_Reintegros", getReintegrosMenu());
        } else if (roles.contains("ROLE_AMP_Prod_Autorizacion")) {
            return new MenuResponse("AMP_Prod_Autorizacion", getAutorizacionMenu());
        } else if (roles.contains("ROLE_AMP_Prod_GestionPerfiles")) {
            return new MenuResponse("AMP_Prod_GestionPerfiles", getGestionPerfilesMenu());
        } else {
            // No profile assigned
            return new MenuResponse("No Profile", Collections.emptyMap());
        }
    }

    private Map<String, List<String>> getAdminMenu() {
        Map<String, List<String>> menu = new LinkedHashMap<>();
        menu.put("Affiliations", Arrays.asList("Check membership numbers", "Add and Modify Bulk Affiliations"));
        menu.put("Refunds", Arrays.asList("Colpensiones Reimbursement Request", "Request for Reimbursements of Other Funds", "Approval of Reimbursements Other Funds"));
        menu.put("Reports", Arrays.asList(
                "Report on the Opening of Pensioner Accounts",
                "Inactive Accounts Report",
                "Report on Pension Allowance Payments",
                "Report on Pension allowance payment refusals",
                "Successful Withdrawals Report",
                "Report of Rejected Withdrawals",
                "Custom reports",
                "Reimbursement Tracking Report",
                "Successful Withdrawals File"
        ));
        menu.put("Consult Logs", Arrays.asList("Process log", "Transactional log", "Security log"));
        menu.put("See File Upload", Collections.singletonList("See File Upload"));
        menu.put("System Parameterization", Arrays.asList("Pension fund parameterization", "Modifying Parameters"));
        return menu;
    }

    private Map<String, List<String>> getAnalystMenu() {
        Map<String, List<String>> menu = new LinkedHashMap<>();
        menu.put("Affiliations", Arrays.asList("Check membership numbers", "Add and Modify Bulk Affiliations"));
        menu.put("Reports", Arrays.asList(
                "Report on the Opening of Pensioner Accounts",
                "Inactive Accounts Report",
                "Custom reports",
                "Reimbursement Tracking Report",
                "Successful Withdrawals File"
        ));
        return menu;
    }

    private Map<String, List<String>> getReintegrosMenu() {
        Map<String, List<String>> menu = new LinkedHashMap<>();
        menu.put("Refunds", Arrays.asList("Colpensiones Reimbursement Request", "Request for Reimbursements of Other Funds"));
        menu.put("Reports", Arrays.asList(
                "Report on Pension Allowance Payments",
                "Report of Rejected Withdrawals",
                "Successful Withdrawals Report",
                "Report on Pension allowance payment refusals",
                "Custom reports",
                "Reimbursement Tracking Report",
                "Successful Withdrawals File"
        ));
        return menu;
    }

    private Map<String, List<String>> getAutorizacionMenu() {
        Map<String, List<String>> menu = new LinkedHashMap<>();
        menu.put("Affiliations", Arrays.asList("Check membership numbers", "Add and Modify Bulk Affiliations"));
        menu.put("Refunds", Arrays.asList("Approval of Reimbursements Other Funds"));
        menu.put("Consult Logs", Arrays.asList("Process log", "Transactional log", "Security log"));
        menu.put("See File Upload", Collections.singletonList("See File Upload"));
        menu.put("Reports", Arrays.asList(
                "Report on the Opening of Pensioner Accounts",
                "Inactive Accounts Report",
                "Report on Pension Allowance Payments",
                "Report on Pension allowance payment refusals",
                "Successful Withdrawals Report",
                "Report of Rejected Withdrawals",
                "Custom reports",
                "Reimbursement Tracking Report",
                "Successful Withdrawals File"
        ));
        return menu;
    }

    private Map<String, List<String>> getGestionPerfilesMenu() {
        Map<String, List<String>> menu = new LinkedHashMap<>();
        menu.put("Profile Management", Collections.singletonList("View user profile"));
        menu.put("Consult Logs", Collections.singletonList("Security log"));
        return menu;
    }
}