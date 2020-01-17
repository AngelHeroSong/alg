import java.util.LinkedHashMap;
import java.util.Map;

public class LruLinkedHashMap<K,V> extends LinkedHashMap<K,V> {
    private static final Integer maxCache = 5;
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        boolean toobig = size()>maxCache;
        return toobig;
    }

    public static void main(String[] args) {
        LruLinkedHashMap<String,String> lruLinkedHashMap = new LruLinkedHashMap<>();
        lruLinkedHashMap.put("1","111");
        lruLinkedHashMap.put("2","222");
        lruLinkedHashMap.put("3","333");
        lruLinkedHashMap.put("4","444");
        lruLinkedHashMap.put("5","555");
        lruLinkedHashMap.put("6","666");

        for (String key:lruLinkedHashMap.keySet()){
            System.out.println(lruLinkedHashMap.get(key));
        }
    }
}
