package org.jpc.pdtconnector;

import static org.jpc.engine.provider.PrologEngineProviderManager.setPrologEngineProvider;

import org.jpc.LogtalkEngineTestSuite;
import org.jpc.engine.pdtconnector.PdtConnectorDriver;
import org.jpc.engine.profile.LogtalkEngineProfile;
import org.jpc.engine.prolog.driver.AbstractPrologEngineDriver;
import org.jpc.engine.provider.SimpleEngineProvider;
import org.jpc.examples.LogtalkExamplesTestSuite;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({LogtalkEngineTestSuite.class, LogtalkExamplesTestSuite.class})
public class PdtConnectorLogtalkEngineTestSuite {
	@BeforeClass
	public static void setUp() {
		AbstractPrologEngineDriver prologEngineConfiguration = new PdtConnectorDriver();
		setPrologEngineProvider(new SimpleEngineProvider(new LogtalkEngineProfile(prologEngineConfiguration).createPrologEngine()));
	}
}
