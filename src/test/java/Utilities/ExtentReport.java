package Utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReport {
	public static String baseDirectory;
	private static ExtentReports extent;

	public static void createReport() {
		File report;
		ExtentHtmlReporter htmlReporter;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd mm:ss");
		Date date = new Date();
		baseDirectory = System.getProperty("user.dir") + "\\Reports\\";
		baseDirectory = baseDirectory
				+ format.format(date).toString().replace(":", "_").replace(" ", "").replace("-", "_");
		try {
			report = new File(baseDirectory);
			report.mkdir();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		htmlReporter = new ExtentHtmlReporter(baseDirectory + "\\Report.html");
		htmlReporter.config().setDocumentTitle("Web Automation");
		htmlReporter.config().setEncoding("utf-8");
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Author", "Masakhane Matanzima");
	}

	public static ExtentTest createTest(String testName) {
		return extent.createTest(testName);
	}

	public static void closeReport() {
		extent.flush();
	}

}
