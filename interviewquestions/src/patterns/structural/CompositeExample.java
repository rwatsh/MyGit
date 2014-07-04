package patterns.structural;

import java.util.ArrayList;
import java.util.List;

/** Component */
interface Group {
	public void assemble();
}

/** Leaf */
class Block implements Group {

	public void assemble() {
		System.out.println("Block");
	}
}
/** Composite */
class Structure implements Group {
	// Collection of child groups.
	private List<Group> groups = new ArrayList<Group>();

	public void assemble() {
		for (Group group : groups) {
			group.assemble();
		}
	}

	// Adds the group to the structure.
	public void add(Group group) {
		groups.add(group);
	}

	// Removes the group from the structure.
	public void remove(Group group) {
		groups.remove(group);
	}
}

public class CompositeExample {
	public static void main(String[] args) {
        //Initialize three blocks
        Block block1 = new Block();
        Block block2 = new Block();
        Block block3 = new Block();

        //Initialize three structure
        Structure structure = new Structure();
        Structure structure1 = new Structure();
        Structure structure2 = new Structure();

        //Composes the groups
        structure1.add(block1);
        structure1.add(block2);

        structure2.add(block3);

        structure.add(structure1);
        structure.add(structure2);

        structure.assemble();
    }
}
