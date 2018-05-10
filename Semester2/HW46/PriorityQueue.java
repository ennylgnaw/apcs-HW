public interface PriorityQueue {
    
    //adds String to end of ArrayList
    public void add( String str );

    //removes miminum String (priority)
    public String removeMin();

    //returns minimum String (priority)
    public String peekMin();

    //returnd true if empty, false if not
    public boolean isEmpty();
    
}
