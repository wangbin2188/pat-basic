package algorithm;

import java.util.*;

import static algorithm.Kruskal.getSides;
import static algorithm.Prim.M;
import static algorithm.Prim.createNetWork;

/**
 * Created by wangbin10 on 2018/9/10.
 * Dijkstra算法是解决单源最短路径的核心算法，在每个阶段它都讲当前出现的作为最好的去处理；
 * 核心在于在每个阶段选取未知节点中到原点距离最小的一个（v)，标为已知；
 * 以之为基础遍历其它未知节点(t)，如果D(v)+c<D(t),则更新各节点到原点的距离信息表
 * 遍历v结束，则继续寻找下一个未知节点中到原点最小的一个
 * 直到所有节点标为已知，算法结束
 */
public class Dijkstra {
    public static void main(String[] args) {
        /**初始化图*/
        NetWork netWork = createNetWork();
        /**获取所有边并按从小到大排序*/
        List<Side> sides = getSides(netWork);
        Collections.sort(sides);
        /**获取其它节点到v1的最短路径*/
        String origin = "v1";
        getShortestPath(netWork, sides, origin);
    }

    private static void getShortestPath(NetWork netWork, List<Side> sides, String origin) {
        /**创建临时表，存储所有节点的信息*/
        Map<String, KnownTable> knownSet = new HashMap<>();
        /**初始化临时表，所有节点初始化为known=false,distance=无穷大值，path=null*/
        for (int i = 0; i < netWork.getVertexNum(); i++) {
            KnownTable knownTable = new KnownTable();
            knownTable.setKnown(false);
            knownTable.setDistance(M);
            knownSet.put(netWork.getVertex()[i], knownTable);
        }

        /**初始化原点*/
        KnownTable knownTable1 = knownSet.get(origin);
        knownTable1.setKnown(true);
        knownTable1.setDistance(0);

        String target = origin;
        while (target != null) {
            for (Side side : sides) {
                /**获取当前遍历节点到原点的距离*/
                Integer distanceToOrigin = getCurrentDistance(knownSet, target);
                /**如果遍历的边的其中一个端点恰好是遍历节点，且（遍历节点到原点的距离+当前边的权值）<目标节点到原点的距离，则更新目标原点的临时表*/
                if (side.getStart().equals(target)) {
                    if (distanceToOrigin + side.getWeight() < getCurrentDistance(knownSet, side.getEnd())) {
                        updateKnownTable(knownSet, side.getEnd(), distanceToOrigin + side.getWeight(), target);
                    }
                } else if (side.getEnd().equals(target)) {
                    if (distanceToOrigin + side.getWeight() < getCurrentDistance(knownSet, side.getStart())) {
                        updateKnownTable(knownSet, side.getStart(), distanceToOrigin + side.getWeight(), target);
                    }
                }
            }
            /**遍历完当前节点后寻找下一个未被遍历且到原点距离最小的节点,并将这个节点的known标记为true*/
            target = getShortestUnknownVertex(knownSet);
            setKnown(knownSet, target);
        }
        printTable(knownSet);
    }

    /**
     * 从临时表获取当前遍历节点到原点的距离
     */
    public static Integer getCurrentDistance(Map<String, KnownTable> knownSet, String vertex) {
        return knownSet.get(vertex).getDistance();
    }

    /**
     * 将遍历过的节点标为已知
     */
    public static void setKnown(Map<String, KnownTable> knownSet, String vertex) {
        if (vertex == null) {
            return;
        }
        knownSet.get(vertex).setKnown(true);
    }

    /**
     * 打印临时表，所有节点都遍历后即为最终表
     */
    public static void printTable(Map<String, KnownTable> knownSet) {
        for (String s : knownSet.keySet()) {
            KnownTable knownTable = knownSet.get(s);
            System.out.println(s + "=" + knownTable.getKnown() + "," + knownTable.getDistance() + "," + knownTable.getPath());
        }
    }

    /**
     * 更新临时表，包括更新节点是否已遍历，节点到原点的当前最短距离和上一个节点
     */
    public static void updateKnownTable(Map<String, KnownTable> knownSet, String name, Integer distance, String path) {
        KnownTable knownTable1 = knownSet.get(name);
        knownTable1.setDistance(distance);
        knownTable1.setPath(path);
    }

    /**
     * 获取未遍历的节点中到原点距离最小的一个节点
     */
    public static String getShortestUnknownVertex(Map<String, KnownTable> knownSet) {
        String target = null;
        Integer shortest = M;
        for (String s : knownSet.keySet()) {
            KnownTable knownTable = knownSet.get(s);
            if (!knownTable.getKnown() && knownTable.getDistance() < shortest) {
                shortest = knownTable.getDistance();
                target = s;
            }
        }
        return target;
    }
}

/**
 * 存放每个节点的临时信息表，包括是否已知（已经遍历过），到原点的当前最短距离和前一个节点
 */
class KnownTable {
    private Boolean known;
    private Integer distance;
    private String path;

    public Boolean getKnown() {
        return known;
    }

    public void setKnown(Boolean known) {
        this.known = known;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

}
