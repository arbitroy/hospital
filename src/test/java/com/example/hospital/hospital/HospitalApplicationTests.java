package com.example.hospital.hospital;



import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class HospitalApplicationTests {
	public static void main(String[] args) {
		try (Playwright playwright = Playwright.create()) {
			Browser browser = playwright.chromium().launch(
					new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));

			BrowserContext context = browser.newContext();
			Page page = context.newPage();

			// Start tracing before creating / navigating a page.
			context.tracing().start(new Tracing.StartOptions()
					.setScreenshots(true)
					.setSnapshots(true)
					.setSources(true));

			// Open localhost app
			page.navigate("http://localhost:8082/");
			page.waitForLoadState();

			// Stop tracing and export it into a zip archive.
			context.tracing().stop(new Tracing.StopOptions()
					.setPath(Paths.get("trace.zip")));

			System.out.println("Page loaded: " + page.title());

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

			// Click on the "Patients" link or button
			page.click("text=Patients");
			System.out.println("Clicked on 'Patients'");

			// Optional wait to keep the browser open a bit before closing
			page.waitForTimeout(30000);

			browser.close();
		}
	}
}
