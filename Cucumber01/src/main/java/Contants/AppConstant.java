package Contants;

public class AppConstant {

	private AppConstant() {
		throw new IllegalStateException("AppConstant class");
	}

	private static final String User_Directory = System.getProperty("user.dir");
	private static final String ChromePath = System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe";
	private static final String MicrosoftEdge = System.getProperty("user.dir") + "\\Drivers\\msedgedriver.exe";
	private static final String Firefoxpath = System.getProperty("user.dir") + "\\Drivers\\geckodriver.exe.";
	private static final String ExcelTestDataPath = System.getProperty("user.dir") + "\\TestData\\TestDataFile.xlsx";
	private static final String PropertiesFilePath = System.getProperty("user.dir") + "\\application.properties";

	public static String getPropfilepath() {
		return PropertiesFilePath;
	}

	public static String getUserDirectory() {
		return User_Directory;
	}

	public static String getChromePath() {
		return ChromePath;
	}

	public static String getfirefoxPath() {
		return Firefoxpath;
	}

	public static String getedgePath() {
		return MicrosoftEdge;
	}

	public static String getexcelTestDataPath() {
		return ExcelTestDataPath;
	}

}
