package cucumber.stepDefinition;

import java.io.File;

import org.apache.commons.lang.StringUtils;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class HookSteps {

	public static BaseSteps steps = null;

	private static final String PROPERTY_PATH_SELENIUM = "selenium.screenshot.dir";
	
	@Before
	public void before() throws Exception {

		if(StringUtils.isEmpty(System.getProperty(PROPERTY_PATH_SELENIUM)))
		{
			String screenshotDir = System.getProperty("user.dir") + File.separator + "target" + File.separator + "selenium-screenshots";
			File file = new File(screenshotDir);
			if(file.exists())
				file.delete();
			file.mkdirs();
			System.setProperty("selenium.screenshot.dir", screenshotDir);
		}
		
		HookSteps.steps = new BaseSteps();

		steps.fromDebug();
		// loadData(new String[] { "FILE", "Massa/XXX.csv" });
		steps.loadUIMapXml("src/main/resources/Locators/LocatorsExemplo.xml");

		if (steps.execution_browser.equals(""))
			steps.loadBrowserFromDefaultConfig();

		if (steps.selenium_endpoint.equals(""))
			steps.loadSeleniumFromDefaultConfig();

		steps.sfRemoteDriver(steps.execution_browser, steps.selenium_endpoint);
		steps.getDriver().manage().window().maximize();
	}

	@After
	public void after() throws Exception {

		HookSteps.steps.sfClose();
	}
}
