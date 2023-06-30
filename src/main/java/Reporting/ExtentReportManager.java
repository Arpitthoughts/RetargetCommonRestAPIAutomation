package Reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ExtentReportManager {
public static ExtentReports extentReports;
    public static ExtentReports createExtentReportInstance(String filePath, String reportName, String documentTitle){

        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(new File(filePath+"/"+getReportName()));
        extentSparkReporter.config().setReportName(reportName);
        extentSparkReporter.config().setDocumentTitle(documentTitle);
        extentSparkReporter.config().setTheme(Theme.DARK);
        extentSparkReporter.config().setEncoding("utf-8");

        extentReports= new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);

        return extentReports;
    }

    public static String getReportName(){
        DateTimeFormatter dateTimeFormatter= DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
        LocalDateTime localDateTime=LocalDateTime.now();
        String formattedTime=dateTimeFormatter.format(localDateTime);
        String reportName = "APIAutomationTestReport"+ formattedTime+".html";
        return reportName;
    }

    public static void logPassDetails(String log){
    Setup.extentTestThreadLocal.get().pass(MarkupHelper.createLabel(log, ExtentColor.GREEN));
    }
    public static void logFailDetails(String log){
        Setup.extentTestThreadLocal.get().fail(MarkupHelper.createLabel(log, ExtentColor.RED));
    }
    public static void logInfoDetails(String log){
        Setup.extentTestThreadLocal.get().info(MarkupHelper.createLabel(log, ExtentColor.GREY));
    }
    public static void logWarningDetails(String log){
        Setup.extentTestThreadLocal.get().info(MarkupHelper.createLabel(log, ExtentColor.YELLOW));
    }

    public static void logJson(String json){
    Setup.extentTestThreadLocal.get().info(MarkupHelper.createCodeBlock(json, CodeLanguage.JSON));

    }
}
