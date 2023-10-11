package com.iflytek.Test;

/**
 * @author yings
 * @create 2022-09-18 17:17
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Apriori {
    // 数据集
    private static ArrayList<ArrayList<String>> DATASET = new ArrayList<>();
    // 待选集区域
    private static HashMap<ArrayList<String>, Double> PRE = new HashMap<>();
    // 频繁集区域
    private static HashMap<ArrayList<String>, Double> LATER = new HashMap<>();
    // 缓存项集支持度
    private static HashMap<ArrayList<String>, Double> CACHE = new HashMap<>();
    // 提前算好加数单元
    private static double ADD_UNIT;
    // 最小支持度
    private static double MIN_SUPPORT = 0.5;
    // 最小置信度
    private static double MIN_CONFIDENT = 0.8;

    /**
     * 加载数据
     *
     * @param filePath 文件路径
     */
    private static void loadData(String filePath) {
        Scanner scanner;
        try {
            scanner = new Scanner(new File(filePath));
            while (scanner.hasNext()) {
                DATASET.add(new ArrayList<>(Arrays.asList(scanner.nextLine().split(" "))));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // 单元加数
        ADD_UNIT = 1.0 / DATASET.size();
    }

    /**
     * 枝剪，过滤掉小于最小支持度的项集
     */
    private static void pruning() {
        LATER.clear();
        // 先全加过来等待删除不满足最小支持度的项集
        LATER.putAll(PRE);
        // 删除少于最小支持度的元素
        ArrayList<ArrayList<String>> deletedKeys = new ArrayList<>();
        for (ArrayList<String> key : LATER.keySet()) {
            if (LATER.get(key) < MIN_SUPPORT) {
                deletedKeys.add(key);
            }
        }
        for (ArrayList<String> key : deletedKeys) {
            LATER.remove(key);
        }
    }

    /**
     * 加载数据并求得一项集
     */
    private static void init() {
        loadData("D:\\IDEAWorkSpace\\datastructionandalgorithm\\leetcode\\src\\test.txt");

        // 求得一项集的支持度
        for (ArrayList<String> record : DATASET) {
            for (String item : record) {
                String[] itemArr = {item};
                ArrayList<String> itemList = new ArrayList<>(Arrays.asList(itemArr));
                if (!PRE.containsKey(itemList)) {
                    PRE.put(itemList, ADD_UNIT);
                } else {
                    PRE.put(itemList, PRE.get(itemList) + ADD_UNIT);
                }
            }
        }

        // 剪枝
        pruning();

        CACHE.putAll(LATER);

    }

    /**
     * 求并集
     *
     * @param arr1
     * @param arr2
     * @return
     */
    private static ArrayList<String> union(ArrayList<String> arr1, ArrayList<String> arr2) {
        Set<String> set = new HashSet<>(arr1);
        set.addAll(arr2);
        return new ArrayList<>(set);
    }

    /**
     * 迭代求出最终的频繁集
     *
     * @return
     */
    private static void getFrequentItemSet() {
        // 缓存上一次迭代的结果
        HashMap<ArrayList<String>, Double> preFrequentItemSet = new HashMap<>();
        // 迭代次数（等同于项集中项目的数量）
        int epoch = 1;

        printStage(epoch);

        // 当频繁项集数量为0时，上一次迭代的结果便是最终的频繁项集
        while (LATER.size() > 0) {
            epoch++;
            // 缓存上次结果
            preFrequentItemSet.clear();
            preFrequentItemSet.putAll(LATER);
            // 进行全连接
            PRE.clear();
            ArrayList<ArrayList<String>> itemsList = new ArrayList<>(LATER.keySet());
            for (int i = 0; i < itemsList.size(); i++) {
                for (int j = i + 1; j < itemsList.size(); j++) {
                    // 求并集
                    ArrayList<String> unionItem = new ArrayList<>(union(itemsList.get(i), itemsList.get(j)));
                    //
                    if (unionItem.size() == epoch) {
                        PRE.put(unionItem, 0.0);
                    }
                }
            }
            // 求支持度
            for (ArrayList<String> key : PRE.keySet()) {
                for (ArrayList<String> record : DATASET) {
                    if (record.containsAll(key)) {
                        PRE.put(key, PRE.get(key) + ADD_UNIT);
                    }
                }
            }
            // 枝剪
            pruning();
            // 缓存
            CACHE.putAll(LATER);

            printStage(epoch);
        }

        LATER = preFrequentItemSet;
    }

    /**
     * 打印候选集和频繁项集
     *
     * @param epoch ： 迭代次数
     */
    private static void printStage(int epoch) {
        System.out.println(epoch + "项集候选区：" + PRE);
        System.out.println("频繁" + epoch + "项集：" + LATER);
    }

    /**
     * 求子集
     *
     * @param parent
     * @return
     */
    private static ArrayList<ArrayList<String>> getSubset(ArrayList<String> parent) {
        if (parent.size() > 0) {
            ArrayList<ArrayList<String>> result = new ArrayList<>();
            // 子集个数为 2^n
            for (int i = 0; i < Math.pow(2, parent.size()); i++) {
                ArrayList<String> subSet = new ArrayList<>();
                int index = i;
                for (String s : parent) {
                    if ((index & 1) == 1) {
                        subSet.add(s);
                    }
                    index >>= 1;
                }
                result.add(subSet);
            }
            return result;
        } else {
            throw new NoSubsetException();
        }
    }

    /**
     * 相交是否为空
     *
     * @param arr1
     * @param arr2
     * @return
     */
    private static boolean isIntersectionNull(ArrayList<String> arr1,
                                              ArrayList<String> arr2) {
        Set<String> s1 = new HashSet<>(arr1);
        Set<String> s2 = new HashSet<>(arr2);

        s1.retainAll(s2);

        return s1.size() <= 0;
    }

    /**
     * 根据最终的关联集，根据求出关联规则
     */
    private static void getConnections() {
        // 遍历所有的最终频繁项集
        for (ArrayList<String> key : LATER.keySet()) {
            ArrayList<ArrayList<String>> subsets = getSubset(key);
            for (ArrayList<String> items1 : subsets) {
                // 非空真子集
                if (items1.size() > 0 && items1.size() < key.size()) {
                    double itemsSupport1 = getCache(items1);
                    // 第二个非空真子集
                    for (ArrayList<String> items2 : subsets) {
                        // 两个真子集需要互补
                        if (items2.size() > 0 && items2.size() < key.size() && union(items1, items2).equals(key) && isIntersectionNull(items1, items2)) {
                            // 事件的置信度
                            double confident = getCache(union(items1, items2)) / itemsSupport1;
                            //System.out.println(getCache(union(items1, items2)) + " " + itemsSupport1);
                            //System.out.println("互补子集" + items1 + "->" + items2 + " 置信度：" + confident);
                            // 如果事件的置信度大于最小置信度
                            if (confident > MIN_CONFIDENT) {
                                // 关联规则
                                System.out.println(items1 + "->" + items2 + " 置信度：" + confident);
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * 从缓存中获取支持度
     *
     * @param items : 目标项集
     * @return
     */
    private static double getCache(ArrayList<String> items) {
        // 尝试从缓存中获取
        Double suppose = CACHE.get(items);
        // 如果缓存中没有，则计算支持度并缓存
        if (suppose == null) {
            CACHE.put(items, 0.0);
            for (ArrayList<String> record : DATASET) {
                if (record.containsAll(items)) {
                    CACHE.put(items, CACHE.get(items) + ADD_UNIT);
                }
            }

            suppose = CACHE.get(items);
        }

        return suppose;
    }

    public static void main(String[] args) {
        // 初始化程序
        init();
        // 求得频繁项集
        getFrequentItemSet();
        // 获取关联规则
        getConnections();
    }

    static class NoSubsetException extends RuntimeException {
        NoSubsetException() {
            super("无子集");
        }
    }
}

