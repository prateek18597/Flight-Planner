import java.util.*;
public class PriceComparator implements Comparator
{
	@Override
    public int compare(Object o1, Object o2) {
        Node2 n1=(Node2)o1;
        Node2 n2=(Node2)o2;
        if(n1.node.price==n2.node.price)
            return 0;
        else if(n1.node.price>n2.node.price)
            return 1;
        else
            return -1;
        
    }
}
