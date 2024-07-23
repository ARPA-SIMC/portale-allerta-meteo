package allerta.search.portlet;

import com.liferay.portal.kernel.servlet.SessionErrors;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CommandContext {
	
	public String input, output;
	
	public CommandContext(String in, String out) {
		input = in!=null?in:"";
		output = out!=null?out:"";
	}
	
	public void execute() throws Exception {
		
		Process p = Runtime.getRuntime().exec(input);
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String line;
		while ((line= reader.readLine()) != null) {
			output+=line+"\n";
		}
		reader.close();
		
		reader = new BufferedReader(new InputStreamReader(p.getErrorStream()));
		String error="";
		while ((line= reader.readLine()) != null) {
			error+=line+"\n";
		}
		reader.close();
		if (!error.equals("")) throw new Exception(error);
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}
	
	

}
