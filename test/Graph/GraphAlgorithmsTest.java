package Graph;

import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author DEI-ISEP
 */
public class GraphAlgorithmsTest {

	Graph<String, String> completeMap = new Graph<>(false);

	public GraphAlgorithmsTest() {
	}

	@Before
	public void setUp() throws Exception {

		completeMap.insertVertex("Porto");
		completeMap.insertVertex("Braga");
		completeMap.insertVertex("Vila Real");
		completeMap.insertVertex("Aveiro");
		completeMap.insertVertex("Coimbra");
		completeMap.insertVertex("Leiria");

		completeMap.insertVertex("Viseu");
		completeMap.insertVertex("Guarda");
		completeMap.insertVertex("Castelo Branco");
		completeMap.insertVertex("Lisboa");
		completeMap.insertVertex("Faro");

		completeMap.insertEdge("Porto", "Aveiro", "A1", 75);
		completeMap.insertEdge("Porto", "Braga", "A3", 60);
		completeMap.insertEdge("Porto", "Vila Real", "A4", 100);
		completeMap.insertEdge("Viseu", "Guarda", "A25", 75);
		completeMap.insertEdge("Guarda", "Castelo Branco", "A23", 100);
		completeMap.insertEdge("Aveiro", "Coimbra", "A1", 60);
		completeMap.insertEdge("Coimbra", "Lisboa", "A1", 200);
		completeMap.insertEdge("Coimbra", "Leiria", "A34", 80);
		completeMap.insertEdge("Aveiro", "Leiria", "A17", 120);
		completeMap.insertEdge("Leiria", "Lisboa", "A8", 150);

//        incompleteMap = completeMap.clone();
//        completeMap.insertEdge("Aveiro","Viseu","A25",85);
//        completeMap.insertEdge("Leiria","Castelo Branco","A23",170);
//       completeMap.insertEdge("Lisboa","Faro","A2",280);
	}

	@After
	public void tearDown() throws Exception {
	}

	@BeforeClass
	public static void setUpClass() throws Exception {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	/**
	 * Test of BreadthFirstSearch method, of class GraphAlgorithms.
	 */
	@Test
	public void testBreadthFirstSearch() {
		System.out.println("testBreadthFirstSearch");

		assertTrue("Should be null if vertex does not exist", GraphAlgorithms.
				   BreadthFirstSearch(completeMap, "LX") == null);

		Deque<String> path = GraphAlgorithms.
			BreadthFirstSearch(completeMap, "Faro");
		assertTrue("Should be just one", path.size() == 1);

		Iterator<String> it = path.iterator();
		assertTrue("it should be Faro", it.next().compareTo("Faro") == 0);

		path = GraphAlgorithms.BreadthFirstSearch(completeMap, "Porto");
		assertTrue("Should give seven vertices ", path.size() == 7);

		path = GraphAlgorithms.BreadthFirstSearch(completeMap, "Viseu");
		assertTrue("Should give 3 vertices", path.size() == 3);
	}

	/**
	 * Test of DepthFirstSearch method, of class GraphAlgorithms.
	 */
	@Test
	public void testDepthFirstSearch() {
		System.out.println("testDepthFirstSearch");

		Deque<String> path;

		assertTrue("Should be null if vertex does not exist", GraphAlgorithms.
				   DepthFirstSearch(completeMap, "LX") == null);

		path = GraphAlgorithms.DepthFirstSearch(completeMap, "Faro");
		assertTrue("Should be just one", path.size() == 1);

		Iterator<String> it = path.iterator();
		assertTrue("it should be Faro", it.next().compareTo("Faro") == 0);

		path = GraphAlgorithms.DepthFirstSearch(completeMap, "Porto");
		assertTrue("Should give seven vertices ", path.size() == 7);

		path = GraphAlgorithms.DepthFirstSearch(completeMap, "Viseu");
		assertTrue("Should give 3 vertices", path.size() == 3);

		it = path.iterator();
		assertTrue("First in visit should be Viseu", it.next().
				   compareTo("Viseu") == 0);
		assertTrue("then Guarda", it.next().compareTo("Guarda") == 0);
		assertTrue("then Castelo Branco", it.next().compareTo("Castelo Branco") == 0);
	}

	/**
	 * Test of allPaths method, of class GraphAlgorithms.
	 */
	@Test
	public void testAllPaths() {
		System.out.println("testAllPaths");

		int hascode = 0;
		List<Deque<String>> edgePaths = new ArrayList();
		List<Deque<String>> paths = GraphAlgorithms.
			allPaths(this.completeMap, "Porto", "LX", edgePaths);
		for (Deque<String> line : edgePaths) {
			for (String column : line) {
				hascode += column.hashCode();
			}
		}
		assertEquals(hascode, 0);
		assertEquals(edgePaths.size(), paths.size());
		for (int i = 0; i < paths.size(); i++) {
			if (!paths.get(i).isEmpty()) {
				assertEquals(edgePaths.get(i).size(), paths.get(i).size() - 1);
			} else {
				assertEquals(edgePaths.get(i).size(), paths.get(i).size());
			}
		}

		hascode = 0;
		paths = GraphAlgorithms.
			allPaths(completeMap, "Porto", "Lisboa", edgePaths);
		for (Deque<String> line : edgePaths) {
			for (String column : line) {
				hascode += column.hashCode();
			}
		}
		int outher = "A1".hashCode() + "A17".hashCode() + "A8".hashCode();
		outher += "A1".hashCode() + "A17".hashCode() + "A34".hashCode() + "A1".
			hashCode();
		outher += "A1".hashCode() + "A1".hashCode() + "A34".hashCode() + "A8".
			hashCode();
		outher += "A1".hashCode() + "A1".hashCode() + "A1".hashCode();
		assertEquals(hascode, outher);
		assertEquals(edgePaths.size(), paths.size());
		for (int i = 0; i < paths.size(); i++) {
			if (!paths.get(i).isEmpty()) {
				assertEquals(edgePaths.get(i).size(), paths.get(i).size() - 1);
			} else {
				assertEquals(edgePaths.get(i).size(), paths.get(i).size());
			}
		}

		hascode = 0;
		paths = GraphAlgorithms.
			allPaths(completeMap, "Porto", "Faro", edgePaths);
		for (Deque<String> line : edgePaths) {
			for (String column : line) {
				hascode += column.hashCode();
			}
		}
		assertEquals(hascode, 0);
		assertEquals(edgePaths.size(), paths.size());
		for (int i = 0; i < paths.size(); i++) {
			if (!paths.get(i).isEmpty()) {
				assertEquals(edgePaths.get(i).size(), paths.get(i).size() - 1);
			} else {
				assertEquals(edgePaths.get(i).size(), paths.get(i).size());
			}
		}
	}

	/**
	 * Test of shortestPath method, of class GraphAlgorithms. Porto A1 Aveiro A8
	 * Leiria A1 Lisboa A1
	 *
	 * A8
	 *
	 * A8
	 *
	 * A1
	 *
	 * BU
	 */
	@Test
	public void testShortestPath() {
		System.out.println("testShortestPath");

		Deque<String> shortPath = new LinkedList<String>();
		double lenpath = 0;
		lenpath = GraphAlgorithms.
			shortestPath(completeMap, "Porto", "LX", shortPath);
		assertTrue("Length path should be 0 if vertex does not exist", shortPath.
				   size() == 0);

		lenpath = GraphAlgorithms.
			shortestPath(completeMap, "Porto", "Faro", shortPath);
		assertTrue("Length path should be 0 if there is no path", shortPath.
				   size() == 0);

		lenpath = GraphAlgorithms.
			shortestPath(completeMap, "Porto", "Porto", shortPath);
		assertTrue("Length path should be 1 if source and vertex are the same", shortPath.
				   size() == 1);

		lenpath = GraphAlgorithms.
			shortestPath(completeMap, "Porto", "Lisboa", shortPath);
		assertTrue("Path between Porto and Lisboa should be 335 km", lenpath == 335);

		Iterator<String> it = shortPath.iterator();

		assertTrue("First in path should be Porto", it.next().compareTo("Porto") == 0);
		assertTrue("then Aveiro", it.next().compareTo("Aveiro") == 0);
		assertTrue("then Coimbra", it.next().compareTo("Coimbra") == 0);
		assertTrue("then Lisboa", it.next().compareTo("Lisboa") == 0);

		lenpath = GraphAlgorithms.
			shortestPath(completeMap, "Braga", "Leiria", shortPath);
		assertTrue("Path between Braga and Leiria should be 255 km", lenpath == 255);

		it = shortPath.iterator();

		assertTrue("First in path should be Braga", it.next().compareTo("Braga") == 0);
		assertTrue("then Porto", it.next().compareTo("Porto") == 0);
		assertTrue("then Aveiro", it.next().compareTo("Aveiro") == 0);
		assertTrue("then Leiria", it.next().compareTo("Leiria") == 0);

		Edge<String, String> edge = completeMap.
			insertEdge("Aveiro", "Viseu", "A25", 85);

		shortPath.clear();
		lenpath = GraphAlgorithms.
			shortestPath(completeMap, "Porto", "Castelo Branco", shortPath);
		assertTrue("Path between Porto and Castelo Branco should be 335 km", lenpath == 335);
		assertTrue("Path between Porto and Castelo Branco should be 5 cities", shortPath.
				   size() == 5);

		it = shortPath.iterator();

		assertTrue("First in path should be Porto", it.next().compareTo("Porto") == 0);
		assertTrue("then Aveiro", it.next().compareTo("Aveiro") == 0);
		assertTrue("then Viseu", it.next().compareTo("Viseu") == 0);
		assertTrue("then Guarda", it.next().compareTo("Guarda") == 0);
		assertTrue("then Castelo Branco", it.next().compareTo("Castelo Branco") == 0);

		//Changing Edge: Aveiro-Viseu with Edge: Leiria-C.Branco
		//should change shortest path between Porto and Castelo Branco
		completeMap.removeEdge(edge);
		completeMap.insertEdge("Leiria", "Castelo Branco", "A23", 170);
		shortPath.clear();
		lenpath = GraphAlgorithms.
			shortestPath(completeMap, "Porto", "Castelo Branco", shortPath);
		assertTrue("Path between Porto and Castelo Branco should now be 365 km", lenpath == 365);
		assertTrue("Path between Porto and Castelo Branco should be 4 cities", shortPath.
				   size() == 4);

		it = shortPath.iterator();

		assertTrue("First in path should be Porto", it.next().compareTo("Porto") == 0);
		assertTrue("then Aveiro", it.next().compareTo("Aveiro") == 0);
		assertTrue("then Leiria", it.next().compareTo("Leiria") == 0);
		assertTrue("then Castelo Branco", it.next().compareTo("Castelo Branco") == 0);
	}

}
