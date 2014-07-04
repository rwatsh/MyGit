package vmware.vcops;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/** Component */
abstract class File {
	private String name;

	File(String name) {
		this.name = name;
	}

	abstract File create(String path, String name);

	abstract void delete(String path, String name);

	abstract String list();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "File [name=" + name + "]";
	}
	
	
}

/**
 * Adapter pattern used for subtypes to override only the methods they need.
 * 
 * @author Watsh
 * 
 */
class FileAdapter extends File {

	FileAdapter(String name) {
		super(name);
	}

	@Override
	File create(String path, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	void delete(String path, String name) {
		// TODO Auto-generated method stub

	}

	@Override
	String list() {
		// TODO Auto-generated method stub
		return null;
	}

}
/** Leaf */
class RegularFile extends FileAdapter {

	RegularFile(String name) {
		super(name);
	}

	@Override
	public File create(String path, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String path, String name) {
		// TODO Auto-generated method stub

	}
}
/** Composite */
class Directory extends FileAdapter {
	Directory(String name) {
		super(name);
	}

	/**
	 * Composite pattern where subclass contains list of super class.
	 */
	List<File> children = new ArrayList<>();

	@Override
	public File create(String path, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String path, String name) {
		// TODO Auto-generated method stub

	}

	/**
	 * A recursive method that prints the directory tree depth first. 
	 */
	@Override
	public String list() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getName()).append("-->");
		for (File child : children) {
			if (child instanceof RegularFile) {
				sb.append(child.getName()).append(" ");
			} else {
				sb.append(child.list());
			}
		}
		return sb.toString();
	}
	/**
	 * Breadth first traversing the file system.
	 * 
	 * @return
	 */
	public String listBfirst() {
		StringBuilder sb = new StringBuilder();
		Queue<File> queue = new LinkedList<File>();
		queue.clear();
		queue.add(this);
		while(!queue.isEmpty()) {
			File f = queue.remove();
			if (f instanceof RegularFile) {
				sb.append(f.getName()).append(" ");
			} else if (f instanceof Directory){
				sb.append(f.getName()).append("-->");
				Directory dir = (Directory)f;
				for (File child : dir.getChildren()) {
					queue.add(child);
				}
			}
			
		}
		return sb.toString();
	}

	public void add(File f) {
		children.add(f);
	}

	public List<File> getChildren() {
		return children;
	}
	
	
}
/** Client */
public class MyFS {
	public static void main(String[] args) {
		RegularFile f1 = new RegularFile("file1");
		Directory d1 = new Directory("d1");
		RegularFile f2 = new RegularFile("file2");
		Directory d2 = new Directory("d2");
		d1.add(f1);
		d2.add(d1);
		d2.add(f2);
		System.out.println(d1.list());
		System.out.println(d2.listBfirst());
	}
}
