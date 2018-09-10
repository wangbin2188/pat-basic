package algorithm;

import java.util.*;

import static algorithm.Prim.M;
import static algorithm.Prim.createNetWork;

/**
 * Created by wangbin10 on 2018/9/10.
 * 使用Kruskal算法生成最小生成树，以遍历所有连通顶点的边作为主要途径
 * 关键点在于：
 * 1.所有边按照权重从小到大排序
 * 2.已经连通的点，即便再遇到连通的边也不再计入最小连通集合
 * 3.重复上述过程，直到所有点都被连通
 */
public class Kruskal {
    public static void main(String[] args) {
        NetWork netWork = createNetWork();
        List<Side> sides = getSides(netWork);
        Collections.sort(sides);
        getMiniSpanTree(netWork, sides);
    }

    private static void getMiniSpanTree(NetWork netWork, List<Side> sides) {
        Set<String> vertex = new HashSet<>();
        while (vertex.size() != netWork.getVertexNum()) {
            for (Side side : sides) {
                if (!(vertex.contains(side.getStart()) && vertex.contains(side.getEnd()))) {
                    System.out.println(side.getStart() + "->" + side.getEnd());
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


