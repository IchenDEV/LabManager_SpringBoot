package com.idevlab.LabMgr.Util;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.NoSuchFileException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Workbook;


import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;

public class Excel {
    public static void exportExcel(List<?> list, String title, String sheetName, Class<?> pojoClass, String fileName,
            boolean isCreateHeader, HttpServletResponse response) throws NoSuchFileException {
        ExportParams exportParams = new ExportParams(title, sheetName);
        exportParams.setCreateHeadRows(isCreateHeader);
        defaultExport(list, pojoClass, fileName, response, exportParams);

    }

    public static void exportExcel(List<?> list, String title, String sheetName, Class<?> pojoClass, String fileName,
            HttpServletResponse response) throws NoSuchFileException {
        defaultExport(list, pojoClass, fileName, response, new ExportParams(title, sheetName,ExcelType.XSSF));
    }

    private static void defaultExport(List<?> list, Class<?> pojoClass, String fileName, HttpServletResponse response,
            ExportParams exportParams) throws NoSuchFileException {
        Workbook workbook = ExcelExportUtil.exportExcel(exportParams, pojoClass, list);
        if (workbook != null);
        downLoadExcel(fileName, response, workbook);
       
    }
    private static void downLoadExcel(String fileName, HttpServletResponse response, Workbook workbook) throws NoSuchFileException {
        try {
            response.setCharacterEncoding("UTF-8");
            response.setHeader("content-Type", "application/vnd.ms-excel");
            response.setHeader("Content-Disposition",
                    "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            throw new NoSuchFileException(e.getMessage());
        }
    }
    // public static <T> List<T> importExcel(String filePath, Integer titleRows, Integer headerRows, Class<T> pojoClass) {
    //     if (StringUtils.isBlank(filePath)) {
    //         return null;
    //     }
    //     ImportParams params = new ImportParams();
    //     params.setTitleRows(titleRows);
    //     params.setHeadRows(headerRows);
    //     List<T> list = null;
    //     try {
    //         list = ExcelImportUtil.importExcel(new File(filePath), pojoClass, params);
    //     } catch (NoSuchElementException e) {
    //         throw new Exception("模板不能为空");
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //         throw new Exception(e.getMessage());
    //     }
    //     return list;
    // }

    // public static <T> List<T> importExcel(MultipartFile file, Integer titleRows, Integer headerRows,
    //         Class<T> pojoClass) throws Exception {
    //     if (file == null) {
    //         return null;
    //     }
    //     ImportParams params = new ImportParams();
    //     params.setTitleRows(titleRows);
    //     params.setHeadRows(headerRows);
    //     List<T> list = null;
    //     try {
    //         list = ExcelImportUtil.importExcel(file.getInputStream(), pojoClass, params);
    //     } catch (NoSuchElementException e) {
    //         throw new Exception("excel文件不能为空");
    //     } catch (Exception e) {
    //         throw new Exception(e.getMessage());
    //     }
    //     return list;
    // }
}