class RandomizedSet {
    Map<Integer,Integer> setMap;
    ArrayList<Integer> elems;
    Random r;
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        //Stores elements with their locations in ArrayList
        setMap = new HashMap<Integer,Integer>();
        elems = new ArrayList<Integer>();
        r = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(setMap.containsKey(val) == true)
        {
            return false;
        }
        elems.add(val);
        setMap.put(val,elems.size()-1);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        int arrayIndex,temp,lastIndex;
        if(setMap.containsKey(val) == true)
        {
            arrayIndex = setMap.get(val);
            lastIndex = elems.size()-1;
            if(arrayIndex == lastIndex)
            {
                setMap.remove(elems.get(arrayIndex));
                elems.remove(arrayIndex);
            }
            else
            {
                temp = elems.get(arrayIndex);
                elems.set(arrayIndex,elems.get(lastIndex));
                elems.set(lastIndex,temp);
                setMap.replace(elems.get(arrayIndex),arrayIndex);
                setMap.remove(temp);
                elems.remove(lastIndex);
            }
            return true;
        }
        return false;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int randIndex = r.nextInt(elems.size());
        return elems.get(randIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
