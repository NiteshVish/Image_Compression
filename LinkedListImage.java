import java.util.*;
import java.io.*;
class Node{
    private Object element;
    private Node next;
    public Node(Object x){
        element=x;
        next=null;
    }
    public Node(Object x,Node n){
        element=x;
        next=n;
    }
    public Node Next(){return next;}
    public Object Element(){return element;}
    public void  setElement(Object c){element=c;}
    public void setNext(Node n){next=n;}
}
public class LinkedListImage implements CompressedImageInterface {
    public Node[] ar;
    public int row;
    public int coulum;

	public LinkedListImage(String filename)
	{
		 try{
            File file= new File(filename);
            Scanner s=new Scanner(file);
            row=s.nextInt();
            coulum=s.nextInt();
            ar=new Node[row];
            int a,b;
            Object c=0;
            for(int i=0;i<row;i++){
                Node node2=new Node(c);
                ar[i]=node2;
                Node current=ar[i];
                b=0;
                for(int k=0;k<coulum-1;k++){
                    a=s.nextInt();                    
                    if(a==b){
                        if(b==0){
                            b=1;
                            Node anode=new Node(k);
                            current.setNext(anode);
                            current=current.Next();
                            
                        }
                        else{
                            Node anode=new Node(k-1);
                            current.setNext(anode);
                            current=current.Next();                            
                            b=0;
                        }
                    }
                }
                a=s.nextInt();
                if(b==0){
                    if(a==b){
                        Node anode=new Node(coulum-1);
                        current.setNext(anode);
                        current=current.Next();
                        Node anode2=new Node(coulum-1);
                        current.setNext(anode2);
                        current=current.Next();                           
                    }
                }
                else{
                    
                    if(a==0){
                        
                        Node anode=new Node(coulum-1);
                        current.setNext(anode);
                        current=current.Next();                           
                    }
                    else{
                        Node anode=new Node(coulum-2);
                        current.setNext(anode);
                        current=current.Next();                            
                    }
                    
                }
                
                Node anode2=new Node(-1,null);
                current.setNext(anode2);
                ar[i]=ar[i].Next();
            }   
        }
        catch(IOException e){
            e.getMessage();
        }
	}

    public LinkedListImage(Node[] aray,int b){
        row=aray.length;
        coulum=b;
        Object ab=-1;
        Node[] ar2=new Node[aray.length];
        for(int i=0;i<aray.length;i++){
            Node currentI=aray[i];
            Node anode=new Node(0);
            ar2[i]=anode;
            Node currentO=ar2[i];
            while(currentI.Element()!=ab){
                Object a=currentI.Element();
                Node anode2=new Node(a);
                currentO.setNext(anode2);
                currentO=currentO.Next();
                currentI=currentI.Next();
            }
	            Node anode3=new Node(-1);
	            currentO.setNext(anode3);
	            ar2[i]=ar2[i].Next();
        }
        ar=ar2;
    }

    public LinkedListImage(boolean[][] grid, int width, int height)
    {
            row=height;
            coulum=width;
            ar=new Node[row];
            boolean a,b;
            for(int i=0;i<row;i++){
                Node node2=new Node(0);
                ar[i]=node2;
                Node current=ar[i];
                b=false;
                for(int k=0;k<coulum-1;k++){
                    a=grid[i][k];
                    if(a==b){
                        if(b==false){
                            b=true;
                            Node anode=new Node(k);
                            
                            current.setNext(anode);
                            current=current.Next();
                        }
                        else{
                            Node anode=new Node(k-1);                            
                            current.setNext(anode);
                            current=current.Next();
                            b=false;
                        }
                    }
                }
                a=grid[i][coulum-1]; 
                if(b==false){
                    if(a==b){
                        Node anode=new Node(coulum-1);
                        current.setNext(anode);
                        current=current.Next();
                        Node anode2=new Node(coulum-1);
                        current.setNext(anode2);
                        current=current.Next();
                           
                    }
                }
                else{
                    if(a==false){
                        
                        Node anode=new Node(coulum-1);
                        current.setNext(anode);
                        current=current.Next();
                       
                    }
                    else{
                        Node anode=new Node(coulum-2);
                        current.setNext(anode);
                        current=current.Next();                            
                        
                    }
                }    
                Node anode2=new Node(-1,null);
                current.setNext(anode2);
                ar[i]=ar[i].Next();
            }   
        
    }

    public boolean getPixelValue(int x, int y) throws PixelOutOfBoundException
    {
    	if(x>row-1 || y>coulum-1 || x<0 || y<0)
    	{
    		throw new PixelOutOfBoundException("");
    	}
    	else{
			Object ab=-1;
	        Node find=ar[x];
	        while(find.Element()!=ab){
	            Object value1=find.Element();
	            Object value2=find.Next().Element();
	            if((int)value1>y){
	                return true;
	            }
	            else if(y>=(int)value1 && y<=(int)value2){
	                return false;
	            }
	            else{
	                find=find.Next().Next();
	            }
	        }
	        return true;
    	}
    }

     public void setPixelValue(int x, int y, boolean val)  throws PixelOutOfBoundException
    {
    	if(x>row-1 || y>coulum-1 || x<0 || y<0)
    	{
    		throw new PixelOutOfBoundException("");
    	}
    	else{
      
	        Object ab=-1;
	        Node current=ar[x];
	        Node set=ar[x];
	        if(current.Element()==ab){
	            if(val==false){
	                ar[x]=new Node(y,ar[x]);
	                ar[x]=new Node(y,ar[x]);
	            }
	            return;
	        }
	        else{
	            Object value1=current.Element();
	            Object value2=current.Next().Element();
	            if((int)value1>y){
	                if(val==false){
	                    if(y==(int)value1-1){
	                        current.setElement((Object)y);                      
	                    }                    
	                    else{
	                        ar[x]=new Node(y,ar[x]);
	                        ar[x]=new Node(y,ar[x]);                       
	                    }
	                    return;
	                }               
	            }
	            else if(y>=(int)value1 && y<=(int)value2){                
	                if(val==true){                    
	                    if(y==(int)value1){current.setElement((Object)(y+1));
	                    }
	                    else if(y==(int)value2){current.Next().setElement((Object)(y-1));}
	                    else{
	                    Node anode1=new Node(y-1);                   
	                    Node anode2=new Node(y+1);                  
	                    anode1.setNext(anode2);
	                    anode2.setNext(current.Next());
	                    current.setNext(anode1);                   
	                    }
	                }
	                return;
	                
	            }
	            else if(y==(int)value2+1){
	               if(val==false){                    
	                        if(y+1==(int)(current.Next().Next().Element())){
	                            current.setNext(current.Next().Next().Next());                             
	                        }
	                        else{                       
	                            current.Next().setElement((Object)y);                                                        
	                        }                       
	                } 
	               	 return;
	            }            
	            set=current.Next();
	            current=current.Next().Next();                         
	        }    
	        while(current.Element()!=ab){
	            Object value1=current.Element();
	            Object value2=current.Next().Element();
	            if((int)value1>y){
	                if(val==false){                    
	                    if(y==(int)value1-1){                    	
	                        current.setElement((Object)y);
	                        break;
	                    }
	                    else{                       
	                        Node anode1=new Node(y); 
	                        Node anode2=new Node(y);
	                        anode1.setNext(anode2);
	                        anode2.setNext(current);
	                        set.setNext(anode1);
	                         break;                       
	                    }
	                }
	                else{
	                    break; 
	                }
	            }
	            else if(y>=(int)value1 && y<=(int)value2){
	                if(val==true){
	                    if(y==(int)value1){
	                        current.setElement((Object)(y+1));
	                        break;
	                    }
	                    else if(y==(int)value2){
	                        current.Next().setElement((Object)(y-1));
	                         break;
	                     }
	                    else{
	                    Node anode1=new Node(y-1);                    
	                    Node anode2=new Node(y+1);                   
	                    anode1.setNext(anode2);
	                    anode2.setNext(current.Next());
	                    current.setNext(anode1);
	                     break;
	                    }
	                }
	                else{
	                     break;
	                }
	            }
	            else if(y==(int)value2+1){
	               if(val==false){
	                    if(y+1==(int)(current.Next().Next().Element())){
	                            current.setNext((current.Next().Next().Next()));
	                            break;
	                        }
	                    else{
	                       current.Next().setElement((Object)y);
	                        break;
	                    }
	                }
	                else{
	                    break;
	                } 
	            }
	            else{
	                set=current.Next();
	                current=current.Next().Next();                
	            }
	        }
	        Object value3=set.Element();
	        if(y>(int)value3+1 && current.Element()==ab){
	            if(val==false){
	                Node anode1=new Node(y);    
	                Node anode2=new Node(y);              
	                anode1.setNext(anode2);
	                anode2.setNext(current);
	                set.setNext(anode1);                
	            }          
	          } 
	    }       
    }


    public int[] numberOfBlackPixels(){
        Object ab=-1;
        int sum1,sum2;
        int[] nbp=new int[row];
        for(int i=0;i<row;i++){
            Node find=ar[i];            
            sum2=0;
            while(find.Element()!=ab){
                Object value1=find.Element();
                Object value2=find.Next().Element();                
                sum1=((int)value2)-((int)value1)+1;                
                sum2=sum1+sum2;
                find=find.Next().Next();                
            }
            nbp[i]=sum2;            
        }
        return nbp;
    }

    public void invert()
    {   
        Node[] ar2=new Node[row];
        Node node3=new Node(0);
        for(int i=0;i<row;i++){
            Node node1=ar[i];
            Object ab=-1;
            ar2[i]=node3;
            Node current=ar2[i];
            if(node1.Element()!=ab){
                if((int)node1.Element()==0 && (int)node1.Next().Element()!=(coulum-1)){
                            Object a=(int)(node1.Next().Element())+1;
                            Node anode1=new Node(a);
                            current.setNext(anode1);
                            current=current.Next();
                            node1=node1.Next().Next();
                }
                else if((int)node1.Element()==0 && (int)node1.Next().Element()==(coulum-1)){}
                else{
                            Object a=(int)(node1.Element())-1;
                            Node anode1=new Node(0);
                            current.setNext(anode1);
                            current=current.Next();
                            Node anode2=new Node(a);
                            current.setNext(anode2);
                            current=current.Next();
                            if((int)node1.Next().Element()==(coulum-1)){
                               node1=node1.Next().Next();
                            }
                            else{
                                Object a2=(int)(node1.Next().Element())+1;
                                Node anode3=new Node(a2);
                                current.setNext(anode3);
                                current=current.Next();
                                if(node1.Next().Next().Element()==ab){
                                    Node anode4=new Node(coulum-1);
                                    current.setNext(anode4);
                                    current=current.Next();
                                }
                                node1=node1.Next().Next();
                            }
                }
                while(node1.Element()!=ab){
                            Object a=(int)(node1.Element())-1;
                            Node anode1=new Node(a);
                            current.setNext(anode1);
                            current=current.Next();
                            // if(node1.Next().Element()==(Object)(coulum-1)){
                            if((int)node1.Next().Element()==(coulum-1)){                               
                               node1=node1.Next().Next();                               
                            }
                            else{                               
                                Object a2=(int)(node1.Next().Element())+1;
                                Node anode2=new Node(a2);
                                current.setNext(anode2);
                                current=current.Next();
                                if(node1.Next().Next().Element()==ab){
                                    Node anode3=new Node(coulum-1);
                                    current.setNext(anode3);
                                    current=current.Next();
                                }
                                node1=node1.Next().Next();
                            }                           
                }
            }
            else{
                Node anode1=new Node(0);
                current.setNext(anode1);
                current=current.Next();
                Node anode2=new Node(coulum-1);
                current.setNext(anode2);
                current=current.Next();
            }
                Node anode4=new Node(-1);
                current.setNext(anode4);
                current=current.Next();
                ar2[i]=ar2[i].Next();
        }
        ar=ar2; 
    }

    
    
        
    
    
    public void performAnd(CompressedImageInterface img) throws BoundsMismatchException
    {   
    	LinkedListImage imgt=(LinkedListImage)img;
        if(row!=imgt.row && coulum!=imgt.coulum){
        	throw new BoundsMismatchException("");
        }
        else{

	        img.invert();
	        this.invert();
	        this.performOr(img);       
	        this.invert();
	        img.invert();
	    }
    }
    
    public void performOr(CompressedImageInterface img) throws BoundsMismatchException
    {   
        LinkedListImage imgt=(LinkedListImage)img;
        if(row!=imgt.row && coulum!=imgt.coulum){
        	throw new BoundsMismatchException("");
        }
        else{        
	        for(int i=0;i<row;i++){
	        Object ab=-1;
	        Node current=ar[i];       
	        Node compare=(imgt.ar[i]);        
	            while(current.Element()!=ab){
	                Object value1=current.Element();
	                Object value2=current.Next().Element();
	                Object value3=compare.Element();
	                if(value3==ab){
	                    current.setElement(-1);
	                    current.setNext(null);                    
	                }
	                else{
	                    Object value4=compare.Next().Element();
	                    if((int)value3<=(int)value1 && (int)value1<=(int)value4){
	                        if((int)value1==(int)value3 && (int)value2==(int)value4){
	                             compare=compare.Next().Next();
	                             current=current.Next().Next();
	                        }
	                        else{
	                            if((int)value4<=(int)value2){
	                                Object value5=compare.Next().Next().Element();
	                                 if((int)value5!=-1 && (int)value5<=(int)value2){
	                                    Node anode1=new Node(value4);
	                                    Node anode2=new Node(value5);
	                                    anode1.setNext(anode2);  
	                                    anode2.setNext(current.Next());
	                                    current.setNext(anode1);
	                                    current=current.Next().Next();
	                                    compare=compare.Next().Next();                                   
	                                 }
	                                 else{
	                                    current.Next().setElement(value4);
	                                    compare=compare.Next().Next();
	                                    current=current.Next().Next();
	                                    }
	                            }
	                            else{
	                                current=current.Next().Next();
	                            }
	                        }
	                    }
	                    else if((int)value3>(int)value1 && (int)value2>(int)value3){
	                        current.setElement(value3);
	                        if((int)value4<(int)value2){
	                            Object value5=compare.Next().Next().Element();
	                            if((int)value5!=-1 && (int)value5<=(int)value2){
	                                    Node anode1=new Node(value4);
	                                    Node anode2=new Node(value5);
	                                    anode1.setNext(anode2);
	                                    anode2.setNext(current.Next());
	                                    current.setNext(anode1);
	                                    compare=compare.Next().Next();
	                                    current=current.Next().Next();                                   
	                            }
	                            else{
	                                current.Next().setElement(value4);
	                                compare=compare.Next().Next();
	                                current=current.Next().Next();                              
	                            }
	                        }
	                        else if((int)value4==(int)value2){
	                            compare=compare.Next().Next();
	                            current=current.Next().Next();
	                        }
	                        else{
	                            current=current.Next().Next();
	                        }
	                    }
	                    else if((int)value3>=(int)value2){
	                        if((int)value3==(int)value2){
	                            current.setElement(value2);
	                            current=current.Next().Next();                           
	                        }
	                        else{                            
	                        current.setElement(current.Next().Next().Element());
	                        current.setNext(current.Next().Next().Next());                                                
	                        current=current;                       
	                        }
	                    }
	                    else if((int)value1>=(int)value4){
	                        Object value5=compare.Next().Next().Element();
	                        if((int)value1==(int)value4){
	                            if((int)value5==-1){
	                                    current.Next().setElement(value4);   
	                                    Node anode3=new Node(-1);
	                                    current.Next().Next().setNext(anode3);
	                                    current= current.Next().Next();                                
	                            }
	                            else{                            
	                                if((int)value2==(int)value5){
	                                    Node anode1=new Node(value1);
	                                    Node anode2=new Node(value2);
	                                    anode1.setNext(anode2);
	                                    anode2.setNext(current.Next());
	                                    current.setNext(anode1);
	                                    current=current.Next().Next();
	                                    compare=compare.Next().Next();                                
	                                }
	                                else if((int)value2>(int)value5){
	                                    Node anode1=new Node(value1);
	                                    Node anode2=new Node(value5);
	                                    anode1.setNext(anode2);
	                                    anode2.setNext(current.Next());
	                                    current.setNext(anode1);
	                                    current=current.Next().Next();
	                                    compare=compare.Next().Next();                                 
	                                }
	                                else{
	                                    current.Next().setElement(value1);
	                                    current=current.Next().Next();
	                                    compare=compare.Next().Next();                                   
	                                }
	                            }    
	                        }
	                        else{
	                            compare=compare.Next().Next();
	                        }                        
	                    }
	                    else{
	                        current=current.Next().Next();
	                    }
	                }
	            }  
	        }
	   	}
        
    }
    
    public void performXor(CompressedImageInterface img) throws BoundsMismatchException
    {  
    	LinkedListImage imgt=(LinkedListImage)img;
        if(row!=imgt.row && coulum!=imgt.coulum){
        	throw new BoundsMismatchException("");
        }
        else{
	    	LinkedListImage img1=(LinkedListImage)img;
		   LinkedListImage impg=new LinkedListImage(ar,coulum);
	       LinkedListImage imgi=new LinkedListImage(img1.ar,img1.coulum);
	       this.invert();
	       this.performOr(img1);
	       this.invert();
	       imgi.invert();
	       impg.performOr(imgi);
	       impg.invert();
	       this.performOr(impg);
	   }
    }
    
    public String toStringUnCompressed()
    {
		Object ab=-1,a,b,c,d,e;
		StringBuilder str = new StringBuilder();
        str.append(row+" "+coulum);
        for(int i=0;i<row;i++){
            str.append(",");
            Node anode=ar[i];
            a=anode.Element();
            if(a==ab){
                for(int m=0;m<coulum;m++){
                     str.append(" "+"1");
                }
            }
            else{
                for(int j=0;j<(int)a;j++){
                str.append(" "+"1");
                }
            }
            while(anode.Element()!=ab){
                b=anode.Element();
                c=anode.Next().Element();
                for(int k=(int)b;k<(int)c+1;k++){
                    str.append(" "+"0");
                }
                if(anode.Next().Next().Element()!=ab){
                    d=anode.Next().Next().Element();
                    for(int l=(int)c+1;l<(int)d;l++){
                        str.append(" "+"1");
                    } 
                }
                else{
                    for(int l=(int)c+1;l<row;l++){
                        str.append(" "+"1");
                    }
                }
                anode=anode.Next().Next();
            }
        }

        return str.toString();
    }
    
    public String toStringCompressed()
    {
		Object ab=-1;        
  		StringBuilder str = new StringBuilder();
        str.append(row+" "+coulum);
        for(int i=0;i<row;i++){
            str.append(","+" ");	
            Node anode=ar[i];
            
            while(anode.Element()!=ab){
                Object a=anode.Element();
                str.append(a+" ");
                anode=anode.Next();
            }
           str.append("-1");
            
        }
        
        return str.toString();
    }

    public static void main(String[] args) {
    	// testing all methods here :
    	boolean success = true;

    	// check constructor from file
    	CompressedImageInterface img1 = new LinkedListImage("sampleInputFile.txt");

    	// check toStringCompressed
    	String img1_compressed = img1.toStringCompressed();
    	String img_ans = "16 16, -1, 5 7 -1, 3 7 -1, 2 7 -1, 2 2 6 7 -1, 6 7 -1, 6 7 -1, 4 6 -1, 2 4 -1, 2 3 14 15 -1, 2 2 13 15 -1, 11 13 -1, 11 12 -1, 10 11 -1, 9 10 -1, 7 9 -1";
    	success = success && (img_ans.equals(img1_compressed));

    	if (!success)
    	{
    		System.out.println("Constructor (file) or toStringCompressed ERROR");
    		return;
    	}

    	// check getPixelValue
    	boolean[][] grid = new boolean[16][16];
    	for (int i = 0; i < 16; i++)
    		for (int j = 0; j < 16; j++)
    		{
                try
                {
        			grid[i][j] = img1.getPixelValue(i, j);                
                }
                catch (PixelOutOfBoundException e)
                {
                    System.out.println("Errorrrrrrrr");
                }
    		}

    	// check constructor from grid
    	CompressedImageInterface img2 = new LinkedListImage(grid, 16, 16);
    	String img2_compressed = img2.toStringCompressed();
    	success = success && (img2_compressed.equals(img_ans));
        
    	if (!success)
    	{
    		System.out.println("Constructor (array) or toStringCompressed ERROR");
    		return;
    	}

    	// check Xor
        
        try
        {
        	img1.performXor(img2);       
        }
        catch (BoundsMismatchException e)
        {
            System.out.println("Errorrrrrrrr");
        }
    	for (int i = 0; i < 16; i++)
    		for (int j = 0; j < 16; j++)
    		{
                try
                {
        			success = success && (!img1.getPixelValue(i,j));                
                }
                catch (PixelOutOfBoundException e)
                {
                    System.out.println("Errorrrrrrrr");
                }
    		}

    	if (!success)
    	{
    		System.out.println("performXor or getPixelValue ERROR");
    		return;
    	}

    	// check setPixelValue
    	for (int i = 0; i < 16; i++)
        {
            try
            {
    	    	img1.setPixelValue(i, 0, true);            
            }
            catch (PixelOutOfBoundException e)
            {
                System.out.println("Errorrrrrrrr");
            }
        }

    	// check numberOfBlackPixels
    	int[] img1_black = img1.numberOfBlackPixels();
    	success = success && (img1_black.length == 16);
    	for (int i = 0; i < 16 && success; i++)
    		success = success && (img1_black[i] == 15);
    	if (!success)
    	{
    		System.out.println("setPixelValue or numberOfBlackPixels ERROR");
    		return;
    	}

    	// check invert
        

        img1.invert();
        for (int i = 0; i < 16; i++)
        {
            try
            {
                success = success && !(img1.getPixelValue(i, 0));            
            }
            catch (PixelOutOfBoundException e)
            {
                System.out.println("Errorrrrrrrr");
            }
        }
        if (!success)
        {
            System.out.println("invert or getPixelValue ERROR");
            return;
        }

    	// check Or
        
        try
        {   
            img1.performOr(img2);
            
                  
        }
        catch (BoundsMismatchException e)
        {
            System.out.println("Errorrrrrrrr");
        }
       
        if (!success)
        {
            System.out.println("performOr or getPixelValue ERROR");
            return;
        }

        // check And
       
        try
        {
            img1.performAnd(img2); 
           
        }
        catch (BoundsMismatchException e)
        {
            System.out.println("Errorrrrrrrr");
        }
        for (int i = 0; i < 16; i++)
            for (int j = 0; j < 16; j++)
            {
                try
                {
                    success = success && (img1.getPixelValue(i,j) == img2.getPixelValue(i,j));             
                }
                catch (PixelOutOfBoundException e)
                {
                    System.out.println("Errorrrrrrrr");
                }
            }
        if (!success)
        {
            System.out.println("performAnd or getPixelValue ERROR");
            return;
        }
      
    	// check toStringUnCompressed
        String img_ans_uncomp = "16 16, 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1, 1 1 1 1 1 0 0 0 1 1 1 1 1 1 1 1, 1 1 1 0 0 0 0 0 1 1 1 1 1 1 1 1, 1 1 0 0 0 0 0 0 1 1 1 1 1 1 1 1, 1 1 0 1 1 1 0 0 1 1 1 1 1 1 1 1, 1 1 1 1 1 1 0 0 1 1 1 1 1 1 1 1, 1 1 1 1 1 1 0 0 1 1 1 1 1 1 1 1, 1 1 1 1 0 0 0 1 1 1 1 1 1 1 1 1, 1 1 0 0 0 1 1 1 1 1 1 1 1 1 1 1, 1 1 0 0 1 1 1 1 1 1 1 1 1 1 0 0, 1 1 0 1 1 1 1 1 1 1 1 1 1 0 0 0, 1 1 1 1 1 1 1 1 1 1 1 0 0 0 1 1, 1 1 1 1 1 1 1 1 1 1 1 0 0 1 1 1, 1 1 1 1 1 1 1 1 1 1 0 0 1 1 1 1, 1 1 1 1 1 1 1 1 1 0 0 1 1 1 1 1, 1 1 1 1 1 1 1 0 0 0 1 1 1 1 1 1";
        success = success && (img1.toStringUnCompressed().equals(img_ans_uncomp)) && (img2.toStringUnCompressed().equals(img_ans_uncomp));

        if (!success)
        {
            System.out.println("toStringUnCompressed ERROR");
            return;
        }
        else
            System.out.println("ALL TESTS SUCCESSFUL! YAYY!");
    }
}