package org.jpc.engine.pdtconnector;

import org.cs3.prolog.cterm.CTerm;
import org.jpc.salt.JpcTermWriter;
import org.jpc.salt.pdtconnector.PdtConnectorTermReader;
import org.jpc.term.Term;

public class PdtConnectorBridge {

//	public static CTerm fromJpcToPdtConnector(Term term) {
//		PdtConnectorTermWriter pdtConnectorTermWriter = new PdtConnectorTermWriter();
//		term.read(pdtConnectorTermWriter);
//		return pdtConnectorTermWriter.getFirst();
//	} 
	
	public static Term fromPdtConnectorToJpc(CTerm term) {
		JpcTermWriter jpcTermWriter = new JpcTermWriter();
		new PdtConnectorTermReader(term, jpcTermWriter).read();
		return jpcTermWriter.getFirst();
	} 
	
}
