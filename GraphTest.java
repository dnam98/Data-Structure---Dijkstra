// --== CS400 File Header Information ==--
// Name: Dong Won Nam
// Email: dnam9@wisc.edu
// Team: AD
// TA: Ilay
// Lecturer: Gary Dahl
// Notes to Grader: N/A

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.platform.console.ConsoleLauncher;
import java.lang.invoke.MethodHandles;

/**
 * Tests the implementation of CS400Graph for the individual component of Project Three: the
 * implementation of Dijsktra's Shortest Path algorithm.
 */
public class GraphTest {

  private CS400Graph<String> graph;

  /**
   * Instantiate graph from last week's shortest path activity.
   */
  @BeforeEach
  public void createGraph() {
    graph = new CS400Graph<>();
    // insert vertices A-F
    graph.insertVertex("A");
    graph.insertVertex("B");
    graph.insertVertex("C");
    graph.insertVertex("D");
    graph.insertVertex("E");
    graph.insertVertex("F");
    // insert edges from Week 11. Shortest Path Activity
    graph.insertEdge("A", "B", 6);
    graph.insertEdge("A", "C", 2);
    graph.insertEdge("A", "D", 5);
    graph.insertEdge("B", "E", 1);
    graph.insertEdge("B", "C", 2);
    graph.insertEdge("C", "B", 3);
    graph.insertEdge("C", "F", 1);
    graph.insertEdge("D", "E", 3);
    graph.insertEdge("E", "A", 4);
    graph.insertEdge("F", "A", 1);
    graph.insertEdge("F", "D", 1);
  }

  /**
   * Checks the distance/total weight cost from the vertex A to F.
   */
  @Test
  public void testPathCostAtoF() {
    assertTrue(graph.getPathCost("A", "F") == 3);
  }

  /**
   * Checks the distance/total weight cost from the vertex A to D.
   */
  @Test
  public void testPathCostAtoD() {
    assertTrue(graph.getPathCost("A", "D") == 4);
  }

  /**
   * Checks the ordered sequence of data within vertices from the vertex A to D.
   */
  @Test
  public void testPathAtoD() {
    assertTrue(graph.shortestPath("A", "D").toString().equals("[A, C, F, D]"));
  }

  /**
   * Checks the ordered sequence of data within vertices from the vertex A to F.
   */
  @Test
  public void testPathAtoF() {
    assertTrue(graph.shortestPath("A", "F").toString().equals("[A, C, F]"));
  }

  /**
   * Step 9: Distance from starting node "D" to ending node "B"
   */
  @Test
  public void testPathCostDtoB() {
    assertTrue(graph.getPathCost("D", "B") == 12);
  }

  /**
   * Step 10: Check for sequence of nodes along the path from "D" to "B"
   */
  @Test
  public void testPathDtoB() {
    assertTrue(graph.shortestPath("D", "B").toString().equals("[D, E, A, C, B]"));
  }

  /**
   * Step 11: Check for path cost from "E" to "F"
   */
  @Test
  public void testPastCostEtoF() {
    assertTrue(graph.getPathCost("E", "F") == 7);
  }

  /**
   * Step 12: Check for predecessor to the node "E" along the path from "C" to "E"
   */
  @Test
  public void testPredecessorCtoE() {
    assertTrue(
        graph.shortestPath("C", "E").get(graph.shortestPath("C", "E").size() - 2).equals("B"));
  }
  
  /**
   * Step 13: Check for path sequence from "B" to "A"
   */
  @Test
  public void testPathBtoA() {
    assertTrue(graph.shortestPath("B", "A").toString().equals("[B, C, F, A]"));
  }

  public static void main(String[] args) {
    String className = MethodHandles.lookup().lookupClass().getName();
    String classPath = System.getProperty("java.class.path").replace(" ", "\\ ");
    String[] arguments =
        new String[] {"-cp", classPath, "--include-classname=.*", "--select-class=" + className};
    ConsoleLauncher.main(arguments);
  }

}
