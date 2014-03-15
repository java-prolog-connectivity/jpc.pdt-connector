package org.jpc.pdtconnector;

import org.jpc.engine.logtalk.LogtalkEngineTestSuite;
import org.jpc.examples.LogtalkExamplesTestSuite;
import org.jpc.util.config.EngineConfigurationManager;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({LogtalkEngineTestSuite.class, LogtalkExamplesTestSuite.class})
public class PdtConnectorLogtalkEngineTestSuite {
	@BeforeClass
	public static void setUp() {
		EngineConfigurationManager engineConfigurationManager = EngineConfigurationManager.createFromFile("jpc_pdt_logtalk.settings");
		EngineConfigurationManager.setDefault(engineConfigurationManager);
	}
}
