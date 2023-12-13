# DAG
Coding Assesment

Approach
•	We are storing the list of edges in a map whose values are linkedlist of edges instead of a linked list or 2D array as the vertex id are not continuous like 1,2,3,….,v.
•	Then we will find the topological sort for the given graph.
•	Then we are storing distance of the new vertex from our start vertex in a map.
•	We only visit the vertices that are reachable by our start vertex
•	We iterate through the distance map to get the maximum distance.

1.	Does the solution work for larger graphs?
      •	Yes, it will work for larger graphs
2.	Can you think of any optimizations?
      •	Not any major ones, it is well optimized
3.	What’s the computational complexity of your solution?
      •	Building the adjacency list representation of the graph: O(E), where E is the number of edges.
      •	Topological sorting using DFS: O(V+E), where V is the number of vertices and E is the number of edges. This is because we perform a DFS traversal on all vertices and edges to create the topological order.
      •	Updating the distances for each vertex: O(V+E). For each vertex, we visit all its outgoing edges once.
      •	Finding the maximum distance among all vertices: O(V).
      •	Thus, Time complexity is O(V+E)
      •	Space complexity is O(V+E) as we are storing the graph edges in the map.
4.	Are there any unusual cases that aren't handled?
      •	No



#Steps

1. Clone the code form the repository
2. Use any IDE(add required java extensions)
3. run the code.
