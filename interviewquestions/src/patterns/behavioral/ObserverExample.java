package patterns.behavioral;

import java.util.ArrayList;
import java.util.List;

/*
 * Same as Observable.
 */
interface Subject {

	public void registerObserver(Observer observer);

	public void notifyObserver();

	public void unRegisterObserver(Observer observer);

	public Object getUpdate();

}

class Blog implements Subject {

	List<Observer> observersList;
	private boolean stateChange;

	public Blog() {
		this.observersList = new ArrayList<Observer>();
		stateChange = false;
	}

	public void registerObserver(Observer observer) {
		observersList.add(observer);
	}

	public void unRegisterObserver(Observer observer) {
		observersList.remove(observer);
	}

	public void notifyObserver() {

		if (stateChange) {
			for (Observer observer : observersList) {
				observer.update();
			}
		}
	}

	public Object getUpdate() {
		Object changedState = null;
		// should have logic to send the
		// state change to querying observer
		if (stateChange) {
			changedState = "Observer Design Pattern";
		}
		return changedState;
	}

	public void postNewArticle() {
		stateChange = true;
		notifyObserver();
	}

}

interface Observer {

	public void update();

	public void setSubject(Subject subject);
}

class User implements Observer {

	private String article;
	private Subject blog;

	public void setSubject(Subject blog) {
		this.blog = blog;
		article = "No New Article!";
	}

	@Override
	public void update() {
		System.out.println("State change reported by Subject.");
		article = (String) blog.getUpdate();
	}

	public String getArticle() {
		return article;
	}
}

public class ObserverExample {
	public static void main(String args[]) {
		Blog blog = new Blog();
		User user1 = new User();
		User user2 = new User();
		blog.registerObserver(user1);
		blog.registerObserver(user2);
		user1.setSubject(blog);
		user2.setSubject(blog);

		System.out.println(user1.getArticle());
		blog.postNewArticle();
		System.out.println(user1.getArticle());
	}
}
