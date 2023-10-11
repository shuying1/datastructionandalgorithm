package com.iflytek.huffmancode;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Map;

public class HuffmanZipAndDecode {
    public static void main(String[] args) {
        //测试压缩文件
//        String srcFile="D:\\D\\专业笔记\\Java\\数据结构与算法Java\\尚硅谷数据结构和算法\\资料\\压缩测试文件\\Uninstall.xml";
//        String dstFile="D:\\D\\专业笔记\\Java\\数据结构与算法Java\\尚硅谷数据结构和算法\\资料\\压缩测试文件\\Uninstall.zip";
//        zipFile(srcFile,dstFile);
//        System.out.println("压缩文件ok");

        //测试解压文件
        String zipFile = "D:\\D\\专业笔记\\Java\\数据结构与算法Java\\尚硅谷数据结构和算法\\资料\\压缩测试文件\\Uninstall.zip";
        String dstFile = "D:\\D\\专业笔记\\Java\\数据结构与算法Java\\尚硅谷数据结构和算法\\资料\\压缩测试文件\\Uninstall.xml";
        unZipFile(zipFile, dstFile);
        System.out.println("解压成功");

    }

    /**
     * 编写一个方法，完成对压缩文件的解压
     *
     * @param zipFile 准备解压的文件
     * @param dstFile 将文件解压到哪个路径
     */
    public static void unZipFile(String zipFile, String dstFile) {
        //定义文件输入流
        InputStream is = null;
        //定义一个对象输入流
        ObjectInputStream ois = null;
        //定义文件的输出流
        OutputStream os = null;
        try {
            //创建文件输入流
            is = new FileInputStream(zipFile);
            //创建一个和 is 关联的对象输入流
            ois = new ObjectInputStream(is);
            //读取 byte 数组 huffmanBytes
            byte[] huffmanBytes = (byte[]) ois.readObject();
            //读取赫夫曼编码表
            Map<Byte, String> huffmanCodes = (Map<Byte, String>) ois.readObject();

            //解码
            byte[] bytes = HuffmanCode.decode(huffmanCodes, huffmanBytes);
            //将 bytes 数组写入到目标文件
            os = new FileOutputStream(dstFile);
            //写数据到 dstFile 文件
            os.write(bytes);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                os.close();
                ois.close();
                is.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * 编写方法，将一个文件进行压缩
     *
     * @param srcFile 你传入的希望压缩的文件的全路径
     * @param dstFile 我们压缩后将压缩文件放到哪个目录
     */
    public static void zipFile(String srcFile, String dstFile) {
        //创建输出流
        OutputStream os = null;
        ObjectOutputStream oos = null;
        //创建文件的输入流
        FileInputStream is = null;
        try {
            //创建文件的输入流
            is = new FileInputStream(srcFile);
            //创建一个和源文件大小一样的 byte[]
            byte[] b = new byte[is.available()];
            is.read(b);
            //直接对源文件压缩

            byte[] huffmanBytes = HuffmanCode.huffmanZip(b);
            //创建文件的输出流, 存放压缩文件
            os = new FileOutputStream(dstFile);
            //创建一个和文件输出流关联的ObjectOutputStream
            oos = new ObjectOutputStream(os);
            //把赫夫曼编码后的字节数组写入压缩文件
            oos.writeObject(huffmanBytes);
            //这里我们以对象流的方式写入赫夫曼编码，是为了以后我们恢复源文件时使用
            // 注意一定要把赫夫曼编码写入压缩文件
            oos.writeObject(HuffmanCode.huffmanCodes);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
                oos.close();
                os.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
}
