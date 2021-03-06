package org.qooxdoo.demo.mobileshowcase;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.oneandone.qxwebdriver.By;
import org.oneandone.qxwebdriver.ui.Touchable;
import org.openqa.selenium.Dimension;

public class Drawer extends Mobileshowcase {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Mobileshowcase.setUpBeforeClass();
		selectItem("Drawer");
		verifyTitle("Drawer");
	}
	
	@Test
	public void drawer() throws InterruptedException {
		String[] drawers = {"top", "right", "bottom", "left"};
		for (String drawer : drawers) {
			Touchable drawerButton = (Touchable) driver.findWidget(By.xpath("//div[text() = 'Open " + drawer + " drawer']/ancestor::div[contains(@class, 'button')]"));
			drawerButton.tap();
			Thread.sleep(500);
			Touchable closeButton = (Touchable) driver.findWidget(By.xpath("//label[text() = 'This is the " + drawer + " drawer.']/parent::div/div[contains(@class, 'button')]"));
			closeButton.tap();
			Thread.sleep(1000);
			Dimension size = closeButton.getSize();
			Assert.assertEquals(0, size.getWidth());
			Assert.assertEquals(0, size.getHeight());
		}
	}
}
