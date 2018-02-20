package scripts.wastedbro.api.tree_framework.updated;

/**
 * @author Wastedbro
 */
public class DecisionTree
{

    private Object root;

    public DecisionTree(Object root) {
        this.root = root;
    }

    public Runnable getValidRunnable() {
        return getValidRunnable(root);
    }

    private Runnable getValidRunnable(Object obj)
    {
        if (obj instanceof Runnable) {
            return (Runnable) obj;
        } else {
            DecisionNode node = (DecisionNode) obj;
            return getValidRunnable(node.isValid() ? node.getValidNode() : node.getInvalidNode());
        }
    }


    public void print()
    {
        ((DecisionNode)root).print("", true);
    }

}