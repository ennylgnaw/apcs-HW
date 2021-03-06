/*
  Lynne Wang
  APCS2 pd1
  HW #44: Prune Your Tree
  2018-05-03
*/
/*****************************************************
 * class BST - v1:partial
 * Implementation of the BINARY SEARCH TREE abstract data type (ADT)
 *
 * A BST maintains the invariant that, for any node N with value V,
 * L<V && V<R, where L and R are node values in N's left and right
 * subtrees, respectively.
 * (Any value in a node's left subtree must be less than its value,
 *  and any value in its right subtree must be greater.)
 * This BST only holds ints (its nodes have int cargo)
 *****************************************************/

public class BST{

    //instance variables / attributes of a BST:
    TreeNode _root;
    TreeNode _follower = null;

    /*****************************************************
     * default constructor
     *****************************************************/
    BST( ){
	_root = null;
    }


    /*****************************************************
     * void insert( int )
     * Adds a new data element to tree.
     *****************************************************/
    public void insert( int newVal ){
	TreeNode newNode = new TreeNode( newVal );

	if ( _root == null ) {
	    _root = newNode;
	    return;
	}
	insert( _root, newNode );
    }
    //recursive helper for insert(int)
    public void insert( TreeNode stRoot, TreeNode newNode ){
	if ( newNode.getValue() < stRoot.getValue() ) {
	    //if no left child, make newNode the left child
	    if ( stRoot.getLeft() == null )
		stRoot.setLeft( newNode );
	    else //recurse down left subtree
		insert( stRoot.getLeft(), newNode );
	    return;
	}
	else { // new val >= curr, so look down right subtree
	    //if no right child, make newNode the right child
	    if ( stRoot.getRight() == null )
		stRoot.setRight( newNode );
	    else //recurse down right subtree
		insert( stRoot.getRight(), newNode );
	    return;
	}
    }//end insert()




    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //~~~~~~~~~~~~~v~~TRAVERSALS~~v~~~~~~~~~~~~~~~~~~~~~

    // each traversal should simply print to standard out
    // the nodes visited, in order

    //process root, recurse left, recurse right
    public void preOrderTrav(){
	preOrderTrav( _root );
    }
    public void preOrderTrav( TreeNode currNode ){
	if ( currNode == null ) //stepped beyond leaf
	    return;
	System.out.print( currNode.getValue() + " " );
	preOrderTrav( currNode.getLeft() );
	preOrderTrav( currNode.getRight() );
    }

    //recurse left, process root, recurse right
    public void inOrderTrav(){
	inOrderTrav( _root );
    }
    public void inOrderTrav( TreeNode currNode ){
	if ( currNode == null ) //stepped beyond leaf
	    return;
	inOrderTrav( currNode.getLeft() );
	System.out.print( currNode.getValue() + " " );
	inOrderTrav( currNode.getRight() );
    }

    //recurse left, recurse right, process root
    public void postOrderTrav(){
	postOrderTrav( _root );
    }
    public void postOrderTrav( TreeNode currNode ){
	if ( currNode == null ) //stepped beyond leaf
	    return;
	postOrderTrav( currNode.getLeft() );
	postOrderTrav( currNode.getRight() );
	System.out.print( currNode.getValue() + " "  );
    }

    //~~~~~~~~~~~~~^~~TRAVERSALS~~^~~~~~~~~~~~~~~~~~~~~~
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    /*****************************************************
     * TreeNode search(int)
     * returns pointer to node containing target,
     * or null if target not found
     *****************************************************/
    TreeNode search( int target ){
	return search(_root, target);
    }
    TreeNode search(TreeNode currNode, int target){
	if (currNode.getValue() == target || currNode == null)
	    return currNode;
	_follower = currNode;
	if (currNode.getValue() > target)
	    return search(currNode.getLeft(), target);
	return search(currNode.getRight(), target);
    }
    /*****************************************************
     * int height()
     * returns height of this tree (length of longest leaf-to-root path)
     * eg: a 1-node tree has height 0
     *****************************************************/
    public int height(){
	return height(_root) - 1;
    }
    public int height(TreeNode currNode){
	if (currNode == null){
	    return 0;
	}
	else{
	    int LHeight = height(currNode.getLeft());
	    int RHeight = height(currNode.getRight());
	    if (LHeight > RHeight)
		return LHeight + 1;
	    return RHeight + 1;
	}
    }
    /*****************************************************
     * int numLeaves()
     * returns number of leaves in tree
     *****************************************************/
    public int numLeaves(){
	return numLeaves(_root);
    }
    public int numLeaves(TreeNode currNode){
	int counter = 0;
	if (currNode != null){
	    counter += 1;
	    if (currNode.getLeft() != null)
		counter += numLeaves(currNode.getLeft());
	    if (currNode.getRight() != null)
		counter += numLeaves(currNode.getRight());
	}
	return counter;
    }

    public TreeNode remove( int val ) {
	TreeNode remNode = search( val );

	//Case 1 - remove node w/ no children
	if (remNode.getLeft() == null && remNode.getRight() == null) {
	    if (_root == remNode)
		_root = null;
	    else if (_follower.getLeft() == remNode)
		_follower.setLeft(null);
	    else
		_follower.setRight(null);
	    return remNode;
	}

	//Case 2 - remove node w/ one child
	else if (remNode.getLeft() == null) {//branch on right
	    if (_root == remNode)
		_root = remNode.getRight();
	    else if (_follower.getLeft() == remNode)
		_follower.setLeft(remNode.getRight());
	    else
		_follower.setRight(remNode.getRight());
	    return remNode;
	}

	else if (remNode.getRight() == null) {//branch on right
	    if (_root == remNode)
		_root = remNode.getLeft();
	    else if (_follower.getLeft() == remNode)
		_follower.setLeft(remNode.getLeft());
	    else
		_follower.setRight(remNode.getLeft());
	    return remNode;
	}

	//Case 3 - remove node w/ 2 children
	else {
	    TreeNode temp = remNode.getLeft();
	    while (temp.getRight() != null)
		temp = temp.getRight();
	    int newVal = temp.getValue();
	    TreeNode retNode = remove( temp.getValue() );
	    if (remNode == _root)
	        _root.setValue(newVal);
	    else
		remNode.setValue(newVal);
	    return retNode;
	}
	
    }


    //main method for testing
    public static void main( String[] args ){
	BST arbol = new BST();

	//PROTIP: sketch state of tree after each insertion
	//        ...BEFORE executing these.
	arbol.insert( 4 );
	arbol.insert( 2 );
	arbol.insert( 5 );
	arbol.insert( 6 );
	arbol.insert( 1 );
	arbol.insert( 3 );

	System.out.println( "\n-----------------------------");
	System.out.println( "pre-order traversal:" );
	arbol.preOrderTrav();

	System.out.println( "\n-----------------------------");
	System.out.println( "in-order traversal:" );
	arbol.inOrderTrav();

	System.out.println( "\n-----------------------------");
	System.out.println( "post-order traversal:" );
	arbol.postOrderTrav();

	System.out.println( "\n-----------------------------");

	System.out.println(arbol.search(3).getValue()); //3
	System.out.println(arbol.height()); //2
	System.out.println(arbol.numLeaves()); //6

	//remove tester
	arbol.remove(6);
	arbol.preOrderTrav(); //4 2 1 3 5
	System.out.println();
	arbol.remove(2);
	arbol.preOrderTrav(); //4 1 3 5
	System.out.println();
	arbol.remove(3);
	arbol.preOrderTrav(); //4 1 5
	System.out.println();
	arbol.remove(4);
	arbol.preOrderTrav(); //1 5
	System.out.println();
    }
}//end class
