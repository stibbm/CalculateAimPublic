package matt.calculateaim.python;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

@Slf4j
public class PythonInvoker {
	public void runPython(
		String pythonInterpreter,
		String pythonScriptPathString,
		List<String> args
	) {
		List<String> command = new ArrayList<>();
		command.add(pythonInterpreter);
		command.add(pythonScriptPathString);
		command.addAll(args);
		ProcessBuilder pb = new ProcessBuilder(command);
		Process process = null;
		try {
			process = pb.start();
			BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
			BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));
			String outputLine = null;
			while ((outputLine = stdInput.readLine())!=null) {
				log.info(outputLine);
			}

			String errorLine = null;
			while ((errorLine = stdError.readLine())!=null) {
				log.error(errorLine);
			}

			Integer exitCode = process.waitFor();
			log.info("Python script completed with exit code: " + exitCode.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (process!=null) {
				process.destroy();
			}
		}
	}
}
