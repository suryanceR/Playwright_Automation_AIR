package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {

        if(extent == null) {

            ExtentSparkReporter spark =
                    new ExtentSparkReporter(
                            "target/ExtentReport.html");

            spark.config().setReportName(
        "AIR Hybrid Playwright Automation Dashboard");

            spark.config().setDocumentTitle(
        "AIR Hybrid Framework Report");

            spark.config().setTheme(
                    Theme.DARK);

            extent = new ExtentReports();

            extent.attachReporter(spark);

            // ===== Framework Information =====

            extent.setSystemInfo(
                    "Framework",
                    "Playwright Hybrid Framework");

            extent.setSystemInfo(
                    "BDD Framework",
                    "Cucumber");

            extent.setSystemInfo(
                    "Language",
                    "Java");

            extent.setSystemInfo(
                    "Build Tool",
                    "Maven");

            extent.setSystemInfo(
                    "Reporting",
                    "Extent Reports");

            extent.setSystemInfo(
                    "Environment",
                    "QA");

            extent.setSystemInfo(
                    "Execution",
                    "Local");

            extent.setSystemInfo(
                    "Author",
                    "Suryance Raj");
        }

        return extent;
    }
}