package patterns.behavioral;

import java.util.ArrayList;
import java.util.List;

interface ConsumerElectronics {
	public abstract void on();

	public abstract void mute();
}

class Television implements ConsumerElectronics {

	public void on() {
		System.out.println("Television is on!");
	}

	@Override
	public void mute() {
		System.out.println("Television is muted!");

	}
}

class SoundSystem implements ConsumerElectronics {

	public void on() {
		System.out.println("Sound system is on!");
	}

	@Override
	public void mute() {
		System.out.println("Sound system is muted!");

	}
}

interface Command {

	public abstract void execute();

}

class OnCommand implements Command {

	private ConsumerElectronics ce;

	public OnCommand(ConsumerElectronics ce) {
		this.ce = ce;
	}

	public void execute() {
		ce.on();
	}
}

class MuteAllCommand implements Command {
	List<ConsumerElectronics> ceList;

	public MuteAllCommand(List<ConsumerElectronics> ceList) {
		this.ceList = ceList;
	}

	@Override
	public void execute() {

		for (ConsumerElectronics ce : ceList) {
			ce.mute();
		}

	}
}

class Button {
	Command c;

	public Button(Command c) {
		this.c = c;
	}

	public void click() {
		c.execute();
	}
}

class UniversalRemote {

	public static ConsumerElectronics getActiveDevice() {
		// here we will have a complex electronic circuit :-)
		// that will maintain current device
		Television tv = new Television();
		return tv;
	}
}

public class CommandExample {
	public static void main(String args[]) {

		// OnCommand is instantiated based on active device supplied by Remote
		ConsumerElectronics ce = UniversalRemote.getActiveDevice();
		OnCommand onCommand = new OnCommand(ce);
		Button onButton = new Button(onCommand);
		onButton.click();

		Television tv = new Television();
		SoundSystem ss = new SoundSystem();
		List<ConsumerElectronics> all = new ArrayList<ConsumerElectronics>();
		all.add(tv);
		all.add(ss);
		MuteAllCommand muteAll = new MuteAllCommand(all);
		Button muteAllButton = new Button(muteAll);
		muteAllButton.click();
	}
}
