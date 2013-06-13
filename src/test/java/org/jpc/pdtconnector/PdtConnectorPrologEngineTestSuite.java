package org.jpc.pdtconnector;

import static org.jpc.engine.provider.PrologEngineProviderManager.setPrologEngineProvider;

import org.jpc.PrologEngineTestSuite;
import org.jpc.engine.pdtconnector.PdtConnectorDriver;
import org.jpc.engine.prolog.driver.AbstractPrologEngineDriver;
import org.jpc.engine.provider.SimpleEngineProvider;
import org.jpc.examples.PrologExamplesTestSuite;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({PrologEngineTestSuite.class, PrologExamplesTestSuite.class})
public class PdtConnectorPrologEngineTestSuite {
	
	@BeforeClass
	public static void setUp() {
		AbstractPrologEngineDriver prologEngineConfiguration = new PdtConnectorDriver();
		setPrologEngineProvider(new SimpleEngineProvider(prologEngineConfiguration.createPrologEngine()));
	}
	
}
