package algorithm;

import java.util.*;

import static algorithm.Graph.initGraph;

/**
 * Created by wangbin10 on 2018/9/11.
 */
public class TopologicalSort {
    public static void main(String[] args) {
        /**初始化图*/
        Graph graph = initGraph();
        /**从图的邻接表中获取图中各节点的入度Map*/
        Map<Character, Integer> intoDegree = getIntoDegree(graph);
        /**获取首个入度为零的顶点（同时从入度Map中删除当前节点），添加到一个List中*/
        Character zeroDegreeVertex = getZeroDegreeVertex(intoDegree);
        List<Character> sortQ = new ArrayList<>();
        Integer vertexNum = graph.getVertexNum();
        /**如果List不等于顶点总数，则一直从入度Map中获取入度为零的顶点*/
        while (sortQ.size() != vertexNum) {
            sortQ.add(zeroDegreeVertex);
            /**获取入度为零的顶点，同时更新顶点指向的节点的入度都-1，继续从入度数组获取入度为零的节点*/
            updateDegree(graph, intoDegree, zeroDegreeVertex);
            zeroDegreeVertex = getZeroDegreeVertex(intoDegree);
        }
        /**打印顶点的拓扑排序*/
        for (Character character : sortQ) {
            System.out.println(character);
        }
    }

    /**
     * 更新入度Map,即将入度为零的顶点从入度Map删除后，并将其指向的所有顶点的入度统一减少1
     */
    public static void updateDegree(Graph graph, Map<Character, Integer> degreeMap, Character character) {
        List<Vertex> vertices = graph.getVertices();
        for (Vertex vertex : vertices) {
            Character data = vertex.getData();
            if (data.equals(character)) {
                Edge edge = vertex.getFirstEdge();
                while (edge != null) {
                    Integer vertexIndex = edge.getVertexIndex();
                    Character data1 = vertices.get(vertexIndex).getData();
                    degreeMap.put(data1, degreeMap.get(data1) - 1);
                    edge = edge.getNextEdge();
                }
            }
        }
    }

    /**
     * 从入度数组中获取入度为零的顶点，每次只需获取一个,获取的同时从入度Map删除该顶点
     */
    public static Character getZeroDegreeVertex(Map<Character, Integer> degreeMap) {
        for (Character character : degreeMap.keySet()) {
            if (degreeMap.get(character) == 0) {
                degreeMap.remove(character);
                return character;
            }
        }
        return null;
    }

    /**
     * 遍历图，获取图的节点对应的入度Map
     */
    public static Map<Character, Integer> getIntoDegree(Graph graph) {
        Map<Character, Integer> degreeMap = new HashMap<>();
        List<Vertex> vertices = graph.getVertices();
        for (Vertex vertex : vertices) {
            degreeMap.put(vertex.getData(), 0);
        }
        for (int i = 0; i < graph.getVertexNum(); i++) {
            Vertex vertex = vertices.get(i);
            Edge edge = vertex.getFirstEdge();
            while (edge != null) {
                Integer vertexIndex = edge.getVertexIndex();
                Character data = vertices.get(vertexIndex).getData();
                degreeMap.put(data, degreeMap.getOrDefault(data, 0) + 1);
                edge = edge.getNextEdge();
            }
        }
        return degreeMap;
    }
}
