package InNOut;

import java.util.Random;

public class InNOut 
{
	
	   private static class Food
	   {
	       private String FoodItem;
	       private int expirationDate;
       
	       Food(String FoodItem, int expirationDate)
	       {
		      this.FoodItem = FoodItem;
		      this.expirationDate = expirationDate;
	       }
	       private void setFood(int exp)
	       {
		      expirationDate = exp;
	       }
	       public String toString()
	       {
	    	   String item = FoodItem;
		      return item;
	       }
	       private int number()
	       {
		      return expirationDate;
	       } 
	
	   }
	   
	   public static int[] sorting(int[] arr)
	   {
			for(int i = 1; i < arr.length; i++)
			{
				for(int j = i; j >  0; j--)
				{
					if(arr[j]< arr[j-1])
					{
						int t = arr[j -1];
						arr[j-1] = arr[j];
						arr[j] = t;
					}
				}
			
			}
			return arr;
		}
	
	   
	   public static int lostCustomer(LinkedQueue<Integer> customers)
	   {
		   int lostCustomers = 0;
		   if(!customers.isEmpty())
		   {
			   customers.dequeue();
			   lostCustomers++;
		   }
			   return lostCustomers;
	   }
	   
	   public static void refill(LinkedQueue<Integer> customer)
	   {
		   Random r = new Random();
		   int order = r.nextInt(6) + 1;
		   int rCustomer = r.nextInt(100) + 1;
		   
		   for(int i = 1; i <= rCustomer; i++)
		   {
			   customer.enqueue(order);
			   order = r.nextInt(6) + 1;
		 
		   }
	   }
	   
	   public static void Restock(LinkedStack<Food> cheese, LinkedStack<Food> bun, 
			   LinkedStack<Food> patty,  LinkedStack<Food> lettuce, LinkedStack<Food> tomato, LinkedStack<Food> onion)
	   {
		   Random r = new Random();
		   int rand = r.nextInt(301) + 700;

		      for(int i = 1; i <= rand; i++)
		      {
		    	  cheese.push(new Food("cheese",2));
		      }
		      
		          rand = r.nextInt(301) + 700;
		      
		      for(int i = 1; i <= rand; i++)
		      {
		    	  bun.push(new Food("bun",5));
		      }
		      	rand = r.nextInt(301) + 700;
		      
		      for(int i = 1; i <= rand; i++)
		      {
		    	  patty.push(new Food("patty", 4));    
		      }
		      	rand = r.nextInt(301) + 700;
		      
		      for(int i = 1; i <= rand; i++)
		      {
		    	  lettuce.push(new Food("lettuce", 3));    
		      }
		      	rand = r.nextInt(301) + 700;
		      
		      for(int i = 1; i <= rand; i++)
		      {
		    	  tomato.push(new Food("tomato",3));    
		      }
		      	  rand = r.nextInt(301) + 700;
		      
		      for(int i = 1; i <= rand; i++)
		      {
		    	  onion.push(new Food ("onion",5));    
		      }
		 
	   }
	   
	   public static int expire(LinkedStack<Food> item)
	   {
		   Object[]stack1 = (Object[])item.toArray();
		   Object[]stack2 = new Object[stack1.length];
		   
		   for(int i = 0; i < stack1.length; i++)
		   {
			   Food elements = (Food)stack1[i];
			   elements.expirationDate = elements.expirationDate - 1;
			   stack2[i] = elements;
			   item.pop();
			   
		   }
		   
		   for(int i = 0; i < stack1.length; i++)
		   {
			   Food element2 = (Food)stack2[i];
			   if(element2.expirationDate != 0)
				   item.push((Food)stack2[i]);
		   }
		   Object[] x = (Object[])item.toArray();
		   return(stack1.length - x.length);
	   }
	   
	   public static void hours(LinkedList<String> orderNumber, LinkedStack<Food> cheese,LinkedStack<Food> bun,
			   LinkedStack<Food> patty, LinkedStack<Food> lettuce,LinkedStack<Food> tomato,LinkedStack<Food> onion )
	   {
			   Object[] Stack1 = (Object[])orderNumber.toArray();
			   String[] s = new String[Stack1.length];
			   
			   for(int i = 0; i < Stack1.length; i++)
			   {
				   s[i] =(String) Stack1[i];
			   
			   		if(s[i] == "cheese")
			   		{
			            cheese.pop();
			        }
			        else if(s[i] == "bun")
			        {
			            bun.pop();
			        }
			        else if(s[i] == "patty")
			        {
			            patty.pop();
			        }
			        else if(s[i] == "lettuce")
			        {
			            
			        if(!lettuce.isEmpty())
			            
			        	lettuce.pop();
			        }
			        else if(s[i] == "tomato")
			        {
			            tomato.pop();
			        }
			        else if(s[i]== "onion")
			        {
			            onion.pop();
			        }
			   
			   }
			   
	   }
	   
	   
	   public static void main(String[] args)
	   {
		   
		   int customerDayLost = 0, wasteCheese = 0, wasteBun = 0, wastePatty = 0, wasteOnion = 0,wasteLettuce = 0, wasteTomato = 0 ; 
		   int countItem = 0, countItemTwo = 0, countItemThree = 0, countItemFour = 0, countItemFive = 0, countItemSix = 0;
				   
	      Random random = new Random();
	      int rand = random.nextInt(301) + 700;
		
          LinkedList<String> burger = new LinkedList<String>();
          LinkedList<String> cheeseBurger = new LinkedList<String>();

          LinkedList<String> veganBurger = new LinkedList<String>();
          LinkedList<String> burgerNoOnion = new LinkedList<String>();
          LinkedList<String> cheeseBurgerNoOnion= new LinkedList<String>();
          LinkedList<String> burgerNoTomato= new LinkedList<String>();
       
          LinkedStack<Food> cheese = new LinkedStack<Food>();
          LinkedStack<Food> bun = new LinkedStack<Food>();
          LinkedStack<Food> patty = new LinkedStack<Food>();
          LinkedStack<Food> lettuce = new LinkedStack<Food>();
          LinkedStack<Food> tomato = new LinkedStack<Food>();
          LinkedStack<Food> onion = new LinkedStack<Food>();
       
          Restock(cheese, bun, patty, lettuce, tomato, onion);  
          
          LinkedQueue<Integer> customer = new LinkedQueue<Integer>(); 
          refill(customer);
          
          burger.add("Bun");
          burger.add("Patty");
          burger.add("Lettuce");
          burger.add("Tomato");
          burger.add("Onion");

          cheeseBurger.add("Cheese");
          cheeseBurger.add("Bun");
          cheeseBurger.add("Patty");
          cheeseBurger.add("Lettuce");
          cheeseBurger.add("Tomato");
          cheeseBurger.add("Onion");

          veganBurger.add("Lettuce");
          veganBurger.add("Lettuce");
          veganBurger.add("Tomato");
          veganBurger.add("Onion");

          burgerNoOnion.add("Bun");
          burgerNoOnion.add("Patty");
          burgerNoOnion.add("Lettuce");
          burgerNoOnion.add("Tomato");

          cheeseBurgerNoOnion.add("Cheese");
          cheeseBurgerNoOnion.add("Bun");
          cheeseBurgerNoOnion.add("Patty");
          cheeseBurgerNoOnion.add("Lettuce");
          cheeseBurgerNoOnion.add("Onion");

          burgerNoTomato.add("Bun");
          burgerNoTomato.add("Patty");
          burgerNoTomato.add("Lettuce");
          burgerNoTomato.add("Onion");
          
          

          for(int i = 0; i < 31 ; i++)
          {
              
          
               wastePatty = 0; wasteOnion = 0;wasteLettuce = 0; wasteTomato = 0 ; 
               countItem =0; countItemTwo = 0; countItemThree = 0; countItemFour = 0;
               countItemFive = 0; countItemSix = 0; customerDayLost = 0;
           
                 if((i ) %3 == 0)
               Restock( cheese, bun, patty,lettuce, tomato, onion);
                 for(int j = 0; j < 12 ; j++)
                 {
               
                refill(customer);
                    for(int k = 0; k < 50; k++)
                    {
                   
                     if(!customer.isEmpty())
                     {
                   
                    if(customer.getFront() == 1)
                    {
                   
        if(!bun.isEmpty() && !patty.isEmpty() && !lettuce.isEmpty() && !tomato.isEmpty() && !onion.isEmpty())
        {
                  
            hours(burger,  cheese, bun, patty, lettuce, tomato,onion );
                  
            countItem++;
                   
        }
                    }
                    else if(customer.getFront() == 2)
                    {
                   
        if(!bun.isEmpty() && !patty.isEmpty() && !lettuce.isEmpty() && !tomato.isEmpty() && !onion.isEmpty() && !cheese.isEmpty())
        {
            hours(cheeseBurger,  cheese, bun, patty, lettuce, tomato,onion );
            countItemTwo++;
                   
        }
                    }
                    else if(customer.getFront() == 3)
                    {
                   
                    	if(!lettuce.isEmpty() && !tomato.isEmpty() && !onion.isEmpty())
                    	{

                    		hours(veganBurger,  cheese, bun, patty, lettuce, tomato,onion );
                    		countItemThree++;
                   
        }
                    }
                    else if(customer.getFront() == 4)
                    {
                   
                    	if(!bun.isEmpty() && !patty.isEmpty() && !lettuce.isEmpty() && !tomato.isEmpty())
                    	{

                    		hours(burgerNoOnion,  cheese, bun, patty, lettuce, tomato,onion );
                    		countItemFour++;
                   
                    	}
                    }
                    else if(customer.getFront() == 5)
                    {
                   
         
                   
        if(!bun.isEmpty() && !patty.isEmpty() && !lettuce.isEmpty() && !tomato.isEmpty() && !cheese.isEmpty())
        {
             hours(cheeseBurgerNoOnion,  cheese, bun, patty, lettuce, tomato,onion );
             countItemFive++;
                   
        }
                    }
                    else if(customer.getFront() == 6)
                    {
                   
        if(!bun.isEmpty() && !patty.isEmpty() && !lettuce.isEmpty()  && !onion.isEmpty())
        {
        	hours(burgerNoTomato,  cheese, bun, patty, lettuce, tomato,onion );
        	countItemSix++;                   
        }
                    }
                    else
                    {
                   
                    System.out.println("empty");
                    }
                    customer.dequeue();                   
                     }
                              
                    }
                   
                     customerDayLost = lostCustomer(customer) + customerDayLost;
     
                 }
               
                 if((i ) %2 == 0)
                 {
                	 wasteCheese = expire(cheese);
                 }
                 if((i ) %5 == 0)
                 {
                	 wasteBun = expire(bun);
                 }
                 if((i ) %4 == 0)
                 {
                	 wastePatty = expire(patty);
                 }
                 if((i ) %3 == 0)
                 {
                	 wasteLettuce = expire(lettuce);
                 }
                 if((i ) %3 == 0)
                 {
                	 wasteTomato = expire(tomato);
                 }
                 if((i ) %5 == 0)
                 {
                	 wasteOnion = expire(onion);
                 }
                 System.out.println("March " + (i +1) + " :");
                 System.out.println("Customers Lost : " + customerDayLost);
                 
                 System.out.println("Item wasted:" + "cheese:" + wasteCheese +" bun:" + wasteBun + " patty: " + wastePatty 
                 + " lettuce: " + wasteLettuce + " tomato: " + wasteTomato + " onion: " + wasteOnion);
                 
                 System.out.println("Successful Orders:" + "Item one:" + countItem + " Item Two:" + countItemTwo + " Item Three:" + countItemThree
                 + " Item Four:" + countItemFour + " Item Five:" + countItemFive + " Item Six:" + countItemSix );
                  
                 }
            
           }
        
}
