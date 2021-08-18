import java.util.LinkedList;

public class hashmap {
    LinkedList<Entry>[] hashmap = new LinkedList[2];
    int size = 0;
    public hashmap(){

    } 

    public void put(Key key, Value value){
        if(size >= hashmap.length){
            resize();
        }

        int ix = getIndex(key) % hashmap.length;

        if(hashmap[ix]==null){
            hashmap[ix] = new LinkedList<>();
            hashmap[ix].add(new Entry(key, value));
            size++;
            return;
        }else{
            for(Entry entry: hashmap[ix]){
                if(entry.key.equals(key)){
                    entry.value = value;
                    size++;
                    return;
                }
            }
            
            hashmap[ix].add(new Entry(key, value));
            size++;
            return; 
        }
    }

    public Value get(Key key){
        int ix = getIndex(key) % hashmap.length;
        if(hashmap[ix]==null) return null;

        for(Entry entry: hashmap[ix]){
            if(entry.key.equals(key)){
                return entry.value;
            }
        }
        return null;

    }

    public void remove(){
        if(key ==null) return;

        int ix = getIndex(key) % hashmap.length;

        if(hashmap[ix]==null) return;

        Entry toRemove = null;

        for(Entry entry: hashmap[ix]){
            if(entry.key.equals(key)){
                toRemove = entry;
                break;
            }
        }

        hashmap[ix].remove(toRemove);

    }
    
    public boolean containsKey(){
        if(key ==null) return false;

        int ix = getIndex(key) % hashmap.length;

        if(hashmap[ix]==null) return false;

        for(Entry entry: hashmap[ix]){
            if(entry.key.equals(key)){
                return true;
            }
        }
        
        return false;

    }
    
    public void resize(){
        LinkedList<Entry>[] oldMap = hashmap;

        hashmap = new LinkedList[size+2];
        size = 0;

        for(int i = 0; i <oldMap.length; i++){
            if(oldMap[i]==null) continue;
            for(Entry entry: oldMap[i]){
                put(entry.key, entry.value);
            }
        }
    }

    public int getIndex(Key key){return key.hashCode(); }

    public int size(){return size;}

}