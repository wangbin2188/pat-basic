package algorithm;

import java.util.*;

/**
 * Created by wangbin10 on 2018/9/10.
 */
public class Prim {

    public static final int M = Integer.MAX_VALUE;

    public static void main(String[] args) {
        NetWork netWork = createNetWork();
        miniSpanTree(netWork);
    }

    public static NetWork createNetWork() {
        NetWork netWork = new NetWork();
        netWork.setVertexNum(7);
        netWork.setEdgeNum(12);
        netWork.setVertex(new String[]{"v1", "v2", "v3", "v4", "v5", "v6", "v7"});
        Integer[][] weight = {
                {M, 2, 4, 1, M, M, M},
                {2, M, M, 3, 10, M, M},
                {4, M, M, 2, M, 5, M},
                {1, 3, 2, M, 7, 8, 4},
                {M, 10, M, 7, M, M, 6},
                {M, M, 5, 8, M, M, 1},
                {M, M, M, 4, 6, 1, M},
        };
        netWork.setWeight(weight);
        return netWork;
    }

    /**
     * 采用Prim算法实现图的最小生成树
     * 要点在于：
     * 1.将图中所有点分成两个集合，已知集合和未知集合，寻找两个集合之间最小的连通路径；
     * 2.找到之后将新联通的点加入已知集合，并从未知集合删除
     * 3.重复上述过程，直到所有的点变成已知集合
     */
    private static void miniSpanTree(NetWork netWork) {
        String[] vertex = netWork.getVertex();
        Set<String> uSet = new HashSet<>();
        Set<String> vSet = new HashSet<>();

        uSet.add("v1");
        vSet.addAll(Arrays.asList(vertex));
        vSet.remove("v1");

        while (vSet.size() != 0) {
            int lowCost = M;
            int i_index = -1;
            int j_index = -1;
            for (int i = 0; i < netWork.getVertexNum(); i++) {
                for (int j = 0; j < netWork.getVertexNum(); j++) {
                    if (uSet.contains(vertex[i]) && vSet.contains(vertex[j])) {
                        if (lowCost > netWork.getWeight()[i][j]) {
                            lowCost = netWork.getWeight()[i][j];
                            i_index = i;
                            j_index = j;
                        }
                    }
                }
            }
            uSet.add(vertex[j_index]);
            vSet.remove(vertex[j_index]);
            System.out.println(vertex[i_index] + "->" + vertex[j_index]);
        }
    }
}

/**
 * 以邻接矩阵的方式表示图，属性包括顶点数，边数，顶点数组和边的权重
 */
class NetWork {
    private Integer vertexNum;
    private Integer edgeNum;
    private String[] vertex;
    private Integer weight[][];

    public Integer getVertexNum() {
        return vertexNum;
    }

    public void setVertexNum(Integer vertexNum) {
        this.vertexNum = vertexNum;
    }

    public String[] getVertex() {
        return vertex;
    }

    public void setVertex(String[] vertex) {
        this.vertex = vertex;
    }

    public Integer[][] getWeight() {
        return weight;
    }

    public void setWeight(Integer[][] weight) {
        this.weight = weight;
    }

    public Integer getEdgeNum() {
        return edgeNum;
    }

    public void setEdgeNum(Integer edgeNum) {
        this.edgeNum = edgeNum;
    }
}
