package org.jpc.engine.pdtconnector;

import java.io.File;
import java.io.IOException;

import org.cs3.prolog.common.Util;
import org.cs3.prolog.pif.PrologInterface;
import org.jpc.engine.prolog.PrologEngine;
import org.jpc.engine.prolog.driver.AbstractPrologEngineDriver;
import org.jpc.util.engine.supported.EngineDescription;
import org.jpc.util.engine.supported.Swi;

public class PdtConnectorDriver extends AbstractPrologEngineDriver {

	public static final String PDT_CONNECTOR_LIBRARY_NAME = "PDT Connector";
	private Swi engineDescription = new Swi();

	@Override
	protected PrologEngine basicCreatePrologEngine() {
		PrologInterface pif = null;
		String executablePath = null;
		String swiBinDirectory = getPreferences().getVar(Swi.SWI_BIN_DIRECTORY_PROPERTY_NAME);
		if(swiBinDirectory != null)
			executablePath = swiBinDirectory + File.separator + engineDescription.getExecutableFileName();
		try {
			if(executablePath != null) {
				pif = Util.newStandalonePrologInterface(executablePath);
			} else {
				pif = Util.newStandalonePrologInterface();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return new PdtConnectorEngine(pif);
	}

	@Override
	public String getLibraryName() {
		return PDT_CONNECTOR_LIBRARY_NAME;
	}

	@Override
	public EngineDescription getEngineDescription() {
		return engineDescription;
	}
	
	@Override
	public String getLicenseUrl() {
		return "http://www.eclipse.org/legal/epl-v10.html";
	}
	
	@Override
	public String getSiteUrl() {
		return "http://sewiki.iai.uni-bonn.de/research/pdt/start";
	}
	
}
