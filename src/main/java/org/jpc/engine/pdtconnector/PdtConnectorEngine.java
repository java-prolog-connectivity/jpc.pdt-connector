package org.jpc.engine.pdtconnector;

import static org.jpc.engine.prolog.ThreadModel.MULTI_THREADED;

import org.cs3.prolog.cterm.CTerm;
import org.cs3.prolog.cterm.CTermUtil;
import org.cs3.prolog.pif.PrologInterface;
import org.cs3.prolog.pif.PrologInterfaceException;
import org.jpc.Jpc;
import org.jpc.engine.prolog.AbstractPrologEngine;
import org.jpc.engine.prolog.ThreadModel;
import org.jpc.error.PrologParsingException;
import org.jpc.query.Query;
import org.jpc.term.Term;

public class PdtConnectorEngine extends AbstractPrologEngine {

	private PrologInterface wrappedEngine; 
	
	PdtConnectorEngine(PrologInterface wrappedEngine) {
		this.wrappedEngine = wrappedEngine;
	}
	
	public PrologInterface getWrappedEngine() {
		return wrappedEngine;
	}
	
	@Override
	public void close() {
		try {
			wrappedEngine.stop();
		} catch (PrologInterfaceException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean isCloseable() {
		return true;
	}
	
	@Override
	public ThreadModel threadModel() {
		return MULTI_THREADED;
	}

	@Override
	public Term asTerm(String termString, Jpc context) { //TODO delete context here
		try {
			CTerm pdtTerm = CTermUtil.parseNonCanonicalTerm(termString, wrappedEngine);
			return PdtConnectorBridge.fromPdtConnectorToJpc(pdtTerm);
		} catch(Exception e) {
			throw new PrologParsingException(termString, e);
		}
	}

	@Override
	public Query basicQuery(Term goal, boolean errorHandledQuery, Jpc context) {
		return new PdtConnectorQuery(this, goal, errorHandledQuery, context);
	}

}
