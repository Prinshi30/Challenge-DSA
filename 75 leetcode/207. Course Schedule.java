class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        // Step 1: Build a graph representation of courses and their prerequisites.
        // courseGraph maps each course to a list of courses that depend on it.
        HashMap<Integer, List<Integer>> courseGraph = new HashMap<>();
        
        // Populate the graph based on the prerequisites list
        for (int[] pre : prerequisites) {
            // pre[1] is a course that needs to be completed before pre[0]
            if (courseGraph.containsKey(pre[1])) {
                // If courseGraph already contains the prerequisite course, add this course to its list
                courseGraph.get(pre[1]).add(pre[0]);
            } else {
                // Otherwise, create a new entry with pre[1] as the key and pre[0] as the first dependent course
                List<Integer> nextCourses = new LinkedList<>();
                nextCourses.add(pre[0]);
                courseGraph.put(pre[1], nextCourses);
            }
        }
        
        // Step 2: Track visited nodes to detect cycles during DFS traversal
        HashSet<Integer> visited = new HashSet<>();
        
        // Step 3: Check if each course can be completed without a cycle
        for (int currentCourse = 0; currentCourse < numCourses; currentCourse++) {
            // If there's a cycle detected starting from currentCourse, return false
            if (!courseSchedule(currentCourse, visited, courseGraph)) {
                return false;
            }
        }
        
        // If no cycles were found, it's possible to finish all courses
        return true;
    }
    
    // Helper function to perform DFS and detect cycles in the graph
    public boolean courseSchedule(int course, HashSet<Integer> visited, 
                                  HashMap<Integer, List<Integer>> courseGraph) {
        // If the course is already in the visited set, a cycle is detected
        if (visited.contains(course)) {
            return false;
        }
        
        // If there are no prerequisites for this course, it's safe to finish it
        if (courseGraph.get(course) == null) {
            return true;
        }
        
        // Mark the current course as visited
        visited.add(course);
        
        // Visit all courses that depend on the current course
        for (int pre : courseGraph.get(course)) {
            // If visiting any of the prerequisites returns false, a cycle was found
            if (!courseSchedule(pre, visited, courseGraph)) {
                return false;
            }
        }
        
        // Remove the course from visited set after DFS to allow other paths to be checked independently
        visited.remove(course);
        
        // Mark the course as "completed" by setting its prerequisite list to null
        courseGraph.put(course, null);
        
        return true;
    }
}

/* another way */
/* class Solution {
    // Boolean flag to keep track if a cycle is detected
    boolean cycle = false;
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Step 1: Build an adjacency list for the graph representation of courses and prerequisites
        ArrayList<Integer> graph[] = new ArrayList[numCourses];
        
        // Initialize the adjacency list where each course points to an empty list initially
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // Populate the adjacency list with the prerequisites
        // Each entry prerequisites[i][0] depends on prerequisites[i][1]
        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        
        // Step 2: Initialize arrays to keep track of visited nodes and nodes in the recursion stack
        int visited[] = new int[numCourses];
        int recStack[] = new int[numCourses];
        
        // Step 3: Check each course to detect any cycle in the dependencies
        for (int i = 0; i < numCourses; i++) {
            // If the course has not been visited yet, start a DFS from it
            if (visited[i] == 0) {
                detectCycle(graph, visited, recStack, i);
            }
            // If a cycle is detected, return false as it's not possible to complete all courses
            if (cycle) return false;
        }
        
        // If no cycles were found, it's possible to complete all courses
        return true;
    }

    // Helper method to perform DFS and detect cycles
    private void detectCycle(ArrayList<Integer> graph[], int visited[], int[] recStack, int v) {
        // If a cycle is already detected, stop further processing
        if (cycle) return;

        // Mark the current course as visited and add it to the recursion stack
        visited[v] = 1;
        recStack[v] = 1;
        
        // Go through each course that `v` depends on
        for (int i = 0; i < graph[v].size(); i++) {
            int neighbor = graph[v].get(i);
            
            // If the neighbor is already in the recursion stack, we found a cycle
            if (recStack[neighbor] == 1) {
                cycle = true;
                return;
            }
            
            // If the neighbor course hasn't been visited, recursively check it
            if (visited[neighbor] == 0) {
                detectCycle(graph, visited, recStack, neighbor);
            }
        }
        
        // Remove the current course from the recursion stack as we backtrack
        recStack[v] = 0;
    }
}

 */
