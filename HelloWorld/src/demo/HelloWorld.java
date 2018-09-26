package demo;

// Fully Qualified Classname = demo.HelloWorld
public class HelloWorld {
	public static void main(String args[]) {
		// Double forward slash - comment
		// until end of line
		//System.out.println(args.length);
		
		/* Prints Hello and first arg entry
			still commented out
		*/
		System.out.println("Hello, " + args[0]);
	}
}


/* javac -d bin src/demo/HelloWorld.java
	java -cp bin demo.HelloWorld Denzel */