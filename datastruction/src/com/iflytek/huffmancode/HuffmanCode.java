package com.iflytek.huffmancode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HuffmanCode {
    public static void main(String[] args) {
        String content = "i like like like java do you like a java";
        byte[] contentBytes = content.getBytes();
        System.out.println(Arrays.toString(contentBytes));
        System.out.println("压缩前的长度" + contentBytes.length);//40

        //如何将 数据进行解压(解码)
        // 分步过程
        List<Node> nodes = getNodes(contentBytes);
        System.out.println("nodes = " + nodes);

        //测试一把，创建的赫夫曼树
        System.out.println("赫夫曼树");
        Node huffmanTreeRoot = createHuffmanTree(nodes);
        System.out.println("前序遍历");
        huffmanTreeRoot.preOrder();

        byte[] huffmanCodeBytes = huffmanZip(contentBytes);
        System.out.println("压缩后的结果是" + Arrays.toString(huffmanCodeBytes));
        System.out.println("压缩后长度是" + huffmanCodeBytes.length);

        //测试一把 byteToBitString 方法,解压
        byte[] sourceBytes = decode(huffmanCodes, huffmanCodeBytes);
        System.out.println("原来的字符串" + new String(sourceBytes));
    }

    /**
     * 编写一个方法，将字符串对应的 byte[] 数组，通过生成的赫夫曼编码表，返回一个赫夫曼编码压缩后的byte[]
     *
     * @param bytes 是原始的字符串对应的 byte[]
     * @param huffmanCodes 生成的赫夫曼编码map
     * @return 返回赫夫曼编码处理后的 byte[]
     */

    /*
    举例： String content = "i like like like java do you like a java";
    =》 byte[] contentBytes = content.getBytes();
    返回的是字符串
"1010100010111111110010001011111111001000101111111100100101001101110001110000011011101000111100101000 101111111100110001001010011011100"
    => 对应的 byte[] huffmanCodeBytes ，即 8 位对应一个 byte,放入到 huffmanCodeBytes
    huffmanCodeBytes[0] = 10101000(补码) => byte [推导 10101000=> 10101000 - 1 => 10100111(反码)=> 11011000= -88 ]
    huffmanCodeBytes[0] = -88
     */
    public static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes) {
        //1.利用 huffmanCodes 将 bytes 转成 赫夫曼编码对应的字符串
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bytes) {
            stringBuilder.append(huffmanCodes.get(b));
        }

        System.out.println("测试StringBuilder~~~" + stringBuilder.toString());

        //将 "1010100010111111110..." 转成 byte[]
        //统计返回 byte[] huffmanCodeBytes 长度
        // 一句话 int len = (stringBuilder.length() + 7) / 8;
        int len = 0;
        if (stringBuilder.length() % 8 == 0) {
            len = stringBuilder.length() / 8;
        } else {
            len = stringBuilder.length() / 8 + 1;
        }

        //创建 存储压缩后的 byte 数组
        byte[] huffmanCodeBytes = new byte[len];
        int index = 0;//记录是第几个 byte
        for (int i = 0; i < stringBuilder.length(); i += 8) {//因为是每 8 位对应一个 byte,所以步长 +8
            String strByte = null;
            if (i + 8 > stringBuilder.length()) {
                strByte = stringBuilder.substring(i);
            } else {
                strByte = stringBuilder.substring(i, i + 8);
            }
            //将 strByte 转成一个 byte,放入到 huffmanCodeBytes
            huffmanCodeBytes[index] = (byte) Integer.parseInt(strByte, 2);
            index++;
        }
        return huffmanCodeBytes;
    }


    /**
     * 使用一个方法，将前面的方法封装起来，便于我们的调用.
     *
     * @param bytes 原始的字符串对应的字节数组
     * @return 是经过赫夫曼编码处理后的字节数组(压缩后的数组)
     */
    public static byte[] huffmanZip(byte[] bytes) {
        List<Node> nodes = getNodes(bytes);
        //根据 nodes 创建的赫夫曼树
        Node huffmanTreeRoot = createHuffmanTree(nodes);
        //对应的赫夫曼编码(根据 赫夫曼树)
        Map<Byte, String> huffmanCodes = getCodes(huffmanTreeRoot);
        //根据生成的赫夫曼编码，压缩得到压缩后的赫夫曼编码字节数组
        byte[] huffmanCodeBytes = zip(bytes, huffmanCodes);
        return huffmanCodeBytes;
    }
    //完成数据的解压
    // 思路
    // 1. 将 huffmanCodeBytes [-88, -65, -56, -65, -56, -65, -55, 77, -57, 6, -24, -14, -117, -4, -60, -90, 28]
    // 重写先转成 赫夫曼编码对应的二进制的字符串 "1010100010111..."
    // 2. 赫夫曼编码对应的二进制的字符串 "1010100010111..." =》 对照 赫夫曼编码 =》 "i like like like java do you like a java"

    /**
     * 编写一个方法，完成对压缩数据的解码
     *
     * @param huffmanCodes 赫夫曼编码表 map
     * @param huffmanBytes 赫夫曼编码得到的字节数组
     * @return 就是原来的字符串对应的数组
     */
    public static byte[] decode(Map<Byte, String> huffmanCodes, byte[] huffmanBytes) {
        //1. 先得到 huffmanBytes 对应的 二进制的字符串 ， 形式 1010100010111...
        StringBuilder stringBuilder = new StringBuilder();
        //将 byte 数组转成二进制的字符串
        for (int i = 0; i < huffmanBytes.length; i++) {
            byte b = huffmanBytes[i];
            //判断是不是最后一个字节
            boolean flag = (i == huffmanBytes.length - 1);
            stringBuilder.append(byteToBitString(!flag, b));
        }
        //把字符串安装指定的赫夫曼编码进行解码
        //把赫夫曼编码表进行调换，因为反向查询 a->100 100->a
        Map<String, Byte> map = new HashMap<>();
        for (Map.Entry<Byte, String> entry : huffmanCodes.entrySet()) {
            map.put(entry.getValue(), entry.getKey());
        }
        //创建要给集合，存放 byte
        List<Byte> list = new ArrayList<>();
        //i 可以理解成就是索引,扫描 stringBuilder
        for (int i = 0; i < stringBuilder.length(); ) {
            int count = 1;// 小的计数器
            boolean flag = true;
            Byte b = null;
            while (flag) {
                //1010100010111...
                //递增的取出 key 1
                String key = stringBuilder.substring(i, i + count);//i 不动，让 count 移动，指定匹配到一个字符
                b = map.get(key);
                if (b == null) {//说明没有匹配到
                    count++;
                } else {//匹配到
                    flag = false;
                }
            }
            list.add(b);
            i += count;//i 直接移动到 count
        }
        //当 for 循环结束后，我们 list 中就存放了所有的字符 "i like like like java do you like a java"
        // 把 list 中的数据放入到 byte[] 并返回
        byte[] b = new byte[list.size()];
        for (int i = 0; i < b.length; i++) {
            b[i] = list.get(i);
        }
        return b;
    }

    /**
     * 将一个 byte 转成一个二进制的字符串
     *
     * @param flag 标志是否需要补高位如果是 true ，表示需要补高位，如果是 false 表示不补, 如果是最后一
     *             个字节，无需补高位
     * @param b    传入的 byte
     * @return 是该 b 对应的二进制的字符串，（注意是按补码返回）
     */
    public static String byteToBitString(boolean flag, byte b) {
        //使用变量保存 b
        int temp = b;//将 b 转成 int
        //如果是正数我们还存在补高位
        if (flag) {
            temp |= 256;//按位与 256 1 0000 0000 | 0000 0001 => 1 0000 0001
        }
        String str = Integer.toBinaryString(temp);//返回的是 temp 对应的二进制的补码
        if (flag) {
            return str.substring(str.length() - 8);
        } else {
            return str;
        }
    }

    //前序遍历方法
    public static void preOrder(Node root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("赫夫曼树为空");
        }
    }

    //生成赫夫曼树对应的赫夫曼编码
    //思路:
    // 1. 将赫夫曼编码表存放在 Map<Byte,String> 形式
    // 生成的赫夫曼编码表 {32=01, 97=100, 100=11000, 117=11001, 101=1110, 118=11011, 105=101,121=11010, 106=0010, 107=1111, 108=000, 111=0011}
    static Map<Byte, String> huffmanCodes = new HashMap<>();
    //2. 在生成赫夫曼编码表示，需要去拼接路径, 定义一个 StringBuilder 存储某个叶子结点的路径
    static StringBuilder stringBuilder = new StringBuilder();


    //为了调用方便，我们重载 getCodes
    public static Map<Byte, String> getCodes(Node root) {
        if (root == null) {
            return null;
        }
        //处理 root 的左子树
        getCodes(root.left, "0", stringBuilder);
        //处理 root 的右子树
        getCodes(root.right, "1", stringBuilder);
        return huffmanCodes;
    }

    /**
     * 功能：将传入的 node 结点的所有叶子结点的赫夫曼编码得到，并放入到 huffmanCodes 集合
     *
     * @param node          传入结点
     * @param code          路径：左子节点是0，右子节点1
     * @param stringBuilder 用于拼接路径
     */
    public static void getCodes(Node node, String code, StringBuilder stringBuilder) {
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
        //将 code 加入到 stringBuilder2
        stringBuilder2.append(code);
        if (node != null) {//如果 node == null 不处理
            //判断当前 node 是叶子结点还是非叶子结点
            if (node.data == null) {
                //递归处理
                //向左递归
                getCodes(node.left, "0", stringBuilder2);
                //向右递归处理
                getCodes(node.right, "1", stringBuilder2);
            } else {
                huffmanCodes.put(node.data, stringBuilder2.toString());
            }
        }

    }

    /**
     * @param bytes 接受字节数组
     * @return 返回的就是List 形式[Node[date=97 ,weight = 5], Node[]date=32,weight = 9]......],
     */
    public static List<Node> getNodes(byte[] bytes) {
        //创建一个ArrayList
        ArrayList<Node> nodes = new ArrayList<>();
        //遍历每个bytes,统计每个byte出现的次数-》map[key,value]
        Map<Byte, Integer> counts = new HashMap<>();

        for (byte b : bytes) {
            Integer count = counts.get(b);
            if (count == null) {//Map还没有这个字符数据，第一次
                counts.put(b, 1);
            } else {//Key值相同，会覆盖
                counts.put(b, count + 1);
            }
        }

        //把每一个键值转成一个 Node对象，并加入到nodes集合中
        //遍历map
        for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }
        return nodes;
    }

    /**
     * 可以通过 List 创建对应的赫夫曼树
     *
     * @param nodes
     * @return
     */
    public static Node createHuffmanTree(List<Node> nodes) {
        while (nodes.size() > 1) {
            //排序, 从小到大
            Collections.sort(nodes);
            //取出第一颗最小的二叉树
            Node leftNode = nodes.get(0);
            //取出第二颗最小的二叉树
            Node rightNode = nodes.get(1);
            //创建一棵新的二叉树，他的根节点没有 data，只有权值
            Node parent = new Node(null, leftNode.weight + rightNode.weight);
            parent.left = leftNode;
            parent.right = rightNode;

            //将已处理的两颗二叉树从nodes删除
            nodes.remove(leftNode);
            nodes.remove(rightNode);

            //将新的节点加入到nodes
            nodes.add(parent);

        }
        //nodes最后的节点，就是赫夫曼树的根节点
        return nodes.get(0);
    }
}

//创建Node ,待数据和权值
class Node implements Comparable<Node> {
    Byte data;// 存放数据(字符)本身，比如'a' => 97 ' ' => 32
    int weight;//权值, 表示字符出现的次数
    Node left;
    Node right;

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    //前序遍历
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

}
