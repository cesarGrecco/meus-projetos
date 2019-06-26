package br.com.caelum.livraria.util;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class LogPhaseListener implements PhaseListener {

	@Override
	public void afterPhase(PhaseEvent arg0) {
		
		
	}

	@Override
	public void beforePhase(PhaseEvent arg0) {
		System.out.println("Fase: "+ arg0.getPhaseId());
		
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}

}
