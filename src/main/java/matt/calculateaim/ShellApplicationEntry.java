package matt.calculateaim;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.springframework.boot.CommandLineRunner;

import lombok.extern.slf4j.Slf4j;
import matt.calculateaim.args.Args;

@Slf4j
public class ShellApplicationEntry implements CommandLineRunner {
	
	@Override
	public void run(String... args) throws Exception {
		log.info("Processing args");
		String inputVideoPathString = Args.INPUT_VIDEO_DEFAULT_TEST_VALUE;
		String outputDirectoryPathString = Args.OUTPUT_DIRECTORY_DEFAULT_TEST_VALUE;

		for (String arg: args) {
			String[] tokens = arg.split("=");
			String key = tokens[0];
			String value = tokens[1];
			if (key.equalsIgnoreCase(Args.INPUT_VIDEO_ARG_NAME)) {
				inputVideoPathString = value;
			}
			else if (key.equalsIgnoreCase(Args.OUTPUT_DIRECTORY_ARG_NAME)) {
				outputDirectoryPathString = value;
			}
		}
		File outputDirectory = new File(outputDirectoryPathString);
		if (outputDirectory.exists()) {
			FileUtils.deleteDirectory(outputDirectory);
		}
		
		log.info("Program Completed, exiting...");
		System.exit(0);
	}
	
}
