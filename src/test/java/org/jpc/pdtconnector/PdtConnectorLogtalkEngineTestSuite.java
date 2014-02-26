package org.jpc.pdtconnector;

import static org.jpc.engine.provider.PrologEngineProviderManager.setPrologEngineProvider;

import org.jpc.engine.logtalk.LogtalkEngineTestSuite;
import org.jpc.engine.provider.SimpleEngineProvider;
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
		setPrologEngineProvider(new SimpleEngineProvider(EngineConfigurationManager.getDefault().getNamedPrologEngine("pdt_logtalk")));
	}
}
