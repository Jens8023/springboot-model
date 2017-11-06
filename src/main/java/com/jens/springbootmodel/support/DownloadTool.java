package com.jens.springbootmodel.support;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

/**
 * =========================
 * FileName➤
 * Des☛
 * Date☀ 2017/9/30 || 14:04
 * @author Jens
 * =========================
 */
@Service
public class DownloadTool {
    /**
     * 下载
     * @param wb
     * @param response
     */
    public void downLoadExcel(HSSFWorkbook wb, HttpServletResponse response, String tableName) {
        try {
            response.setHeader("content-disposition", "attachment;filename="
                    + URLEncoder.encode(tableName, "utf-8") + ".xls");
            OutputStream outputStream = response.getOutputStream();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            wb.write(baos);
            byte[] xlsBytes = baos.toByteArray();
            outputStream.write(xlsBytes);
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 列数据信息单元格样式
     * @param workbook
     * @return
     */
    public HSSFCellStyle getStyle(HSSFWorkbook workbook) {
        // 设置字体;
        HSSFFont font = workbook.createFont();
        // 设置字体大小
        font.setFontHeightInPoints((short)10);
        // 字体加粗
        font.setBold(true);
        // 设置字体名字
        font.setFontName("微软雅黑");
        // 设置样式;
        HSSFCellStyle style = workbook.createCellStyle();
        // 在样式用应用设置的字体;
        style.setFont(font);
        // 设置自动换行;
        style.setWrapText(true);
        // 设置对齐的样式为居中对齐;
        // 垂直
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        // 水平
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        //其他

        return style;
    }

}
