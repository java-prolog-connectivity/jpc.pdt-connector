package org.jpc.pdtconnector;

import static org.jpc.engine.provider.PrologEngineProviderManager.setPrologEngineProvider;

import org.jpc.engine.prolog.PrologEngineTestSuite;
import org.jpc.engine.provider.SimpleEngineProvider;
import org.jpc.examples.PrologExamplesTestSuite;
import org.jpc.util.config.EngineConfigurationManager;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({PrologEngineTestSuite.class, PrologExamplesTestSuite.class})
public class PdtConnectorPrologEngineTestSuite {
	
	@BeforeClass
	public static void setUp() {
		EngineConfigurationManager engineConfigurationManager = EngineConfigurationManager.createFromFile("jpc_pdt.settings");
		EngineConfigurationManager.setDefault(engineConfigurationManager);
		setPrologEngineProvider(new SimpleEngineProvider(EngineConfigurationManager.getDefault().getPrologEngineById("pdt")));
	}
	
}
