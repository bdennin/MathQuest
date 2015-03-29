package MathQuest.Logic;

import java.util.Vector;

public class DropdownElement {
	
        private int value;
        private String text;
        public DropdownElement(int id, String description)
        {
            this.value = id;
            this.text = description;
        }
 
        public int getId()
        {
            return this.value;
        }
 
        public String getDescription()
        {
            return this.text;
        }
 
        public String toString()
        {
            return this.text;
        }
        
        public static Vector generateNumbers(int length){
        	Vector list = new Vector();
        	for (int index = 1; index <= length; index++){
        		DropdownElement element = new DropdownElement(index-1, Integer.toString(index));
        		list.add(element);
        	}
        	return list;
        }
}
