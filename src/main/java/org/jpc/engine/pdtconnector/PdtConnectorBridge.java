package org.jpc.engine.pdtconnector;

import org.cs3.prolog.cterm.CTerm;
import org.jpc.util.salt.JpcTermStreamer;
import org.jpc.util.salt.pdtconnector.PdtConnectorTermReader;
import org.jpc.term.Term;

public class PdtConnectorBridge {

//	public static CTerm fromJpcToPdtConnector(Term term) {
//		PdtConnectorTermWriter pdtConnectorTermWriter = new PdtConnectorTermWriter();
//		term.read(pdtConnectorTermWriter);
//		return pdtConnectorTermWriter.getFirst();
//	} 
	
	public static Term fromPdtConnectorToJpc(CTerm term) {
		JpcTermStreamer jpcTermWriter = new JpcTermStreamer();
		new PdtConnectorTermReader(term, jpcTermWriter).read();
		return jpcTermWriter.getFirst();
	} 
	
}
