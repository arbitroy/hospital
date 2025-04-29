package com.example.hospital.hospital;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

import java.nio.file.Paths;

// adding order to the test cases
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class HospitalApplicationTests {

	private static Playwright playwright;
	private static Browser browser;
	private static BrowserContext context;
	private static Page page;

	@BeforeAll
	public static void setup() {
		playwright = Playwright.create();
		browser = playwright.chromium().launch(
				new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
		context = browser.newContext();
		page = context.newPage();

		// Start tracing before creating / navigating a page.
		context.tracing().start(new Tracing.StartOptions()
				.setScreenshots(true)
				.setSnapshots(true)
				.setSources(true));

		// Open localhost app
		page.navigate("http://localhost:8082/");
		page.waitForLoadState();

		System.out.println("Page loaded: " + page.title());
	}

	@Test
	@Order(2)
	public void testAddDoctor() {
		// Click on the "Doctor" link or button
		page.click("text=Doctor");
		System.out.println("Clicked on 'Doctor'");

		page.click("text=Add New Doctor");
		System.out.println("Clicked on 'Add New Doctor'");

		page.fill("input[name='name']", "Dr. Tito Mito");
		page.fill("input[name='specialization']", "Cardiology");

		page.click("button:has-text(\"Create Doctor\")");
		System.out.println("Clicked 'Create Doctor' button");

		// Optional wait time to observe navigation or animations
		page.waitForTimeout(2000);

		// Verify doctor was added (you might add assertions here)
		//Assertions.assertTrue(page.isVisible("text=Dr. Tito Mito"));
	}

	@Test
	@Order(3)
	public void testDeleteDoctor() {
		// First navigate to doctor page
		page.click("text=Doctor");
		System.out.println("Clicked on 'Doctor'");

		// Wait for the doctor list to load
		page.waitForSelector("text=Dr. Tito Mito");

		// Find and click the delete button for our doctor
		// Assuming there's a delete button near the doctor name
		page.click("text=Delete");
		System.out.println("Clicked 'Delete' button for Dr. Tito Mito");

		// Confirm deletion if there's a confirmation dialog
		//page.click("button:has-text('Confirm')");

		// Wait for the deletion to process
		page.waitForTimeout(2000);

		// Verify doctor was removed
		//Assertions.assertTrue(page.isVisible("text=Dr. Tito Mito"));
	}

	@Test
	@Order(1)
	public void testNavigateToPatients() {
		// Click on the "Patients" link or button
		page.click("text=Patients");
		System.out.println("Clicked on 'Patients'");
		page.goBack();

		// Verify we're on the patients page
		//Assertions.assertTrue(page.isVisible("text=Patients List"));
	}

	@AfterAll
	public static void teardown() {
		// Stop tracing and export it into a zip archive.
		context.tracing().stop(new Tracing.StopOptions()
				.setPath(Paths.get("trace.zip")));

		// Close the browser
		browser.close();
		playwright.close();
		System.out.println("Test completed - browser closed");
	}
}