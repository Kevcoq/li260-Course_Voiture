package li260.mains.tools;

import java.awt.image.BufferedImage;

import li260.MVC.event.listener.GereObserveur;
import li260.MVC.event.listener.UpdateEventListener;

public class IHM implements UpdateEventListener {
	private GereObserveur obs = null;

	public IHM(BufferedImage im) {
		super();
		obs = new GereObserveur(im);
	}

	public GereObserveur getObs() {
		return obs;
	}

	@Override
	public void manageUpdate() {
		// TODO Auto-generated method stub
		if (obs != null)
			obs.manageUpdate();
	}

	public void reset() {
		if(obs==null)
			return;
		obs.reset();
	}

	
	public void setObs(GereObserveur obs) {
		this.obs = obs;
	}
}
