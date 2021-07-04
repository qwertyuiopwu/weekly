package com.formssi.weekReportTool.system.excelTool;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;

import com.formssi.weekReportTool.weeklyInfo.damain.PersonWeekly;
import com.formssi.weekReportTool.weeklyInfo.damain.WeeklyInfoBean;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import cn.hutool.poi.excel.StyleSet;

public class HuToolExcelUtil {
	public static void downLoadFile(HttpServletResponse response,List<PersonWeekly> list,String fileName) {
		// 通过工具类创建writer，默认创建xls格式
		ExcelWriter writer = ExcelUtil.getWriter();
		// 给列设置别名
		writer.addHeaderAlias("projCode", "项目编号");
		writer.addHeaderAlias("projName", "项目名称");
		writer.addHeaderAlias("idNo", "员工id");
		writer.addHeaderAlias("prosonName", "姓名");
		writer.addHeaderAlias("taskDate", "日期");
		writer.addHeaderAlias("proManager", "分类标识");
		writer.addHeaderAlias("normalHour", "正常时间");
		writer.addHeaderAlias("overtimeHour", "加班时间");
		// 设置标题样式
		StyleSet style = writer.getStyleSet();
		CellStyle headCellStyle = style.getHeadCellStyle();
		// 水平居中
		headCellStyle.setAlignment(HorizontalAlignment.CENTER);
		// 垂直居中
		headCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
		// 设置内容字体
		Font font = writer.createFont();
		// 加粗
		font.setBold(true);
		// 设置标题字体大小
		font.setFontHeightInPoints((short) 12);
		headCellStyle.setFont(font);
		// 设置每列宽度，-1为全部列
		writer.setColumnWidth(-1, 15);
		// 设置行的默认高度
		writer.setDefaultRowHeight(20);

		writer.write(list, true);

		// out为OutputStream，需要写出到的目标流
		ServletOutputStream out = null;
		try {
			// response为HttpServletResponse对象
			response.setContentType("application/vnd.ms-excel;charset=utf-8");
			// 设置Http响应头告诉浏览器下载这个附件
			response.setHeader("Content-Disposition", "attachment;Filename="
					+ URLEncoder.encode(fileName, "UTF-8") + ".xls");
			response.setHeader("Content-Transfer-Encoding", "binary");
			out = response.getOutputStream();
			System.out.println(out.toString());
			writer.flush(out, true);
			System.out.println("导出成功");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 关闭writer，释放内存
			writer.close();
		}
		// 此处记得关闭输出Servlet流
		IoUtil.close(out);
	}
}
