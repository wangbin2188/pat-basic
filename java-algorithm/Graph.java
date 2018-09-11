package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangbin10 on 2018/9/10.
 * 图的数据结构主要有邻接矩阵和邻接表，邻接矩阵简单直观，但毕竟浪费空间，相对而言，邻接表更为有效。
 * 图内又包含两种数据结构：顶点和边，在这里分别用Vertex和Edge来表示
 * Graph本身包含图的顶点数和边的条数，并包含所有顶点的一个数组（方便起见，这里以list存储所有顶点）
 * 顶点有两个属性，顶点的值data和顶点指向的第一条边；
 * 边edge也有两个属性，边指向的顶点和边指向的下一条边，通过这种链式结构，通过一个顶点即可遍历它所有的边
 * 通过遍历所有顶点，就可以遍历图所有的点和边
 */
class Edge {
    private Integer vertexIndex;
    private Edge nextEdge;

    public Integer getVertexIndex() {
        return vertexIndex;
    }

    public void setVertexIndex(Integer vertexIndex) {
        this.vertexIndex = vertexIndex;
    }

    public Edge getNextEdge() {
        return nextEdge;
    }

    public void setNextEdge(Edge nextEdge) {
        this.nextEdge = nextEdge;
    }
}

class Vertex {
    private Character data;
    private Edge firstEdge;

    public char getData() {
        return data;
    }

    public void setData(char data) {
        this.data = data;
    }

    public Edge getFirstEdge() {
        return firstEdge;
    }

    public void setFirstEdge(Edge firstEdge) {
        this.firstEdge = firstEdge;
    }
}

public class Graph {
    private Integer vertexNum;
    private Integer edgeNum;
    private List<Vertex> vertices;

    public Integer getVertexNum() {
        return vertexNum;
    }

    public void setVertexNum(Integer vertexNum) {
        this.vertexNum = vertexNum;
    }

    public Integer getEdgeNum() {
        return edgeNum;
    }

    public void setEdgeNum(Integer edgeNum) {
        this.edgeNum = edgeNum;
    }

    public List<Vertex> getVertices() {
        return vertices;
    }

    public void setVertices(List<Vertex> vertices) {
        this.vertices = vertices;
    }

    /**
     * 查找某顶点在顶点数组中的下标
     */
    public static Integer getPosition(Graph g, Character ch) {
        for (int i = 0; i < g.vertexNum; i++) {
            if (ch.equals(g.getVertices().get(i).getData())) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 将依附于顶点的边加入顶点之后的边链表：
     * 1.如果第一条边为null，则此边即为第一条边；
     * 2.否则，则向后遍历边链表，将当前边加入到边链表的末尾
     */
    public static void linkLast(Vertex list, Edge node) {
        if (list.getFirstEdge() == null) {
            list.setFirstEdge(node);
        } else {
            Edge nextEdge = list.getFirstEdge();
            while (nextEdge.getNextEdge() != null) {
                nextEdge = nextEdge.getNextEdge();
            }
            nextEdge.setNextEdge(node);
        }


    }

    public Graph(Integer vertexNum, Integer edgeNum) {
        this.vertexNum = vertexNum;
        this.edgeNum = edgeNum;
    }

    /**
     * 打印图
     */
    public static void printGraph(Graph graph) {
        for (int i = 0; i < graph.vertexNum; i++) {
            System.out.print(graph.getVertices().get(i).getData() + ":");
            Edge firstEdge = graph.getVertices().get(i).getFirstEdge();
            while (firstEdge != null) {
                System.out.print("->");
                System.out.print(graph.getVertices().get(firstEdge.getVertexIndex()).getData());
                firstEdge = firstEdge.getNextEdge();
            }
            System.out.println();
        }
    }



    public static Graph initGraph() {
        char[] nodes = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        char[][] edges = {
                {'A', 'C'},
                {'A', 'D'},
                {'A', 'F'},
                {'B', 'C'},
                {'C', 'D'},
                {'D', 'E'},
                {'E', 'G'},
                {'G', 'F'}
        };

        int vLen = nodes.length;
        int eLen = edges.length;
        Graph graph = new Graph(vLen, eLen);
        List<Vertex> vertices = new ArrayList<>();
        for (char node : nodes) {
            Vertex vertex = new Vertex();
            vertex.setData(node);
            vertices.add(vertex);
        }
        graph.setVertices(vertices);

        for (int i = 0; i < edges.length; i++) {
            char c1 = edges[i][0];
            char c2 = edges[i][1];
            int p1 = getPosition(graph, c1);
            int p2 = getPosition(graph, c2);

            Edge edge1 = new Edge();
            edge1.setVertexIndex(p2);
            Edge edge2 = new Edge();
            edge2.setVertexIndex(p1);

            linkLast(graph.getVertices().get(p1), edge1);
            /**将下一行代码保留即为无向图，注释掉即为有向图*/
//            linkLast(graph.getVertices().get(p2), edge2);

        }
        return graph;
    }

    public static void main(String[] args) {
        Graph graph = initGraph();
        printGraph(graph);
    }
}
