package bfs;
import java.util.*;


public class CourseSchedule {
  public int[] findOrder(int numCourses, int[][] prerequisites) {
    
    // index: course node, val: indegree
    int[] inDegree = new int[numCourses];
    Map<Integer, List<Integer>> graph = new HashMap<>();
    buildGraph(graph, inDegree, prerequisites, numCourses);
    List<Integer> courseList = getOrder(graph, inDegree);
    if (courseList.size() != numCourses) {
      return new int[0];
    }

    int[] res = new int[courseList.size()];
    for (int i = 0; i < res.length; i++) {
      res[i] = courseList.get(i);
    }
    return res;
  }

  private void buildGraph(Map<Integer, List<Integer>> graph, int[] inDegree, int[][] prerequisites, int numCourses) {
    for (int i = 0; i < numCourses; i++) {
      graph.put(i, new ArrayList<Integer>());
    }

    for (int[] preReq : prerequisites) {
      int course = preReq[0];
      int reqCourse = preReq[1];

      inDegree[course]++;
      graph.get(reqCourse).add(course);
    }
  }

  private List<Integer> getOrder(Map<Integer, List<Integer>> graph, int[] inDegree) {
    List<Integer> res = new ArrayList<>();
    Queue<Integer> queue = new ArrayDeque<>();

    for (int course : graph.keySet()) {
      if (inDegree[course] == 0) {
        queue.offer(course);
      }
    }

    while (!queue.isEmpty()) {
      int curCourse = queue.poll();
      res.add(curCourse);

      for (int reqCourse : graph.get(curCourse)) {
        inDegree[reqCourse]--;
        if (inDegree[reqCourse] == 0) {
          queue.offer(reqCourse);
        }
      }
    }

    return res;
  }

  public static void main(String[] args) {
    // int[][] courses = {{1,0},{2,0},{3,1},{3,2}};
    int[][] courses = {{1,0}};
    CourseSchedule sol = new CourseSchedule();
    System.out.println(sol.findOrder(2, courses));
  }
}
