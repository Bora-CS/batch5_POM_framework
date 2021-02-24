package regressionTest;

import org.testng.annotations.Test;

import testData.TestingData;
import utilities.SetUpPage;

public class Smoke_NegativeTesting extends SetUpPage {

	@Test
	public void signIn_negativeTesting() {

		header.changeStore(TestingData.ManassasStore);

	}

}
