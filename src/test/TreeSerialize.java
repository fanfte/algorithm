package test;

import jzoffer.datastruct.TreeNode;

/**
 * Created by tianen on 2019/6/11
 *
 * @author fanfte
 * @date 2019/6/11
 **/
public class TreeSerialize {

    String Serialize(TreeNode root) {
        StringBuffer str=new StringBuffer();
        if(root==null){
            str.append("#"+" ");                                    //当前节点为空，使用#表示
            return str.toString();
        }
        str.append(root.value+" ");                                   //节点值之间用空格隔开
        str.append(Serialize(root.left));
        str.append(Serialize(root.right));
        return str.toString();
    }
    int index=-1;                                                   //全局变量，用于遍历字符串数组
    public TreeNode Deserialize(String str){                        //反序列化 串----->二叉树
        String[] strArray=str.split(" ");
        TreeNode headNode=constructTree(strArray,strArray.length);
        return headNode;
    }
    public TreeNode constructTree(String[] strArray, int len){
        index++;
        if(index>=len)
            return null;
        TreeNode newNode=null;
        if(!strArray[index].equals("#")){
            newNode=new TreeNode(Integer.valueOf(strArray[index]));
            newNode.left=constructTree(strArray,len);
            newNode.right=constructTree(strArray,len);
        }
        return newNode;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(9);

        printTreee(root);
        System.out.println();
        String serialize = new TreeSerialize().Serialize(root);
        System.out.println(serialize);
    }

    public static void printTreee(TreeNode node) {
        if (node == null) {
            System.out.print("# ");
            return;
        }
        System.out.print(node.value + " ");
        printTreee(node.left);
        printTreee(node.right);
    }
}
