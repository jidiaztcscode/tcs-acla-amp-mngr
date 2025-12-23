package com.davivienda.pensionados.utils;


import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.davivienda.pensionados.model.Menu;
import com.davivienda.pensionados.model.Profile;

public class ExcelExporter {
    public static byte[] exportProfiles(List<Profile> profiles) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Profiles");
            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("Name");
            header.createCell(1).setCellValue("Description");
            header.createCell(2).setCellValue("Menus/Submenus");
            header.createCell(3).setCellValue("Active");

            int rowIdx = 1;
            for (Profile p : profiles) {
                Row row = sheet.createRow(rowIdx++);
                row.createCell(0).setCellValue(p.getName());
                row.createCell(1).setCellValue(p.getDescription());
                String menus = p.getMenus().stream()
                        .map(menu -> menu.getName() +
                                (menu.getSubMenus() != null && !menu.getSubMenus().isEmpty()
                                        ? " (" + menu.getSubMenus().stream().map(Menu::getName).collect(Collectors.joining(", ")) + ")"
                                        : ""))
                        .collect(Collectors.joining("; "));
                row.createCell(2).setCellValue(menus);
                row.createCell(3).setCellValue(p.isActive() ? "Active" : "Inactive");
            }
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            workbook.write(out);
            return out.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException("Failed to export Excel", e);
        }
    }
}