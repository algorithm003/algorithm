package Week_01.id_37.bean;

/**
 * 类描述：
 * 创建人： Sun YongMeng
 * 创建时间：2019/6/20 14:06
 * 修改人：  Sun YongMeng
 * 修改时间：2019/6/20 14:06
 * 修改备注：
 * @author Symer
 */
public class TreeNode<T> {
    public T value;
    public TreeNode<T> left;
    public TreeNode<T> right;

    public TreeNode() {

    }
    public TreeNode(T value) {
        this.value = value;
    }
}
