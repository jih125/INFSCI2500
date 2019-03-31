package edu.pitt.mypackage;

import java.util.Scanner;

public class Sequence<E>{
    protected Object[] data;
    protected int size;

    public Sequence(int n) throws IllegalArgumentException{
        if(n<0){
            throw new IllegalArgumentException();}
        this.data=new Object[n];
        this.size=0;
    }

    public int size(){
        return this.size;
    }

    public void append(E element){            
        if(this.size<this.data.length){
            this.data[this.size]=element;
        }
        else{
            Object[] temp=new Object[this.size+1];
            System.arraycopy(this.data, 0, temp, 0, this.size);
            this.data=temp;
            this.data[this.size]=element;
        }
        this.size++;    
    }

    public Object get(int k) throws IndexOutOfBoundsException{
            if(k<0 || k>=this.size){
                throw new IndexOutOfBoundsException();}
            return this.data[k];
    }

	public void print(){
		System.out.print("\nCurrent Sequence: ");
		for(int i=0;i<this.size();i++){
            System.out.print(this.get(i)+" ");
        }
		System.out.println();
	}
	
    public void insert(int insertPosition, E newValue) throws IndexOutOfBoundsException{
    	if(insertPosition < 0 || insertPosition >= this.size){
            throw new IndexOutOfBoundsException();
        }
        boolean insertMade = false;
        Object[] temp = new Object[this.size+1];
        for(int i = 0; i < this.size; i++){
            if(i == insertPosition && !insertMade){
                temp[i] = newValue;
                insertMade = true;
                i--;
            }   //Executed during the insertion.
            else if(i >= insertPosition && insertMade){
                temp[i+1] = this.data[i];
            } //Executed after the insertion.
            else{
                temp[i] = this.data[i];
            } //Executed before the insertion.
        }
        this.data = temp;
        this.size++;//IMPLEMENT ME
    }

	public void delete(int deletePosition)throws IndexOutOfBoundsException, IllegalArgumentException{
		if(this.size == 0){
            throw new IllegalArgumentException();
        }
        if(deletePosition < 0 || deletePosition >= this.size){
            throw new IndexOutOfBoundsException();
        }
        Object[] temp = new Object[this.size - 1];
        for(int i = 0; i <= temp.length; i++){
            if(i == deletePosition ){continue;} //Executed during the deletion.
            else if(i >= deletePosition){
                temp[i - 1] = this.data[i];
            } //Executed after the deletion.
            else{
                temp[i] = this.data[i];
            } //Executed before the deletion.
        }
        this.data = temp;
        this.size--;//IMPLEMENT ME
    }


	public static void main (String[] args){
		Scanner in = new Scanner(System.in);
		Sequence<Integer> s = new Sequence<Integer>(5);
		s.append(1);
		s.append(2);
		s.append(3);
		s.append(4);
		s.append(5);
//		s.print();
		
		//INSERT CONTROL LOOP HERE
		int index;
		int value;
		
		while(true) {
			try {
				s.print();
				System.out.println("Please enter 1 to insert, 2 to delete, or 3 to quit. ");
				int choice = in.nextInt();
		
				switch(choice) {
					case(1):{
						System.out.println("Please enter the value to insert.");
						value = in.nextInt();
						System.out.println("Please enter the index to insert.");
						index = in.nextInt();
						s.insert(index, value);
						continue;
					}
					case(2):{
						System.out.println("Please enter the index to delete.");
						index = in.nextInt();
						s.delete(index);
						continue;
					}
					case(3):{
						System.out.println("Goodbye");
						System.exit(0);
					}
					default:{
						System.out.println("Invalid choice");
						continue;
					}
				}
			}
			catch(IndexOutOfBoundsException e) {
				System.out.println("Index out of bounds.");
			}
			catch(IllegalArgumentException e) {
				System.out.println("No element left.");
			}
		}
    }   //End main
}   //End class
