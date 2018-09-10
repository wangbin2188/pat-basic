package algorithm;

import java.util.*;

import static algorithm.Prim.M;
import static algorithm.Prim.createNetWork;

/**
 * Created by wangbin10 on 2018/9/10.
 * 使用Kruskal算法生成最小生成树，以遍历所有连通顶点的边作为主要途径
 * 关键点在于：
 * 1.所有边按照权重从小到大排序
 * 2.涉及到一个查并集的问题：
 * （1）：需要考虑一条新的边加入到连通集时，是否会形成圈；
 * （2）：判断的方法就是把已经连通的点集看做是一棵树，他们拥有相同的根节点，即parent;
 * （3）：当我们想将一条边加入新连通集时，首先判断他们是否已经在一棵树上，方法就是find他们是否有相同的parent；
 * （4）：如果没有，说明他们尚未连通，则把他们加入到连通点集中，并将两个节点所在的树合并成同一颗树，即union操作；
 * 3.重复上述过程，直到所有点都被连通
 */
public class Kruskal {
    public static void main(String[] args) {
        NetWork netWork = createNetWork();
        List<Side> sides = getSides(netWork);
        Collections.sort(sides);
        List<Integer> parent = new ArrayList<>();
        Integer vertexNum = netWork.getVertexNum();
        /**将每个节点的父节点初始化为节点本身*/
        for (int i = 0; i < vertexNum; i++) {
            parent.add(i, i);
        }
        getMiniSpanTree(netWork, parent, sides);

    }

    /**
     * 查找某个节点的根节点，如果两个节点的根节点相同，说明他们在同一颗树上，也即他们是已经连通的
     */
    private static int findParent(NetWork netWork, List<Integer> parent, String x) {
        for (int i = 0; i < netWork.getVertexNum(); i++) {
            if (x.equals(netWork.getVertex()[i])) {
                return parent.get(i);
            }
        }
        return -1;
    }

    /**
     * 合并两个点所在的树，即把所有和两个点相同父节点的节点统一父节点
     */
    private static void union(NetWork netWork, List<Integer> parent, String x, String y) {
        int m = findParent(netWork, parent, x);
        int n = findParent(netWork, parent, y);

        if (m != n) {
            int newParent = m > n ? n : m;
            for (int i = 0; i < parent.size(); i++) {
                if (parent.get(i) == m || parent.get(i) == n) {
                    parent.set(i, newParent);
                }
            }
        }
    }

    private static void getMiniSpanTree(NetWork netWork, List<Integer> parent, List<Side> sides) {
        Set<String> vertex = new HashSet<>();
        while (vertex.size() != netWork.getVertexNum()) {
            for (Side side : sides) {
                String start = side.getStart();
                String end = side.getEnd();
                if (findParent(netWork, parent, start) != findParent(netWork, parent, end)) {
                    System.out.println(side.getStart() + "->" + side.getEnd());
                    union(netWork, parent, start, end);
                    vertex.add(side.getStart());
                    vertex.add(side.getEnd());
                }
            }
        }
    }

    /**
     * 通过遍历图的邻接矩阵生成图的边列表，无向图中<u,v>和<v,u>是同一条边，无需重复计入
     */
    private static List<Side> getSides(NetWork netWork) {
        List<Side> sides = new ArrayList<>();
        for (int i = 0; i < netWork.getVertexNum(); i++) {
            for (int j = i; j < netWork.getVertexNum(); j++) {
                if (!netWork.getWeight()[i][j].equals(M)) {
                    Side side = new Side(netWork.getVertex()[i], netWork.getVertex()[j], netWork.getWeight()[i][j]);
                    sides.add(side);
                }
            }
        }
        return sides;
    }
}

/**
 * 对集合进行排序，则集合中的元素需要实现Comparable接口，重写compareTo方法
 */
class Side implements Comparable<Side> {
    private String start;
    private String end;
    private Integer weight;

    public Side(String start, String end, Integer weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(Side o) {
        return this.getWeight().compareTo(o.getWeight());
    }
}


