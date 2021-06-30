public class Offer37 {
    StringBuilder builder;
    int u;

    public String serialize(TreeNode root) {
        builder = new StringBuilder();
        dfs_s(root);
        return builder.toString();
    }

    public TreeNode deserialize(String data) {
        u = 0;
        return dfs_d(data);
    }

    void dfs_s(TreeNode root) {
        if (root == null) {
            builder.append("#").append(',');
            return;
        }
        builder.append(root.val).append(",");
        dfs_s(root.left);
        dfs_s(root.right);
    }

    TreeNode dfs_d(String data) {
        if (data.charAt(u) == '#') {
            u += 2;
            return null;
        }
        int k = u;
        while (data.charAt(k) != ',') k++;
        TreeNode root = new TreeNode(Integer.parseInt(data.substring(u, k)));
        u = k + 1;
        root.left = dfs_d(data);
        root.right = dfs_d(data);
        return root;
    }
}