package PayPal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PrintIndentedXML {

//Given an unindented xml, print the pretty format of it, example :	
//	input : <a><b><c></c></b></a>
//	output:
//<a>
//	<b>
//		<c>
//		</c>
//	</b>
//</a>
//	
	
	
	public static void main(String[] args) {
		
		List<Tag> inputList = new ArrayList<>();
		inputList.add(new Tag("a"));
		inputList.add(new Tag("b"));
		inputList.add(new Tag("c"));
		inputList.add(new Tag("</c>"));
		inputList.add(new Tag("d"));
		inputList.add(new Tag("</d>"));
		inputList.add(new Tag("</b>"));
		inputList.add(new Tag("</a>"));

		printIndentedXML(inputList);
		
	}

	private static void printIndentedXML(List<Tag> inputList) {
		
		if(inputList == null || inputList.size() == 0) {
			System.out.println("XML is null or blank");
			return;
		}	
		
		Stack<Tag> printStack = new Stack<>();
		List<Tag> result = new ArrayList<>();

		for(Tag check : inputList) {
			
			if(printStack.isEmpty()) {
				printStack.add(new Tag(inputList.get(0).name, 0));
				result.add(new Tag(inputList.get(0).name, 0));
			} else {
				Tag top = printStack.peek();
				
				if(top.getClosingTag().equals(check.name)) {
					result.add(new Tag(check.name, top.indentationLevel));
					printStack.pop();
					continue;
				} else {
					printStack.add(new Tag(check.name, top.indentationLevel+1));
					result.add(new Tag(check.name, top.indentationLevel+1));
				}
			}	
		}
		
		if(!printStack.isEmpty()) {
			System.out.println("XML is not well formed");
			return;
		}
		
		for( Tag t : result) {
			for(int i =0; i<t.indentationLevel; i++) {
				System.out.printf("\t");
			}
			System.out.println(t.name);
		}
	}
}


class Tag {
	String name;
	int indentationLevel;
	
	
	Tag(String name){
		this.name = name;
	}
	
	Tag(String name, int i ){
		this.name = name;
		indentationLevel = i;
	}
	
	String getClosingTag(){
		return "</" + this.name + ">";
	}
}