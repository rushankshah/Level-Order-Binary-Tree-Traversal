import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderBinaryTreeTraversal {

    static class TreeNode {
        int val;
        TreeNode leftNode;
        TreeNode rightNode;

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.leftNode = left;
            this.rightNode = right;
        }
    }

    public static void main(String[] args) {
        TreeNode leftleftNode = new TreeNode(5, null, null);
        TreeNode rightrightNode = new TreeNode(6, null, null);
        TreeNode leftNode = new TreeNode(3, leftleftNode, null);
        TreeNode rightNode = new TreeNode(4, null, rightrightNode);
        TreeNode rootNode = new TreeNode(2, leftNode, rightNode);
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> answer = new ArrayList<>();
        queue.offer(rootNode);
        while(queue.size()!=0){
            List<Integer> tempList = new ArrayList<>();
            int q = queue.size();
            for (int i = 0; i < q; i++) {
                TreeNode tempNode = queue.poll();
                tempList.add(tempNode.val);
                if(tempNode.leftNode != null) queue.offer(tempNode.leftNode);
                if(tempNode.rightNode != null) queue.offer(tempNode.rightNode);
            }
            answer.add(tempList);
        }
        answer.forEach((e) -> {
            e.forEach((element) -> {
                System.out.println(element);
            });
        });
    }
}