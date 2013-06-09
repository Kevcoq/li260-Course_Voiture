package li260.MVC.event.sender;

import li260.MVC.event.listener.UpdateEventListener;

public interface UpdateEventSender {
	public void add(UpdateEventListener listener);

	public void update();
}
