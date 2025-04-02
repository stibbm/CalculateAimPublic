package matt.calculateaim.args;

public class Args {
	public static final String INPUT_VIDEO_ARG_NAME = "inputVideo";
	public static final String INPUT_VIDEO_DEFAULT_TEST_VALUE = "v1.mp4";
	
	public static final String OUTPUT_DIRECTORY_ARG_NAME = "outputDirectory";
	public static final String OUTPUT_DIRECTORY_DEFAULT_TEST_VALUE = "outputDirectory_" + INPUT_VIDEO_DEFAULT_TEST_VALUE.substring(0, INPUT_VIDEO_DEFAULT_TEST_VALUE.length() - 4);
}
