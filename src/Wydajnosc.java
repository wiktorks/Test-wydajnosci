import java.util.*;
import java.lang.Math;


class Pomiar
{
	String name;
	double add[];
	double remove[];
	double contains[];
	double srednia[];
	double odchylenie[];
	
	Pomiar(String name)
	{
		add = new double[10];
		remove = new double[10];
		contains = new double[10];
		srednia = new double[3];
		odchylenie = new double[3];
		this.name = name;
	}
	
	void setAll()
	{
		for(int i=1; i<10; i++)
		{
			srednia[0] += add[i];
			srednia[1] += remove[i];
			srednia[2] += contains[i];
		}
		for(int i=0; i<3; i++)
		{
			srednia[i] = srednia[i]/(10.0);
		}
		double wariancja[] = new double[3];
		for(int i=1; i<10; i++)
		{
				wariancja[0] += (add[i]-srednia[0])*(add[i]-srednia[0]);
				wariancja[1] += Math.pow(remove[i]-srednia[1], 2.0);
				wariancja[2] += Math.pow(contains[i]-srednia[2], 2.0);
		}
		for(int i=0; i<3; i++)
		{
			wariancja[i] = wariancja[i]*0.1;
			odchylenie[i] = Math.sqrt(wariancja[i]);
		}
	}
	
	void printAll()
	{
		System.out.println(this.name + " " +
				this.srednia[0] + " +/- " + this.odchylenie[0] + " " +
				this.srednia[1] + " +/- " + this.odchylenie[1] + " " +
				this.srednia[2] + " +/- " + this.odchylenie[2]);
	}
}

public class Wydajnosc 
{

	public static void main(String[] args) 
	{
		ArrayList<Integer> AList = new ArrayList<Integer>();
		HashSet<Integer> Hset = new HashSet<Integer>();
		LinkedList<Integer> LList = new LinkedList<Integer>();
		Stack<Integer> STack = new Stack<Integer>();
		Vector<Integer> Vector = new Vector<Integer>(10);
		PriorityQueue<Integer> PQueue = new PriorityQueue<Integer>();
		TreeSet<Integer> TSet = new TreeSet<Integer>();
		
		
		Pomiar alist = new Pomiar("ArrayList");
		Pomiar hset = new Pomiar("HashSet");
		Pomiar llist = new Pomiar("LinkedList");
		Pomiar stack = new Pomiar("Stack");
		Pomiar vector = new Pomiar("Vector");
		Pomiar pqueue = new Pomiar("PriorityQueue");
		Pomiar tset = new Pomiar("TreeSet");
		
		long startTime;
		long elapsedTime;
		
		for(int i=0; i<10; i++)//Pomiar metody add()
		{
			startTime = System.nanoTime();
			AList.add(i);
			elapsedTime = System.nanoTime() - startTime;
			alist.add[i] = (double)elapsedTime;
			
			startTime = System.nanoTime();
			Hset.add(i);
			elapsedTime = System.nanoTime() - startTime;
			hset.add[i] = (double)elapsedTime;
			
			startTime = System.nanoTime();
			LList.add(i);
			elapsedTime = System.nanoTime() - startTime;
			llist.add[i] = (double)elapsedTime;
			
			startTime = System.nanoTime();
			STack.add(i);
			elapsedTime = System.nanoTime() - startTime;
			stack.add[i] = (double)elapsedTime;
			
			startTime = System.nanoTime();
			Vector.add(i, i);
			elapsedTime = System.nanoTime() - startTime;
			vector.add[i] = (double)elapsedTime;
			
			startTime = System.nanoTime();
			PQueue.add(i);
			elapsedTime = System.nanoTime() - startTime;
			pqueue.add[i] = (double)elapsedTime;
			
			startTime = System.nanoTime();
			TSet.add(i);
			elapsedTime = System.nanoTime() - startTime;
			tset.add[i] = (double)elapsedTime;
		}
		for(int i=0; i<10; i++)//Pomiar metody contains()
		{
			startTime = System.nanoTime();
			AList.contains(i+5); //Sprawdzam czas dla znaleznych i nieznaleznych
			elapsedTime = System.nanoTime() - startTime;
			alist.contains[i] = (double)elapsedTime;
			
			startTime = System.nanoTime();
			Hset.contains(i+5); //Sprawdzam czas dla znaleznych i nieznaleznych
			elapsedTime = System.nanoTime() - startTime;
			hset.contains[i] = (double)elapsedTime;
			
			startTime = System.nanoTime();
			LList.contains(i+5); //Sprawdzam czas dla znaleznych i nieznaleznych
			elapsedTime = System.nanoTime() - startTime;
			llist.contains[i] = (double)elapsedTime;
			
			startTime = System.nanoTime();
			STack.contains(i+5); //Sprawdzam czas dla znaleznych i nieznaleznych
			elapsedTime = System.nanoTime() - startTime;
			stack.contains[i] = (double)elapsedTime;
			
			startTime = System.nanoTime();
			Vector.contains(i+5); //Sprawdzam czas dla znaleznych i nieznaleznych
			elapsedTime = System.nanoTime() - startTime;
			vector.contains[i] = (double)elapsedTime;
			
			startTime = System.nanoTime();
			PQueue.contains(i+5); //Sprawdzam czas dla znaleznych i nieznaleznych
			elapsedTime = System.nanoTime() - startTime;
			pqueue.contains[i] = (double)elapsedTime;
			
			startTime = System.nanoTime();
			TSet.contains(i+5); //Sprawdzam czas dla znaleznych i nieznaleznych
			elapsedTime = System.nanoTime() - startTime;
			tset.contains[i] = (double)elapsedTime;
		}
		int k = 9; //usuwam od konca
		for(int i=0; i<10; i++) //Pomiar metody remove()
		{
			startTime = System.nanoTime();
			AList.remove(k);
			elapsedTime = System.nanoTime() - startTime;
			alist.remove[i] = (double)elapsedTime;
			
			startTime = System.nanoTime();
			Hset.remove(k);
			elapsedTime = System.nanoTime() - startTime;
			hset.remove[i] = (double)elapsedTime;
			
			startTime = System.nanoTime();
			LList.remove(k);
			elapsedTime = System.nanoTime() - startTime;
			llist.remove[i] = (double)elapsedTime;
			
			startTime = System.nanoTime();
			STack.remove(k);
			elapsedTime = System.nanoTime() - startTime;
			stack.remove[i] = (double)elapsedTime;
			
			startTime = System.nanoTime();
			Vector.remove(k);
			elapsedTime = System.nanoTime() - startTime;
			vector.remove[i] = (double)elapsedTime;
			
			startTime = System.nanoTime();
			PQueue.remove(k);
			elapsedTime = System.nanoTime() - startTime;
			pqueue.remove[i] = (double)elapsedTime;
			
			startTime = System.nanoTime();
			TSet.remove(k);
			elapsedTime = System.nanoTime() - startTime;
			tset.remove[i] = (double)elapsedTime;
			k--;
		}
		alist.setAll();
		hset.setAll();
		llist.setAll();
		stack.setAll();
		vector.setAll();
		pqueue.setAll();
		tset.setAll();
		
		alist.printAll();
		hset.printAll();
		llist.printAll();
		stack.printAll();
		vector.printAll();
		pqueue.printAll();
		tset.printAll();
	}

}
