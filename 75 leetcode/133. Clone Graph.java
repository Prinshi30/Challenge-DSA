/* Explanation in Simple Steps
Purpose of the Code:

This code aims to create a deep copy of an undirected graph, meaning every node and its connections (neighbors) are fully replicated.
Initialize a Map to Track Visited Nodes:

We use a HashMap<Node, Node> called visited to keep track of nodes we’ve already cloned. This avoids re-cloning the same node multiple times and handles cyclic graphs (where nodes are interconnected).
Base Case – If the Node is Null:

If the input node is null, we simply return null as there’s nothing to clone.
Check if the Node is Already Cloned:

If the node has been visited (already cloned), we retrieve and return its clone from the visited map. This prevents duplication.
Create a Clone Node:

If the node has not been cloned yet, we create a clone of it with the same value but no neighbors initially.
Then, we add this clone to the visited map, linking the original node with its clone.
Clone the Neighbors:

For each neighbor of the original node, we recursively clone it by calling cloneGraph(neighbor).
We then add each cloned neighbor to the list of neighbors of our cloneNode.
Return the Fully Cloned Node:

After all neighbors are cloned and added to the clone’s neighbor list, we return the clone, representing a fully replicated node and its connections.
Key Points
Recursive Depth-First Search (DFS): This approach goes deep into the graph, cloning nodes as it visits them.
Avoiding Cycles: The visited map prevents infinite recursion in cyclic graphs by storing clones of nodes already visited.
Deep Copy: Each node and its connections are copied, creating an independent structure separate from the original graph. */



/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Node, Node> visited = new HashMap<>();  // To store visited nodes and their clones

    public Node cloneGraph(Node node) {
        // If the node is null, just return null (nothing to clone)
        if (node == null) {
            return node;
        }

        // If the node was already visited, return its clone to avoid re-cloning
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        // Create a new clone node with the same value but no neighbors yet
        Node cloneNode = new Node(node.val, new ArrayList<>());
        // Save the original node and its clone in the visited map
        visited.put(node, cloneNode);

        // For each neighbor of the original node, clone it and add it to the clone's neighbors list
        for (Node neighbor : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));  // Recursively clone each neighbor
        }

        // Return the fully constructed clone
        return cloneNode;
    }
}
